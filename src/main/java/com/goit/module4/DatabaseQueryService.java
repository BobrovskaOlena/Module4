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
    Connection connection = H2Database.getInstance().getH2Connection();

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        String sqlFilePath = "src/main/resources/com/goit/module4/sql/find_max_salary_worker.sql";
        List<MaxSalaryWorker> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath));
             Statement statement = connection.createStatement()) {
            String query1 = reader.readLine();
            ResultSet resultSet = statement.executeQuery(query1);

            while (resultSet.next()) {
                long id = resultSet.getLong("ID");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("BIRTHDAY");
                String level = resultSet.getString("level");
                int salary = resultSet.getInt("SALARY");
                MaxSalaryWorker worker1 = new MaxSalaryWorker(id, name, birthday, level, salary);
                result.add(worker1);
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
    public List<MaxProjectCountClient> findMaxProjectsClient() {
        String sqlFilePath = "src/main/resources/com/goit/module4/sql/find_max_projects_client.sql";
        List<MaxProjectCountClient> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath));
             Statement statement = connection.createStatement()) {

            String query2 = reader.readLine();
            ResultSet resultSet = statement.executeQuery(query2);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int projectCount = resultSet.getInt("project_count");
                MaxProjectCountClient client = new MaxProjectCountClient(name, projectCount);
                result.add(client);
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
    public List<LongestProject> findLongestProject() {
        String sqlFilePath = "src/main/resources/com/goit/module4/sql/find_longest_project.sql";
        List<LongestProject> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath));
             Statement statement = connection.createStatement()) {

            String query3 = reader.readLine();
            ResultSet resultSet = statement.executeQuery(query3);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                int months = resultSet.getInt("months");
                LongestProject project = new LongestProject(id, months);
                result.add(project);
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public List<YoungerAndOldestWorker> findYoungestAndEldestWorkers() {
        String sqlFilePath = "src/main/resources/com/goit/module4/sql/find_youngest_eldest_workers.sql";
        List<YoungerAndOldestWorker> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath));
             Statement statement = connection.createStatement()) {

            String query4 = reader.readLine();
            ResultSet resultSet = statement.executeQuery(query4);

            while (resultSet.next()) {
                String type = resultSet.getString("TYPE");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");
                YoungerAndOldestWorker youngerAndOldestWorker = new YoungerAndOldestWorker(type, name, birthday);
                result.add(youngerAndOldestWorker);
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public List<ProjectPrice> printProjectPrices() {
        String sqlFilePath = "src/main/resources/com/goit/module4/sql/print_project_prices.sql";
        List<ProjectPrice> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath));
             Statement statement = connection.createStatement()) {

            String query5 = reader.readLine();
            ResultSet resultSet = statement.executeQuery(query5);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                double projectCost = resultSet.getDouble("project_cost");
                ProjectPrice projectPrice = new ProjectPrice(id, projectCost);
                result.add(projectPrice);
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
    public static void main(String[] args) {
        DatabaseQueryService queryService = new DatabaseQueryService();
        //List<MaxSalaryWorker> maxSalaryWorkers = queryService.findMaxSalaryWorker();
        //List<MaxProjectCountClient> maxProjectCountClients = queryService.findMaxProjectsClient();
        //List<LongestProject> longestProjects = queryService.findLongestProject();
        //List<YoungerAndOldestWorker> youngerAndOldestWorkers = queryService.findYoungestAndEldestWorkers();
        List<ProjectPrice> projectPrices = queryService.printProjectPrices();
    }
}