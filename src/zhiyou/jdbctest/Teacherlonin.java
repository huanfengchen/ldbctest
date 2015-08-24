package zhiyou.jdbctest;

import zhiyou.jdbctest.dao.AddHomeWork;
import zhiyou.jdbctest.dao.Addnum;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by zhiyou on 15-1-25.
 */
public class Teacherlonin {
    public static void lookup() throws SQLException {
      //  System.out.println("输入 0 老师处理完毕");
        System.out.println("输入 1 查看学生名单");
        System.out.println("输入 2 查看没有批改的学生名单");
     //   System.out.println("输入 2 查看没有批改的学生名单");
     //   System.out.println("输入 3 查看批改完的学生名单");
        System.out.println("输入 4 查看某个学生的信息");
        System.out.println("其他结束");
    //    System.out.println("输入 2 老师要批改的学生");
        select();


    }
    public static void select() throws SQLException {
        int a;
        Scanner scanner0 = new Scanner(System.in);
        a=scanner0.nextInt();
//        if(a==0){
//           System.out.println("老师处理完毕");
//        }
        if(a==1){
            System.out.println("查看学生名单:");
            Addnum.Lookallstudent();//查看学生名单;
            System.out.println("输入2批改要批改的学生");
            select();
        }

        if(a==2){
            System.out.println("查看没有批改的学生名单");

            AddHomeWork.Notdowork();//查看没有批改的学生名单

            System.out.println("输入要批改学生的学号");
            Scanner scanner = new Scanner(System.in);
        //    String answer;

            String studentnumber,id;
            studentnumber = scanner.next();
            AddHomeWork.teachernocorrect(studentnumber);


            String studentscore;
            System.out.println("输入分数和学生作业id");
            studentscore = scanner.next();
            id = scanner.next();
            studentnumber = scanner.next();
         //   answer = scanner.next();
            AddHomeWork.Teachercorrectwork(studentscore,id,studentnumber);
            System.out.println("输入 1 查看学生名单");
            System.out.println("输入 2 查看没有批改的学生名单");
            //   System.out.println("输入 2 查看没有批改的学生名单");
            //   System.out.println("输入 3 查看批改完的学生名单");
            System.out.println("输入 4 查看某个学生的信息");
            System.out.println("其他结束");
            select();
        }



//            System.out.println("查看没有批改的学生名单:");
//            AddHomeWork.Notdowork();//查看没有批改的学生名单
//           select();
//        }


//        if(a==3){
//            System.out.println("查看批改完的学生名单:");
//            AddHomeWork.correctvoer();//查看批改完的学生名单
//            select();
//        }

        if(a==4) {
            Addnum.Lookallstudent();//查看学生名单;
            System.out.print("请输入学生学号：");
            int x;
            Scanner scanner = new Scanner(System.in);
            x= scanner.nextInt();
            AddHomeWork.findHomworkByNumno(x);//查看某个学生的信息*/
            System.out.println("输入 1 查看学生名单");
            System.out.println("输入 2 老师要批改的学生");
            //   System.out.println("输入 2 查看没有批改的学生名单");
            //   System.out.println("输入 3 查看批改完的学生名单");
            System.out.println("输入 4 查看某个学生的信息");
            System.out.println("其他结束");
            select();
        }

    }
}
