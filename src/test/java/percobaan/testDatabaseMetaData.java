package percobaan;

import Utility.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class testDatabaseMetaData {
    @Test
    void testMetadata() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        DatabaseMetaData data = connection.getMetaData();
        System.out.println(data.getDatabaseProductName());
        System.out.println(data.getDatabaseProductVersion());
        ResultSet set = data.getTables("uniku", null, null, null);
        while (set.next()){
            System.out.println("Table : " + set.getString("TABLE_NAME"));
        }
        connection.close();
    }
    @Test
    void testParameterMetadata() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String update = """
                INSERT INTO perpus (email,title,content) VALUES (?,?,?);
                """;
        PreparedStatement statement = connection.prepareStatement(update);
        ParameterMetaData data = statement.getParameterMetaData();
        System.out.println(data.getParameterCount());

        statement.close();
        connection.close();
    }
    @Test
    void testResultSetMetaData() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String update = """
                SELECT * FROM mahasiswa;
                """;
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery(update);
        ResultSetMetaData data = set.getMetaData();
        for (int i = 1; i <= data.getColumnCount(); i++) {
            System.out.println("Name : " + data.getColumnName(i));
            System.out.println("Type : " + data.getColumnType(i));
            System.out.println("TypeName : " + data.getColumnTypeName(i));
            if (data.getColumnType(i) == Types.VARCHAR){
                System.out.println("Ini varhvar");
            }
        }
        set.close();
        statement.close();
        connection.close();
    }
}
