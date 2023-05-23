package com.goit.module4;

import java.sql.Connection;

public class DatabaseInitService {
    public static void main(String[] args) {
        //завдання 1
        Connection connection = H2Database.getInstance().getH2Connection();
        //завдання 2

    }
}
