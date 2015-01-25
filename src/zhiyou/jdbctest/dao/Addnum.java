package zhiyou.jdbctest.dao;

import zhiyou.jdbctest.Link;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by zhiyou on 15-1-24.
 */
public  class Addnum {
    public static void insert(String numno, String name) throws SQLException {
        Connection conn = null;
        String sql;
        try {
            conn= Link.connect();
            Statement stmt = conn.createStatement();
            sql = "insert into persons(numno, name) values('"+numno+"', '"+name+"');";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
    public static void findname(String number){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql;

        try {
            conn =Link.connect() ;

            stmt = conn.createStatement();

            sql = "select name from persons s where  s.numno='" + number + "'";
            rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
            while (rs.next()) {
//                System.out.println(rs);
                System.out.println(rs.getString(1) );// 入如果返回的是int类型可以用getInt()
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Link.free(rs,stmt,conn);
            // conn.close();
        }
    }
  }


