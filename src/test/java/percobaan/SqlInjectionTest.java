package percobaan;

import Utility.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInjectionTest {
    @Test
    void SqlIjectrionTest() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement =  connection.createStatement();
        String username = "admin";
        String password = "admin";
        String update = "SELECT * FROM staff WHERE username = '"+username+"' AND password = '"+password+"'";
        ResultSet set = statement.executeQuery(update);
        if (set.next()){
            System.out.println("Sukses Login");
        } else {
            System.out.println("Gagal Login");
        }
        set.close();
        statement.close();
        connection.close();
    }
}
