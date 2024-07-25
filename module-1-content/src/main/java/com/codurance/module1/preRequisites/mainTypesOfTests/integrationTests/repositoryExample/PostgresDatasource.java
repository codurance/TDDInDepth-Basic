package com.codurance.module1.preRequisites.mainTypesOfTests.integrationTests.repositoryExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDatasource {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String password = "postgres";
    private String user = "postgres";

    public PostgresDatasource(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
