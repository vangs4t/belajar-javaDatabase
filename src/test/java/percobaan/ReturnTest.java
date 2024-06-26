package percobaan;

import Utility.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReturnTest {

    @Test
    void ResultTest() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement =  connection.createStatement();
        String update = """
                SELECT * FROM mahasiswa
                """;
        ResultSet set = statement.executeQuery(update);
        while (set.next()){
            String nama = set.getString("nama");
            int nim = set.getInt("nim");
            String email = set.getString("email");
            System.out.println(String.join(", ", nama,String.valueOf(nim),email));
        }
        set.close();
        statement.close();
        connection.close();
    }
}
