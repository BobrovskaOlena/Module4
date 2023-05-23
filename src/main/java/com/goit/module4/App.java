package com.goit.module4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws SQLException {
       Storage storage = Storage.getInstance1();
    //storage.executeUpdate("DROP TABLE test_table");
    }
}
