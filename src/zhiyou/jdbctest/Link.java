package zhiyou.jdbctest;

import java.sql.*;

/**
 * Created by zhiyou on 15-1-24.
 */
public  class Link {
    public static Connection connect(){
        Connection conn = null;
        try {

            String url = "jdbc:mysql://localhost:3306/student?"
                    + "user=root&password=zhiyou&useUnicode=true&characterEncoding=UTF8";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            return conn;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void free(ResultSet rs, Statement stmt, Connection conn) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
