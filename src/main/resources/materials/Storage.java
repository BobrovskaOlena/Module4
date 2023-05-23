package materials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Storage {
    private static final Storage INSTANCE1 = new Storage();
    private Connection connection1;
    private Storage(){
        try {String connectionUrl = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL);
            connection1 = DriverManager.getConnection(connectionUrl);
            Statement statement1 = connection1.createStatement();

            statement1.executeUpdate("CREATE TABLE test_table (name VARCHAR(100))");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static Storage getInstance1(){
        return INSTANCE1;
    }
    public Connection getConnection1(){
        return connection1;
    }
    public int executeUpdate(String sql){
        try(Statement st = connection1.createStatement()) {
            return st.executeUpdate(sql);
        } catch (Exception e){
       e.printStackTrace();
       return -1;
        }
    }
    public void close(){
        try {
            connection1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
