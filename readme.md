 学习数据库

标签（空格分隔）： 学习数据库mysql

---
##学习数据库
###1   开启数据库
```
    mysql -uroot -p(回车输入密码)
```

###2创 建个数据库
```
    CREATE DATABASE abccs; 
```
###3 使用数据库

  use + 数据库名
  
###4 查看所有的数据库
```
  show databases
```
  
###5 查看数据库中有哪些表
  
  show tables;
  
###6 创建一个表并把表中的id作为主键 
```
CREATE TABLE homework (  
    id INTEGER PRIMARY KEY AUTO_INCREMENT,  
    # 题号
    homeworkid INTEGER NOT NULL,  
    answer varchar(20) NOT NULL,
    owner INTEGER NOT NULL,
    score INTEGER
  ) ENGINE=MyISAM DEFAULT CHARSET=utf8;  
```   
###7 查看表中的数据

  select * from 表名;(查看所有的数据)
  
###8 向表中添加元素

   insert into table_name(col1,col2) values(value1,value2);
   
###9 删除表
   DROP TABLE  tbl_name


 
### 10 链接mysql数据库开始固定代码块的封装封装
```
public  class Link {
    public static Connection connect(){
        Connection conn = null;
        try {
            String url="jdbc:mysql://localhost:3306/student?"+"user=root&password=zhiyou&useUnicode=true&characterEncoding=UTF8";
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
}
```

### 11 加载mysql的三种方法
```
Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
// or:
com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
//or：
 new com.mysql.jdbc.Driver();
```

## 12 mysql数据库查找数据，并且查找到的数据有重复只显示一条
```
 sql = "select distinct tablename, answer, owner, score from homework h, persons s where h.score is null and s.numno=h.owner";
```
## 12 以表中的数据值为NULL为判断条件

select distinct homeworkid, answer, owner, score from homework h, persons s where **h.score is null** and s.numno=h.owner

### 13 删除表中的数据
   DELETE FROM table1（删除整个表）
   
   如果要删除表中的部分记录，只能使用DELETE语句（where是条件）
　delete from homework where id=15;
　　
### 14 更新数据库
```
  sql = " update  homework h set score="+a+" where h.id="+b;
  stmt.executeUpdate(sql);// executeQuery会返回结果的集合，否则返回空值
  ```

    
##泛型在自定义比较器中（自定义了一个Stringlist类）
```
class Stringlist implements Comparator<String>{//泛型在自定义比较器中的应用
    public int compare(String obj1,String obj2){


        int num = new Integer(obj2.length()).compareTo(new Integer(obj1.length()));
        if(num==0)
            return obj2.compareTo(obj1);//比较字符串的自然顺序
        return num;
    }
}

```
