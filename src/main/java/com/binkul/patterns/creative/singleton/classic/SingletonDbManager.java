package com.binkul.patterns.creative.singleton.classic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * Call it as:
 * Connection conn = SingletonDbManager.getInstance().getConnection();
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

public class SingletonDbManager {
    private final Connection conn;
    private static SingletonDbManager singletonDbManager = null;

    private SingletonDbManager() throws SQLException {
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "user");
        connectionProperties.put("password", "password");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_name?serverTimezone=Europe/Warsaw&useSSL=false" +
                "&allowPublicKeyRetrieval=true", connectionProperties);
    }

    public static SingletonDbManager getInstance() throws SQLException {
        if (singletonDbManager == null) {
            synchronized (SingletonDbManager.class) {
                if (singletonDbManager == null) {
                    singletonDbManager = new SingletonDbManager();
                }
            }
        }
        return singletonDbManager;
    }

    public Connection getConnection() {
        return conn;
    }
}
