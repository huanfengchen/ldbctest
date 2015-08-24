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
    public static int findname(int number){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int a=0;

        String sql;

        try {
            conn =Link.connect() ;

            stmt = conn.createStatement();

            sql = "select name from persons s where  s.numno='" + number + "';";
            rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
            while (rs.next()) {
//                System.out.println(rs);
                System.out.println(rs.getString(1) );// 入如果返回的是int类型可以用getInt()
                a++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Link.free(rs,stmt,conn);
            // conn.close();
        }
        return a;
    }
    public static void Lookupscore(int number){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        try {
            conn =Link.connect() ;

            stmt = conn.createStatement();

            sql = "select score from homework s where  s.owner='" + number + "';";
            rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
            while (rs.next()) {
//                System.out.println(rs);
                System.out.println(rs.getInt(1) );// 入如果返回的是int类型可以用getInt()

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
    public static void Lookallstudent(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        try {
            conn =Link.connect() ;

            stmt = conn.createStatement();

            sql = "select numno, name from persons;";
            rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
            while (rs.next()) {
               System.out.println("hhhhhh");
                System.out.println(rs.getString(1) +"\t"+ rs.getString(2) );// 入如果返回的是int类型可以用getInt()

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


