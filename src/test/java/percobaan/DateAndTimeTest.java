package percobaan;

import Utility.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class DateAndTimeTest {
    @Test
    void CurrentTime() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String result = """
                INSERT INTO sample_time (simple_time,simple_date,simpe_timestamp) values (?,?,?);
                """;
        PreparedStatement statement = connection.prepareStatement(result);
        statement.setTime(1, new Time(System.currentTimeMillis()));
        statement.setDate(2, new Date(System.currentTimeMillis()));
        statement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));


        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}
