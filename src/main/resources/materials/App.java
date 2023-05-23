package materials;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
       Storage storage = Storage.getInstance1();
    //storage.executeUpdate("DROP TABLE test_table");
    }
}
