package com.codurance.module1.preRequisites.mainTypesOfTests.integrationTests.repositoryExample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
class PostgresProductRepositoryShould {
    private final String databaseName = "postgres";
    private final String username = "postgres";
    private final String password = "postgres";

    @Container
    private final PostgreSQLContainer postgresContainer = new PostgreSQLContainer()
        .withDatabaseName(databaseName)
        .withUsername(username)
        .withPassword(password);

    private PostgresProductRepository postgresProductRepository;

    @BeforeEach
    public void setUp() {
        String url = "jdbc:postgresql://localhost:" + postgresContainer.getMappedPort(5432) + "/" + databaseName;
        PostgresDatasource postgresDatasource = new PostgresDatasource(url, username, password);

        createProductsTable(postgresDatasource);
        postgresProductRepository = new PostgresProductRepository(postgresDatasource);
    }

    @Test
    public void createAndRetrieveProduct() {
        UUID id = UUID.randomUUID();
        Product television = new Product(id, "Television", "Ultra high definition", 500.00);

        postgresProductRepository.create(television);

        Optional<Product> maybeTelevision = postgresProductRepository.findById(id);

        assertEquals(Optional.of(television), maybeTelevision);
    }

    private void createProductsTable(PostgresDatasource postgresDatasource) {
        try (Connection conn = postgresDatasource.getConnection();
             Statement statement = conn.createStatement()) {

            String migrationSql = """
                CREATE TABLE IF NOT EXISTS "product" (
                    "id" UUID PRIMARY KEY,
                    "name" TEXT NOT NULL,
                    "description" TEXT NOT NULL,
                    "price" DOUBLE PRECISION NOT NULL
                );
                """;
            statement.execute(migrationSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}