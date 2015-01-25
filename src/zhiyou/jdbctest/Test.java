package zhiyou.jdbctest;

import zhiyou.jdbctest.dao.AddHomeWork;
import zhiyou.jdbctest.dao.Addnum;
import zhiyou.jdbctest.mode.Homework;

import java.sql.SQLException;

/**
 * Created by zhiyou on 15-1-24.
 */
public class Test extends Exception {
    public static void main(String[] args) throws SQLException {
      //   Addnum.insert("12", "张明");
       Addnum.findname("12");
/*
        Homework homework = new Homework();
        homework.setHomeworid(12);
        homework.setOwner(12);
        homework.setAnswer("answer13");
        homework.setScore(98);
        AddHomeWork.insert(homework);*/
       // AddHomeWork.findHomworkByNumno("13");
       // AddHomeWork.Notdowork();
    }
}
