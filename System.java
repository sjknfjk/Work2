
import java.sql.*;
import java.util.Scanner;

public class System {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        while (true) {
            java.lang.System.out.println("学生管理系统");//student表会和class表同时增删改
            java.lang.System.out.println("1-添加学生");
            java.lang.System.out.println("2-删除学生");
            java.lang.System.out.println("3-修改学生信息");
            java.lang.System.out.println("4-退出系统");
            java.lang.System.out.println("请输入指令:");
            Scanner scanner = new Scanner(java.lang.System.in);
            String s = scanner.nextLine();
            switch (s) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    delStudent();
                    break;
                case "3":
                    modify();
                    break;
                case "4":
                    java.lang.System.out.println("谢谢使用");
                    java.lang.System.exit(0);

                    Connection connection = null;
                    Statement statement = null;
                    ResultSet set = null;
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        String dburl = "jdbc:mysql://localhost:3306/xs?useSSL=false&characterEncoding=utf-8";
                        String dbName = "root";
                        String dbPass = "T516822";
                        connection = DriverManager.getConnection(dburl, dbName, dbPass);
                        statement = connection.createStatement();
                    } catch (ClassNotFoundException e) {
                        java.lang.System.out.println("错误提示:数据库驱动加载失败");
                        e.printStackTrace();
                    } catch (SQLException e) {
                        java.lang.System.out.println("错误提示:数据库操作失败");
                        e.printStackTrace();
                    } finally {
                        if (set != null) {
                            try {
                                set.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                        if (connection != null) {
                            try {
                                connection.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                        if (statement != null) {
                            try {
                                statement.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            }
        }
    }

    public static void addStudent() throws ClassNotFoundException, SQLException {
        String dburl = "jdbc:mysql://localhost:3306/xs?useSSL=false&characterEncoding=utf-8";
        String user = "root";
        String password = "T516822";
        Class.forName("com.mysql.jdbc.Driver");

        Scanner scanner = new Scanner(java.lang.System.in);
        java.lang.System.out.println("请输入学生id:");
        int id = scanner.nextInt();
        java.lang.System.out.println("请输入学生姓名:");
        String name = scanner.next();
        java.lang.System.out.println("请输入学生性别:");
        String sex = scanner.next();
        java.lang.System.out.println("请输入学生班级:");
        String Class = scanner.next();
        java.lang.System.out.println("请输入学生入班时间:");
        String time = scanner.next();
        java.lang.System.out.println("请输入学生年龄:");
        int age = scanner.nextInt();

        Connection connection = DriverManager.getConnection(dburl, user, password);
        Statement statement = connection.createStatement();

        String sql1 = "INSERT INTO class values('"+name+"',"+id+","+age+",'"+sex+"','"+Class+"','"+time+"')";
        String sql2="INSERT INTO student('"+name+"',"+id+","+age+",'"+sex+"')";
        statement.executeUpdate(sql1);
        statement.executeUpdate(sql2);

        java.lang.System.out.println("添加成功");
        connection.close();

    }
    public static void delStudent() throws ClassNotFoundException, SQLException {
        String dburl = "jdbc:mysql://localhost:3306/xs?useSSL=false&characterEncoding=utf-8";
        String user = "root";
        String password = "T516822";
        Class.forName("com.mysql.jdbc.Driver");

        Scanner scanner = new Scanner(java.lang.System.in);
        java.lang.System.out.println("请输入要删除学生的id");
        int delId = scanner.nextInt();

        Connection connection = DriverManager.getConnection(dburl, user, password);
        Statement statement = connection.createStatement();

        String sql1 = "delete from student where id = " +delId+"";
        String sql2="delete from class where id = " +delId+"";
        statement.executeUpdate(sql1);
        statement.executeUpdate(sql2);

        java.lang.System.out.println("删除成功");
        connection.close();

    }

    public static void modify() throws ClassNotFoundException, SQLException{
        String dburl = "jdbc:mysql://localhost:3306/xs?useSSL=false&characterEncoding=utf-8";
        String user = "root";
        String password = "T516822";
        Class.forName("com.mysql.jdbc.Driver");
        Scanner scanner = new Scanner(java.lang.System.in);
        java.lang.System.out.println("请输入修改前的学生id:");
        int id1 = scanner.nextInt();
        java.lang.System.out.println("请输入修改后的学生id:");
        int id2 = scanner.nextInt();
        java.lang.System.out.println("请输入修改后学生姓名:");
        String name2 = scanner.next();
        java.lang.System.out.println("请输入修改后学生性别:");
        String sex2 = scanner.next();
        java.lang.System.out.println("请输入修改后学生班级:");
        String Class2 = scanner.next();
        java.lang.System.out.println("请输入修改后学生入班时间:");
        String time2= scanner.next();
        java.lang.System.out.println("请输入修改前的学生年龄:");
        int age2 = scanner.nextInt();

        Connection connection = DriverManager.getConnection(dburl, user, password);
        Statement statement = connection.createStatement();

        String sql1 = "UPDATE student SET id = "+id2+",name = '"+name2+"',age="+age2+",sex='"+sex2+"' WHERE id = "+id1+";";
        String sql2 = "UPDATE class SET id = "+id2+",name = '"+name2+"',age="+age2+",sex='"+sex2+"',Class='"+Class2+"',time='"+time2+"' WHERE id = "+id1+";";
        statement.executeUpdate(sql1);
        statement.executeUpdate(sql2);

        java.lang.System.out.println("修改成功");
        connection.close();
    }
}