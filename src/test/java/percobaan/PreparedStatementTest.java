package percobaan;

import Utility.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementTest {
    @Test
    void preparedStatements() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String username = "admin";
        String password = "admin";
        String update = "SELECT * FROM staff WHERE username = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(update);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet set = statement.executeQuery();
        if (set.next()){
            System.out.println("Benar");
        } else {
            System.out.println("Salah");
        }
        statement.close();
        connection.close();
    }
}
