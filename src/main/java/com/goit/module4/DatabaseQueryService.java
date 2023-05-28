package com.goit.module4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private H2Database h2Database;

    public DatabaseQueryService() {
        h2Database = H2Database.getInstance();
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        String sqlFilePath = "src/main/resources/com/goit/module4/sql/find_max_salary_worker.sql";
        List<MaxSalaryWorker> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath));
             Connection connection = h2Database.getH2Connection();
             Statement statement = connection.createStatement()) {

            String query = reader.readLine();
            ResultSet resultSet = h2Database.executeQuery(query);

            while (resultSet.next()) {
                long id = resultSet.getLong("ID");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("BIRTHDAY");
                String level = resultSet.getString("level");
                int salary = resultSet.getInt("SALARY");
                MaxSalaryWorker worker = new MaxSalaryWorker(id, name, birthday, level, salary);
                result.add(worker);
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
    public static void main(String[] args) {
        DatabaseQueryService queryService = new DatabaseQueryService();
        List<MaxSalaryWorker> maxSalaryWorkers = queryService.findMaxSalaryWorker();
    }
}