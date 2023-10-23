package board;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DB 연결
 */
public class ServiceManager {
    /**
     * properties에서 DB 연결
     * 
     * @return
     */
    protected Connection getConnection() {
        Properties properties = new Properties();
        Connection connection = null;
        InputStream is = this.getClass().getResourceAsStream("/resources/board.properties");

        try {
            properties.load(is);
            String driver = properties.getProperty("database.driver");
            String url = properties.getProperty("database.url");
            String username = properties.getProperty("database.user");
            String password = properties.getProperty("database.password");

            Class.forName(driver);
            // System.out.println("true이면 연결 안 됨 :" + connection == null);
            connection = DriverManager.getConnection(url, username, password);
            if (connection == null) {
                System.out.println("연결 안됨");
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return connection;
    }
}
