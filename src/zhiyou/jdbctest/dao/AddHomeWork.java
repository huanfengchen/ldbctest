package zhiyou.jdbctest.dao;

import zhiyou.jdbctest.Link;
import zhiyou.jdbctest.mode.Homework;

import java.sql.*;

/**
 * Created by zhiyou on 15-1-24.
 */
public class AddHomeWork {
    public static void insert(Homework homework) throws SQLException {//向表中插入数据，
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn= Link.connect();
             preparedStatement = conn.prepareStatement(
                    "insert into homework(homeworkid, answer, owner) values(?, ?, ?)");

            preparedStatement.setInt(1, homework.getHomeworid());
            preparedStatement.setString(2, homework.getAnswer());
            preparedStatement.setInt(3, homework.getOwner());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
    public static void findHomworkByNumno(String numno) throws SQLException {//传入学生的学号，查找该学生作业情况
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql;

        try {
            conn =Link.connect() ;

            stmt = conn.createStatement();

            sql = "select numno,name, homeworkid, answer, owner, score from homework h, persons s where s.id=h.owner and  s.numno='" + numno + "'";
            rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
            while (rs.next()) {
//                System.out.println(rs);
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
                        + rs.getInt(3) + "\t" + rs.getString(4)  + "\t" + rs.getInt(5)  + "\t" + rs.getInt(6) );// 入如果返回的是int类型可以用getInt()
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
    public static void Notdowork() throws SQLException{//查看没有批改的学生
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql;

        try {
            conn =Link.connect() ;

            stmt = conn.createStatement();

            sql = "select distinct homeworkid, answer, owner, score from homework h ,persons s where h.score is null and s.numno=h.owner;";
            rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
            while (rs.next()) {
//                System.out.println(rs);
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
                        + rs.getInt(3) + "\t" + rs.getInt(4));// 入如果返回的是int类型可以用getInt()
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
    public static void Teachercorrectwork(int a,int b) throws SQLException{//查看没有批改的学生
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql;

        try {
            conn =Link.connect() ;

            stmt = conn.createStatement();
            System.out.println("b="+b+"a="+a);

            sql = " update  homework h set score="+a+" where h.id="+b;
            stmt.executeUpdate(sql);// executeQuery会返回结果的集合，否则返回空值
//            while (rs.next()) {
//                System.out.println(rs.getInt(1));// 入如果返回的是int类型可以用getInt()
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Link.free(rs,stmt,conn);
            // conn.close();
        }

    }




    public static void correctvoer() throws SQLException{//查看批改完的学生
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql;

        try {
            conn =Link.connect() ;

            stmt = conn.createStatement();

            sql = "select distinct homeworkid, answer, owner, score from homework h, persons s where h.score is not null and s.numno=h.owner;";
            rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
            while (rs.next()) {
//                System.out.println(rs);
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
                        + rs.getInt(3) + "\t" + rs.getInt(4));// 入如果返回的是int类型可以用getInt()
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


