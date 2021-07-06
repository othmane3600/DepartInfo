package metier;
import java.sql.Connection;
import java.sql.DriverManager;
public class SingletonConnection {
private static Connection connection;

    private static Connection ret = null;

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String mysqlConnUrl = "jdbc:mysql://localhost:3306/departement";

            String mysqlUserName = "root";

            String mysqlPassword = "maataoui123=";

            ret = DriverManager.getConnection(mysqlConnUrl, mysqlUserName, mysqlPassword);

            System.out.println("HH");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ret;

    }





}