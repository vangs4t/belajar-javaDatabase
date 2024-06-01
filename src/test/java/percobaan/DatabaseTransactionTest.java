package percobaan;

import Utility.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseTransactionTest {
    @Test
    void transactionTest() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        connection.setAutoCommit(false);
        String result = "INSERT INTO orders (total) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(result);
        for (int i = 0; i < 100; i++) {
            statement.clearParameters();
            statement.setString(1, String.valueOf(i));
            statement.executeUpdate();
        }
        connection.rollback();
        statement.close();
        connection.close();
    }
}
