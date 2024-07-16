package com.codurance.module1.preRequisites.mainTypesOfTests.integrationTests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

public class PostgresProductRepository implements ProductRepository {
    private final PostgresDatasource datasource;

    public PostgresProductRepository(PostgresDatasource connection) {
        this.datasource = connection;
    }

    @Override
    public void create(Product product) {
        String sql = "INSERT INTO product (id, name, description, price) VALUES (?, ?, ?, ?)";
        try (Connection sqlConnection = datasource.getConnection()) {
            PreparedStatement preparedStatement = sqlConnection.prepareStatement(sql);

            preparedStatement.setObject(1, product.id);
            preparedStatement.setObject(2, product.name);
            preparedStatement.setObject(3, product.description);
            preparedStatement.setObject(4, product.price);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Product> findById(UUID id) {
        Product product = null;
        String sql = "SELECT * FROM product WHERE id = ?";
        try (Connection sqlConnection = datasource.getConnection()) {
            PreparedStatement preparedStatement = sqlConnection.prepareStatement(sql);
            preparedStatement.setObject(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = new Product(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getDouble("price")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(product);
    }
}
