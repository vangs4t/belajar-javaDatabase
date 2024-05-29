package percobaan;

import Utility.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {
    @Test
    void StatementTestJ() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement =  connection.createStatement();
        String update = """
                DELETE FROM jdbc WHERE id = 2
                """;
        int hasil = statement.executeUpdate(update);
        System.out.println(hasil);
        statement.close();
        connection.close();
    }

    @Test
    void StatementTestResult() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement =  connection.createStatement();
        String update = """
                SELECT * FROM jdbc
                """;
        ResultSet set = statement.executeQuery(update);
        set.close();
        statement.close();
        connection.close();
    }
}
