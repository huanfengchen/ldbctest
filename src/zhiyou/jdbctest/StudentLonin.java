package zhiyou.jdbctest;

import zhiyou.jdbctest.dao.AddHomeWork;
import zhiyou.jdbctest.dao.Addnum;
import zhiyou.jdbctest.mode.Homework;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by zhiyou on 15-1-25.
 */
public class StudentLonin {

    public static int lonin() throws SQLException {

        System.out.print("请输入学号：");
        Scanner scanner=new Scanner(System.in);
        int a,b,c;
        a = scanner.nextInt();
        System.out.println(a);
    //    System.out.println("查找学生的名字");
       b= Addnum.findname(a);//查找学生的名字
        if(b>0) {
            System.out.println("请输入密码：");
            scanner = new Scanner(System.in);
            c = scanner.nextInt();
            if(c==a)
            System.out.println("登录成功:");
     /*       Homework homework = new Homework();
            homework.setHomeworid(6);
            homework.setOwner(a);
            homework.setAnswer("我是谁");
            homework.setScore(30);
            AddHomeWork.insert(homework);//提交试卷*/
            else
            lonin();
            System.out.println("查看登入者的分数分数;");
            Addnum.Lookupscore(a);//查看登入者的分数分数;
        }
        else
        lonin();
        return a;
    }
    /*
    public static void password(){
        int d;
        System.out.println("请输入密码：");
        Scanner scanner = new Scanner(System.in);
        d = scanner.nextInt();
        if(d==a)
    }
    */
}
