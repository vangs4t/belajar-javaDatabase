package percobaan;

import Utility.ConnectionUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestApp {

    @BeforeAll
    static void testingDriver(){
        try{
            Driver driver = new org.mariadb.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e){
            fail(e);
        }
    }

    @Test
    void connectionJDBC() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/uniku?user=root&password=1234");
            System.out.println("Sukses membuat aplikasi");
            connection.close();
        } catch (SQLException e){
            fail(e);
        }
    }

    @Test
    void connectionJDBClose() {
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/uniku?user=root&password=1234")){
            System.out.println("Sukses membuat aplikasi");
        } catch (SQLException e){
            fail(e);
        }
    }

    @Test
    void conncetionPollTest() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/uniku");
        config.setUsername("root");
        config.setPassword("1234");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(10 * 60_000);

        try {
            HikariDataSource source = new HikariDataSource(config);
            Connection connection = source.getConnection();
        } catch (SQLException e){
            fail(e);
        }
    }

    @Test
    void testUtil() throws SQLException{
        Connection util = ConnectionUtil.getDataSource().getConnection();
    }
}
