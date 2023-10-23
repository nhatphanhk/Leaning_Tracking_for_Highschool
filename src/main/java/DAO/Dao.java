/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Account;
import Model.AttendanceList;
import Model.Student;
import Model.Teacher;
import Model.Class;
import Model.Mark;
import Model.Notification;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Dao implements Serializable {

    private Connection conn = DBUtil.makeConnection();
    //PreparedStatement pr =null;
    //ResultSet rs = null;
    private static Dao instance;

    public Dao() {
    }

    public static Dao getInstance() {

        if (instance == null) {
            instance = new Dao();
        }
        return instance;
    }
    private static final String SELECT_ALL_STUDENT = "SELECT * FROM student WHERE classid = ?";
    private static final String SELECT_ALL_NOTI_TEACHER = "SELECT * FROM [dbo].[notification] WHERE categoryid = ? AND classid = ? ORDER BY notificationid Desc";
    private static final String SELECT_ALL_NOTI_SCHOOL = "SELECT * FROM [dbo].[notification] WHERE categoryid = ? ORDER BY notificationid Desc";
    private static final String SELECT_TEACHER_BY_ID = "SELECT firstname, lastname FROM [dbo].[teacher] WHERE teacherid = ? ";
    private static final String INSERT_NOTI_SCHOOL = "INSERT INTO [dbo].[notification] (title, content, date, categoryid) VALUES (?, ?, ?, ?)";
    private static final String INSERT_NOTI_TEACHER = "INSERT INTO [dbo].[notification] (title, content, date, categoryid, classid) VALUES (?, ?, ?, ?,?)";
    private static final String SELECT_ALL_NOTI_TEACHER_PAGE = "SELECT n.notificationid, n.title, n.content, n.date, n.categoryid, n.classid, n.teacherid, c.classname FROM [dbo].[notification] n JOIN [dbo].[class] c ON c.classid = n.classid WHERE teacherid = ? ORDER BY notificationid Desc";
    private static final String INSERT_ATTENDANCE_STATUS = "INSERT INTO [dbo].[attendance_status] (date, status, studentid, semesterid) VALUES (?,?,?,?)";
    private static final String UPDATE_ATTENDANCE_STATUS = "UPDATE [dbo].[attendance_status] SET date = ? ,status = ?, studentid = ?  ,semesterid = ? where studentid = ?";
    private static final String SELECT_STUDENT_BY_DATE_ATTENDANCE = "SELECT student.studentid, lastname, firstname, gender, dob, phonenumber,status FROM student INNER JOIN attendance_status ON attendance_status.date = ? and student.classid = ? and student.studentid = attendance_status.studentid";
    
    public void insertAttendanceStatus(LocalDate date, boolean status, String studentid, String semesterid) throws SQLException {
        PreparedStatement stm;
        try {
            String sql = INSERT_ATTENDANCE_STATUS;
            stm = conn.prepareStatement(sql);
            stm.setDate(1, java.sql.Date.valueOf(date));
            stm.setBoolean(2, status);
            stm.setString(3, studentid); 
            stm.setString(4, semesterid);

            stm.executeUpdate(); // không trả dữ liệu thì dùng executeUpdate
        } catch (Exception e) {
            System.out.println("loi" + e + "loi");
        }
    }
    
    public List<AttendanceList> getAttendanceStudentByDate(Date date, String classid) {
        
        PreparedStatement stm;
        ResultSet rs;

        List<AttendanceList> st = new ArrayList<>();
        try {
            
            String sql = SELECT_STUDENT_BY_DATE_ATTENDANCE;
            stm = conn.prepareStatement(sql);
            stm.setDate(1,date);
            stm.setString(2, classid);
            
            
            rs = stm.executeQuery();
            while (rs.next()) {
                st.add(new AttendanceList(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getBoolean(7)
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }
    
    
    
    public void updateAttendanceStatus(LocalDate date, boolean status, String studentid, String semesterid, String studentid2) throws SQLException {
        PreparedStatement stm;
        try {
            String sql = UPDATE_ATTENDANCE_STATUS;
            stm = conn.prepareStatement(sql);
            stm.setDate(1, java.sql.Date.valueOf(date));
            stm.setBoolean(2, status);
            stm.setString(3, studentid); 
            stm.setString(4, semesterid);
            stm.setString(5, studentid2);

            stm.executeUpdate(); // không trả dữ liệu thì dùng executeUpdate
        } catch (Exception e) {
            System.out.println("loi" + e + "loi");
        }
    }
    
    public List<Notification> selectAllNotiTeacherPage(String teacherid) {
        
        PreparedStatement stm;
        ResultSet rs;

        List<Notification> noti = new ArrayList<>();
        try {
            
            String sql = SELECT_ALL_NOTI_TEACHER_PAGE;
            stm = conn.prepareStatement(sql);
            stm.setString(1,teacherid);
            
          rs = stm.executeQuery();
            while (rs.next()) {    
                Teacher teacher = selectTeacherById(rs.getString(7));
                noti.add(new Notification(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),                      
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        teacher, 
                        rs.getString(9)
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noti;
    }
    
    public void insertNotiSchool(String title, String content, LocalDate date, int category) throws SQLException {
        PreparedStatement stm;
//        ResultSet rs;
        try {
            String sql = INSERT_NOTI_SCHOOL;
            stm = conn.prepareStatement(sql);
            stm.setString(1, title);
            stm.setString(2, content);
            stm.setDate(3, java.sql.Date.valueOf(date));
            stm.setInt(4, category);            

            stm.executeUpdate(); // không trả dữ liệu thì dùng executeUpdate
        } catch (Exception e) {
            System.out.println("loi" + e + "loi");
        }
    }
    
    public void insertNotiTeacher(String title, String content, LocalDate date, int category, String classid) throws SQLException {
        PreparedStatement stm;
//        ResultSet rs;
        try {
            String sql = INSERT_NOTI_TEACHER;
            stm = conn.prepareStatement(sql);
            stm.setString(1, title);
            stm.setString(2, content);
            stm.setDate(3, java.sql.Date.valueOf(date));
            stm.setInt(4, category); 
            stm.setString(5, classid);

            stm.executeUpdate(); // không trả dữ liệu thì dùng executeUpdate
        } catch (Exception e) {
            System.out.println("loi" + e + "loi");
        }
    }
    
    public Teacher selectTeacherById(String teacherid) {
    PreparedStatement stm;
    ResultSet rs;
    Teacher teacher = null;

    try {
        String sql = SELECT_TEACHER_BY_ID;
        stm = conn.prepareStatement(sql);
        stm.setString(1, teacherid);

        rs = stm.executeQuery();
        if (rs.next()) {
            teacher = new Teacher(
                    rs.getString("firstname"),
                    rs.getString("lastname")
            );
        }
    } catch (Exception ex) {
        Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return teacher;
}

    public List<Notification> selectAllNotiTeacher(String categoryid, int classid) {
        
        PreparedStatement stm;
        ResultSet rs;

        List<Notification> noti = new ArrayList<>();
        try {
            
            String sql = SELECT_ALL_NOTI_TEACHER;
            stm = conn.prepareStatement(sql);
            stm.setString(1,categoryid);
            stm.setInt(2, classid);
            
            
            rs = stm.executeQuery();
            while (rs.next()) {                
                Teacher teacher = selectTeacherById(rs.getString(7));
                noti.add(new Notification(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),                      
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        teacher
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noti;
    }
    
    public List<Notification> selectAllNotiSchool(String categoryid) {
        
        PreparedStatement stm;
        ResultSet rs;

        List<Notification> noti = new ArrayList<>();
        try {
            
            String sql = SELECT_ALL_NOTI_SCHOOL;
            stm = conn.prepareStatement(sql);
            stm.setString(1,categoryid);            
            
            rs = stm.executeQuery();
            while (rs.next()) {                
                Teacher teacher = selectTeacherById(rs.getString(7));
                noti.add(new Notification(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),                      
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        teacher
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noti;
    }
    
    public List<Student> selectAllStudent(String classid) {
        
        PreparedStatement stm;
        ResultSet rs;

        List<Student> st = new ArrayList<>();
        try {
            
            String sql = SELECT_ALL_STUDENT;
            stm = conn.prepareStatement(sql);
            stm.setString(1,classid);
            
            
            rs = stm.executeQuery();
            while (rs.next()) {
                st.add(new Student(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getBoolean(8),
                        rs.getDate(9),
                        false
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }
    public List<Account> getAll() {

        PreparedStatement stm;
        ResultSet rs;

        List<Account> bookList = new ArrayList();
        try {

            String sql = "SELECT * FROM account";
            stm = conn.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                bookList.add(new Account(rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("roleid")));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookList;
    }

    public Account login(String email, String password) {

        PreparedStatement stm;
        ResultSet rs;

        Account acc = new Account();
        try {

            String sql = "SELECT * FROM account where email=? and password =?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, password);

            rs = stm.executeQuery();
            while (rs.next()) {
                return acc = new Account(rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("roleid"));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Student getAStudentByEmail(String email) {

        PreparedStatement stm;
        ResultSet rs;

        Student st = new Student();
        try {
            
            String sql = "select s.studentid,s.lastname,s.firstname,s.email,s.[address],s.phonenumber,s.classid,s.gender,s.dob,c.classname\n" +
"from student s  join class c on s.classid=c.classid where s.email =?";
            stm = conn.prepareStatement(sql);
            stm.setString(1,email );
            
            
            rs = stm.executeQuery();
            while (rs.next()) {
                return st = new Student(rs.getString("studentid"),rs.getString("lastname")
                        ,rs.getString("firstname"),rs.getString("email")
                        ,rs.getString("address"),rs.getString("phonenumber"),rs.getInt("classid"),
                        rs.getBoolean("gender"),rs.getDate("dob"),rs.getString("classname"));
                        
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    public void changePassword(String email, String newPassword) {
        PreparedStatement stm;
        try {

            String sql = "UPDATE account SET password = ? WHERE email = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, newPassword);
            stm.setString(2, email);

            stm.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Teacher getATeacherByEmail(String email) {
        PreparedStatement stm;
        ResultSet rs;
        Teacher tc = new Teacher();

        try {

            String sql = "select t.teacherid,t.lastname,t.firstname,t.email,t.address,t.phonenumber,t.gender,t.dob,s.majorname\n"
                    + "from teacher t join subject s on t.major=s.majorid where t.email = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);

            rs = stm.executeQuery();
            while (rs.next()) {
                return tc = new Teacher(rs.getString("teacherid"), rs.getString("lastname"), rs.getString("firstname"), rs.getString("majorname"), rs.getString("email"),
                        rs.getString("address"), rs.getString("phonenumber"), rs.getDate("dob"), rs.getBoolean("gender"));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Class> getAllClass() {
        PreparedStatement stm;
        ResultSet rs;

        List<Class> classList = new ArrayList();
        try {

            String sql = "SELECT * FROM class";
            stm = conn.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                classList.add(new Class(rs.getInt("classid"), rs.getString("classname")));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return classList;
    }

    public List<Class> getClassByTeacherID(String teacherID) {
        PreparedStatement stm;
        ResultSet rs;

        List<Class> classList = new ArrayList();
        try {

            String sql = "select c.classname,c.classid from class_assign ca inner join teacher t "
                    + "on ca.teacherid=t.teacherid inner join class c on ca.classid=c.classid   where t.teacherid=?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, teacherID);
            rs = stm.executeQuery();
            while (rs.next()) {
                classList.add(new Class(rs.getInt("classid"), rs.getString("classname")));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return classList;
    }

    public List<Mark> getListMarkByClassAndTeacher(String teacherid, int classid) {
        PreparedStatement stm;
        ResultSet rs;
        List<Mark> markList = new ArrayList();
        try {

            String sql = "select s.studentid,s.lastname,s.firstname,m.progress_mark,m.middle,m.final,m.total,su.majorname,se.semester,se.year\n"
                    + "from mark m inner join student s on m.studentid = s.studentid \n"
                    + "inner join subject su on m.majorid=su.majorid inner join semester se on m.semseterid = se.semesterid\n"
                    + "where m.teacherid=? and s.classid=?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, teacherid);
            stm.setInt(2, classid);
            rs = stm.executeQuery();
            while (rs.next()) {
                markList.add(new Mark(rs.getString("studentid"),
                        rs.getString("lastname"), rs.getString("firstname"),
                        rs.getBigDecimal("progress_mark"), rs.getBigDecimal("middle"), rs.getBigDecimal("final"), rs.getBigDecimal("total"), rs.getString("majorname"), rs.getInt("semester"), rs.getInt("year")));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return markList;

    }

    public void updateMark(BigDecimal p, BigDecimal m, BigDecimal f, BigDecimal t, String studentid, String teacherid) {
        PreparedStatement stm;

        try {
            String sql = "update mark\n"
                    + "set progress_mark=?, middle=?,final=?,total=?\n"
                    + "where studentid=? and teacherid =?";
            stm = conn.prepareStatement(sql);
            stm.setBigDecimal(1, p);
            stm.setBigDecimal(2, m);
            stm.setBigDecimal(3, f);
            stm.setBigDecimal(4, t);
            stm.setString(5, studentid);
            stm.setString(6, teacherid);

            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Mark> getListMarkOfAStudent(String studentid) {
        PreparedStatement stm;
        ResultSet rs;
        List<Mark> markList = new ArrayList();
        try {

            String sql = "select s.studentid,s.lastname,s.firstname,m.progress_mark,m.middle,m.final,m.total,su.majorname,se.semester,se.year\n"
                    + "from mark m inner join student s on m.studentid = s.studentid \n"
                    + "inner join subject su on m.majorid=su.majorid inner join semester se on m.semseterid = se.semesterid\n"
                    + "where m.studentid=? ";
            stm = conn.prepareStatement(sql);
            stm.setString(1, studentid);

            rs = stm.executeQuery();
            while (rs.next()) {
                markList.add(new Mark(rs.getString("studentid"),
                        rs.getString("lastname"), rs.getString("firstname"),
                        rs.getBigDecimal("progress_mark"), rs.getBigDecimal("middle"), rs.getBigDecimal("final"), rs.getBigDecimal("total"), rs.getString("majorname"), rs.getInt("semester"), rs.getInt("year")));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return markList;

    }

    public void changePassword_forgot(String email, String newPassword) {
        PreparedStatement stm;
        try {

            String sql = "UPDATE account SET password = ? WHERE email = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, newPassword);
            stm.setString(2, email);

            stm.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateToken(String token, String email) {
        PreparedStatement stm;
        try {

            String sql = "UPDATE account SET token = ? WHERE email = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, token);
            stm.setString(2, email);

            stm.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Account getTokenByEmail(String email) {

        PreparedStatement stm;
        ResultSet rs;

        Account acc = new Account();
        try {

            String sql = "select * from account where email = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);

            rs = stm.executeQuery();
            while (rs.next()) {
                return acc = new Account(rs.getString("email"), rs.getString("token"));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        Dao dao = Dao.getInstance();
        List<Mark> list = dao.getListMarkByClassAndTeacher("TC10001", 1);
        for (Mark item : list) {
            System.out.println(item.toString());
        }
    }

}
