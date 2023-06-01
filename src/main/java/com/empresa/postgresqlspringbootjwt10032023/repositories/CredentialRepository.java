package com.empresa.postgresqlspringbootjwt10032023.repositories;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.empresa.postgresqlspringbootjwt10032023.models.Credential;

public class CredentialRepository {
    public List<Credential> findAll() {

        List<Credential> credentials = new ArrayList<Credential>();

        try {
            String url = "jdbc:postgresql://localhost:5432/postgresql_springboot_jwt_10032023_db";
            String myUser = "postgres";
            String myPassword = "postgres";
            String sql_query = "select * from credentials;";
            Connection connection = DriverManager.getConnection(url, myUser, myPassword);
            PreparedStatement preparedStatement = connection.prepareStatement(sql_query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Credential credential = new Credential();
                credential.setId(resultSet.getInt("id"));
                credential.setEmail(resultSet.getString("email"));
                credential.setPassword(resultSet.getString("password"));
                credential.setCreatedAt(resultSet.getTimestamp("created_at"));
                credential.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                credentials.add(credential);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return credentials;
    }

    public void save(Credential Credential) {
        try {
            String url = "jdbc:postgresql://localhost:5432/postgresql_springboot_jwt_10032023_db";
            String myUser = "postgres";
            String myPassword = "postgres";
            String sql_query = "insert into Credentials (email, password, created_at, updated_at) values (?, ?, current_timestamp, current_timestamp);";
            Connection connection = DriverManager.getConnection(url, myUser, myPassword);
            PreparedStatement preparedStatement = connection.prepareStatement(sql_query);
            preparedStatement.setString(1, Credential.getEmail());
            preparedStatement.setString(2, Credential.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
}