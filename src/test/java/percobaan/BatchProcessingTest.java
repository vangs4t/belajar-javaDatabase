package percobaan;

import Utility.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingTest {
    @Test
    void BatchTest() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        String result = "INSERT INTO jdbc (nama,email, komen) VALUES ('jhon','buraong@gmail.com','Selamat Belajar')";
        for (int i = 0; i < 100; i++) {
            statement.addBatch(result.substring(0, 58) + i + result.substring(60));
        }
        statement.executeBatch();
        statement.close();
        connection.close();
    }

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

    @Test
    void soutin() {
        String result = "INSERT INTO jdbc (nama,email, komen) VALUES (?,?,?)";
        System.out.println(result.length());
    }
}
