package percobaan;

import Utility.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class AutoIncrementTest {
    @Test
    void BatchPreparedTest() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String result = "INSERT INTO jdbc (nama, email, komen) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(result, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, "Acumalaka");
        statement.setString(2, "buraonoiag@gmail.com");
        statement.setString(3, "Selamat Datang");

        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()){
            int id = resultSet.getInt(1);
            System.out.println("generated id = "+ id);
        }
        statement.executeUpdate();
        resultSet.close();
        statement.close();
        connection.close();
    }
}
