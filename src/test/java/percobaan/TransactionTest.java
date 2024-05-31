package percobaan;

import Utility.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {
    @Test
    void BatchPreparedTest() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String result = "INSERT INTO jdbc (nama,email, komen) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(result);
        for (int i = 0; i < 100; i++) {
            statement.clearParameters();
            statement.setString(1, "Jhon");
            statement.setString(2, "buraong"+i+"@gmail.com");
            statement.setString(3, "Selamat Datang");
            statement.addBatch();
        }
        statement.executeBatch();
        statement.close();
        connection.close();
    }
}
