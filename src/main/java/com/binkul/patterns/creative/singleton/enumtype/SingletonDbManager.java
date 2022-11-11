package com.binkul.patterns.creative.singleton.enumtype;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * Call it as:
 * Connection conn = SingletonDbManager.INSTANCE.getConnection();
 * Statement statement = conn.createStatement();
 * String sql = "Select count(*) as amount From users";
 * ResultSet set = statement.executeQuery(sql);
 * setCount.next();
 * int count = setCount.getInt("amount");
 * setCount.close();
 * <p>
 * sql = "Select * From users";
 * set = statement.executeQuery(sql);
 * while (set.next()) {
 *      System.out.println(set.getInt("ID") + ", " + set.getString("FIRSTNAME") + ", " + set.getString("LASTNAME"));
 * }
 * set.close();
 * statement.close();
 *
 */

public enum SingletonDbManager {
    INSTANCE;

    private Connection connection;
    private String status;

    SingletonDbManager() {
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "user");
        connectionProperties.put("password", "password");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_name?serverTimezone=Europe/Warsaw&useSSL=false" +
                    "&allowPublicKeyRetrieval=true", connectionProperties);
            status = "Connection established ...";
        } catch (SQLException ex) {
            connection = null;
            status = "Connection is failed.";
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public String getStatus() {
        return status;
    }
}
