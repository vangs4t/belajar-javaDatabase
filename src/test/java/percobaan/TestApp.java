package percobaan;

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
}
