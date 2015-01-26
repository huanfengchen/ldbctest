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
        System.out.println("老师要批改的学生");
        Scanner scanner = new Scanner(System.in);
        int studentnumber, studentscore;

        studentscore = scanner.nextInt();
        studentnumber = scanner.nextInt();
        AddHomeWork.Teachercorrectwork(studentscore, studentnumber);


        System.out.println("老师登录成功");
        System.out.println("查看学生名单:");
        Addnum.Lookallstudent();//查看学生名单;
        System.out.println("查看没有批改的学生名单:");
        AddHomeWork.Notdowork();//查看没有批改的学生名单
        System.out.println("查看批改完的学生名单:");
        AddHomeWork.correctvoer();//查看批改完的学生名单
        System.out.println("查看某个学生的信息;");
        AddHomeWork.findHomworkByNumno("13");//查看某个学生的信息*/

    }
}
