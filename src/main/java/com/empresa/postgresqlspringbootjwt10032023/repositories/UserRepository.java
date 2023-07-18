package com.empresa.postgresqlspringbootjwt10032023.repositories;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.empresa.postgresqlspringbootjwt10032023.models.User;
import com.empresa.postgresqlspringbootjwt10032023.models.UserEntity;
import com.empresa.postgresqlspringbootjwt10032023.models.Credential;

public class UserRepository {
    public List<User> findAll() {

        List<User> users = new ArrayList<User>();

        try {
            String url = "jdbc:postgresql://localhost:5432/postgresql_springboot_jwt_10032023_db";
            String myUser = "postgres";
            String myPassword = "postgres";
            String sql_query = "select * from users;";
            Connection connection = DriverManager.getConnection(url, myUser, myPassword);
            PreparedStatement preparedStatement = connection.prepareStatement(sql_query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setCreatedAt(resultSet.getTimestamp("created_at"));
                user.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return users;
    }

    public UserEntity findUserById(int id) {

        UserEntity userEntity = new UserEntity();
        List<Credential> credentials = new ArrayList<Credential>();

        try {
            String url = "jdbc:postgresql://localhost:5432/postgresql_springboot_jwt_10032023_db";
            String myUser = "postgres";
            String myPassword = "postgres";
            String sql_query = ""
                + "select "
                + "u.id as userId,"
                + "u.name,"
                + "u.created_at as userCreatedAt,"
                + "u.updated_at as userUpdatedAt,"
                + "c.id as credentialId,"
                + "c.user_id as credentialUserId,"
                + "c.email,"
                + "c.password,"
                + "c.created_at as credentialCreatedAt,"
                + "c.updated_at as credentialUpdatedAt "
                + "from users u "
                + "left join credentials c on c.user_id = u.id "
                + "where u.id = ?;";
            Connection connection = DriverManager.getConnection(url, myUser, myPassword);
            PreparedStatement preparedStatement = connection.prepareStatement(sql_query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Credential credential = new Credential();

                userEntity.setId(resultSet.getInt("userId"));
                userEntity.setName(resultSet.getString("name"));
                userEntity.setCreatedAt(resultSet.getTimestamp("userCreatedAt"));
                userEntity.setUpdatedAt(resultSet.getTimestamp("userUpdatedAt"));

                credential.setId(resultSet.getInt("credentialId"));
                credential.setUserId(resultSet.getInt("credentialUserId"));
                credential.setEmail(resultSet.getString("email"));
                credential.setPassword(resultSet.getString("password"));
                credential.setCreatedAt(resultSet.getTimestamp("credentialCreatedAt"));
                credential.setUpdatedAt(resultSet.getTimestamp("credentialUpdatedAt"));
                credentials.add(credential);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        userEntity.setCredentials(credentials);
        return userEntity;
    }

    public int save(User user) {
        int userIdReturned = 0;

        try {
            String url = "jdbc:postgresql://localhost:5432/postgresql_springboot_jwt_10032023_db";
            String myUser = "postgres";
            String myPassword = "postgres";
            String sql_query = "insert into users (name, created_at, updated_at) values (?, current_timestamp, current_timestamp) returning id;";
            Connection connection = DriverManager.getConnection(url, myUser, myPassword);
            PreparedStatement preparedStatement = connection.prepareStatement(sql_query);
            preparedStatement.setString(1, user.getName());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                userIdReturned = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return userIdReturned;
    }
}