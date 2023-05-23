package com.goit.module4;

import java.sql.*;

public class H2Database {
    private static final H2Database INSTANCE = new H2Database();
    private Connection h2Connection;
    private H2Database(){
        try{
            String h2ConnectionUrl = "jdbc:h2:./test";
            this.h2Connection = DriverManager.getConnection(h2ConnectionUrl);
        }catch (SQLException e){
            throw new RuntimeException("Create connection exception");
        }
    }
    public static H2Database getInstance(){
        return INSTANCE;
    }
    public Connection getH2Connection(){
        return h2Connection;
    }
    public int executeUpdate(String query){
        try (Statement statement = INSTANCE.getH2Connection().createStatement()){
            return statement.executeUpdate(query);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet executeQuery(String query) {
        try (Statement statement = INSTANCE.getH2Connection().createStatement()) {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void closeConnection(){
        try {
        h2Connection.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
