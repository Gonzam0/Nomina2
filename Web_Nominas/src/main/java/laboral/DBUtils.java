package laboral;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase de conexion con la DB
 */
public class DBUtils {
      public static Connection getConnection() throws SQLException {
        final String USER = "root";
        final String PASS = "root";
        final String DB_NAME = "pruebanominas";
        final String CONN_URL = "jdbc:mariadb://localhost:3306/" + DB_NAME;
        Connection conn = null;

        conn = DriverManager.getConnection(CONN_URL, USER, PASS);
        return conn;

    }

    public static void close(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public static void close(Statement st) throws SQLException {
        if (st != null) {
            st.close();
        }
    }

    public static void close(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
    }
}