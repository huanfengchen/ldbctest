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
        String answer;
        a = scanner.nextInt();
       // System.out.println(a);
    //    System.out.println("查找学生的名字");
       b= Addnum.findname(a);//查找学生的名字
        if(b>0) {
            System.out.println("请输入密码：");
            scanner = new Scanner(System.in);
            c = scanner.nextInt();
            if(c==a)
            System.out.println("登录成功:");


         //  System.out.println("密码输入错误"+lonin());
        //    lonin();

        }
        else
        {
            System.out.println("输入密码错误。请重新输入");
            lonin();
        }
        studentdo();

        return a;
    }
   public static void studentdo() throws SQLException {

       System.out.println("输入1提交作业");
       System.out.println("输入2查看分数");
       System.out.println("输入3重新登录");
       System.out.println("输入0结束操作");
       int y,id,d;
       String answer;
       Scanner scanner=new Scanner(System.in);
       y=scanner.nextInt();
       if(y==1){
           System.out.println("请输入id,请输入学号,请输入answer");

           Homework homework = new Homework();

           id = scanner.nextInt();
           homework.setHomeworid(id);

           d=scanner.nextInt();
           homework.setOwner(d);

           answer= scanner.next();
           homework.setAnswer(answer);
         //  homework.setScore(30);
           AddHomeWork.insert(homework);

           studentdo();

       }
       if(y==2) {
           System.out.println("查看登入者的分数;");
           System.out.println("请输入学号");
           d=scanner.nextInt();
           Addnum.Lookupscore(d);//查看登入者的分数分数;

           studentdo();
       }
       if(y==3){
           System.out.println("重新登录");
           lonin();
       }
   }
}
