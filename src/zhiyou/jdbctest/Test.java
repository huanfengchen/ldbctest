package zhiyou.jdbctest;

import zhiyou.jdbctest.dao.AddHomeWork;
import zhiyou.jdbctest.dao.Addnum;
import zhiyou.jdbctest.mode.Homework;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by zhiyou on 15-1-24.
 */
public class Test extends Exception {
    public static void main(String[] args) throws SQLException {
        System.out.println("选择1老师操作");
        System.out.println("选择2学生操作操作");
        System.out.println("其他结束程序");
        int select;
       Scanner scanner = new Scanner(System.in);
        select=scanner.nextInt();
        if(select==1)
        {
            Teacherlonin.lookup();
        }
        if(select==2) {

            StudentLonin.lonin();//学生登录并且插入homework表中，

        }
        else {
            System.out.println("操作结束");
        }

    }
}
