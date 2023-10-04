package com.empresa.postgresqlspringbootjwt10032023.repositories;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.empresa.postgresqlspringbootjwt10032023.models.Expert;
import com.empresa.postgresqlspringbootjwt10032023.responses.ExpertResponse;

public class ExpertRepository {
    ExpertResponse expertResponse = new ExpertResponse();

    // public ExpertResponse findAll() {
    //     ExpertResponse expertResponse = new ExpertResponse();
    //     List<Expert> experts = new ArrayList<Expert>();

    //     try {
    //         String dbUrl = "jdbc:postgresql://localhost:5432/postgresql_springboot_jwt_10032023_db";
    //         String dbUser = "postgres";
    //         String dbPassword = "postgres";
    //         String sqlQuery = "select * from experts";
    //         Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    //         PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
    //         ResultSet resultSet = preparedStatement.executeQuery();

    //         while (resultSet.next()) {
    //             Expert expert = new Expert();
    //             expert.setId(resultSet.getInt("id"));
    //             expert.setExpert(resultSet.getString("expert"));
    //             expert.setCreatedAt(resultSet.getTimestamp("created_at"));
    //             expert.setUpdatedAt(resultSet.getTimestamp("updated_at"));
    //             experts.add(expert);
    //         }

    //         expertResponse.setExperts(experts);
    //         expertResponse.setSqlResponse("Successfully");
    //         expertResponse.setSqlExecute(true);
    //     } catch (SQLException e) {
    //         e.printStackTrace(System.err);
    //         expertResponse.setSqlResponse(e.getMessage());
    //         expertResponse.setSqlExecute(false);
    //     }

    //     return expertResponse;
    // }

    public ExpertResponse save(Expert expert) {
        try {
            String dbUrl = "jdbc:postgresql://localhost:5432/postgresql_springboot_jwt_10032023_db";
            String dbUser = "postgres";
            String dbPassword = "postgres";
            String sqlQuery = ""
            + "insert into experts ("
            + "expert,"
            + "created_at,"
            + "updated_at"
            + ") values ("
            + "?,"
            + "current_timestamp,"
            + "current_timestamp"
            + ")";
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, expert.getExpert());
            preparedStatement.executeUpdate();
            expertResponse.setSqlResponse("Successfully Created");
            expertResponse.setSqlExecute(true);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            expertResponse.setSqlResponse(e.getMessage());
            expertResponse.setSqlExecute(false);
        }

        return expertResponse;
    }
}