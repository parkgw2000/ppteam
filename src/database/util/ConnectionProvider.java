package database.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionProvider {
    private static final Properties PROPERTIES = new Properties();

    static {
        InputStream is = null;
        try {
            ClassLoader loader = ConnectionProvider.class.getClassLoader();
            is = loader.getResourceAsStream("local.properties");

            PROPERTIES.load(is);

            // SQLite 드라이버 클래스로 변경
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Connection makeSQLiteConnection() throws SQLException {
        // SQLite 데이터베이스 파일 경로
        String databaseUrl = PROPERTIES.getProperty("sqlite.url");

        // SQLite 연결 객체 : Connection 인터페이스
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:sqlite:" + databaseUrl);
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
