package DAO;

import Model.Account;
import Model.Admin;
import Model.AttendanceList;
import Model.AttendanceStatus;
import Model.Student;
import Model.Application;
import Model.Staff;
import Model.Timetable;
import Model.Teacher;
import Model.Class;
import Model.Major;
import Model.Mark;
import Model.Notification;
import Model.payment_category;
import Model.PayFee;
import java.io.InputStream;
import Model.Semester;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.taglibs.standard.tei.ForEachTEI;

/**
 *
 * @author Admin
 */
public class Dao implements Serializable {

    private Connection conn = DBUtil.makeConnection();
    private static Dao instance;

    public Dao() {
    }

    public static Dao getInstance() {

        if (instance == null) {
            instance = new Dao();
        }
        return instance;
    }
    private static final String SELECT_ALL_STUDENT = "SELECT * FROM student WHERE classid = ? order by firstname";
    private static final String SELECT_ALL_TEACHER = "SELECT teacherid, lastname, firstname FROM teacher";
    private static final String SELECT_ALL_NOTI_TEACHER = "SELECT * FROM [dbo].[notification] WHERE categoryid = ? AND classid = ? ORDER BY notificationid Desc";
    private static final String SELECT_ALL_NOTI_SCHOOL = "SELECT * FROM [dbo].[notification] WHERE categoryid = ? ORDER BY notificationid Desc";
    private static final String SELECT_TEACHER_BY_ID = "SELECT firstname, lastname FROM [dbo].[teacher] WHERE teacherid = ? ";
    private static final String INSERT_NOTI_SCHOOL = "INSERT INTO [dbo].[notification] (title, content, date, categoryid) VALUES (?, ?, ?, ?)";
    private static final String INSERT_NOTI_TEACHER = "INSERT INTO [dbo].[notification] (title, content, date, categoryid, classid, teacherid) VALUES (?, ?, ?, ?,?,?)";
    private static final String SELECT_ALL_NOTI_TEACHER_PAGE = "SELECT n.notificationid, n.title, n.content, n.date, n.categoryid, n.classid, n.teacherid, c.classname FROM [dbo].[notification] n JOIN [dbo].[class] c ON c.classid = n.classid WHERE teacherid = ? ORDER BY notificationid Desc";
    private static final String SELECT_ALL_CLASS = "SELECT * FROM class";
    private static final String INSERT_ATTENDANCE_STATUS = "INSERT INTO [dbo].[attendance_status] (date, status, studentid, semesterid,note) VALUES (?,?,?,?,?)";
    private static final String UPDATE_ATTENDANCE_STATUS = "UPDATE [dbo].[attendance_status] SET status = ?,note =? where studentid = ?";
    private static final String SELECT_STUDENT_BY_DATE_ATTENDANCE = "SELECT student.studentid, lastname, firstname, gender, dob, phonenumber,status, note FROM student INNER JOIN attendance_status ON attendance_status.date = ? and student.classid = ? and student.studentid = attendance_status.studentid";
    private static final String SELECT_STUDENT_ATTENDANCE_STATUS = "SELECT * FROM attendance_status where studentid = ? and status =?";

    private static final String SELECT_CLASS_BY_ID = "SELECT classid, classname FROM class WHERE classid = ?";
    private static final String UPDATE_NOTI = "UPDATE notification SET title = ?, content = ?, classid = ? WHERE notificationid = ?";
    private static final String SELECT_NOTI_BY_ID = "SELECT * FROM notification WHERE notificationid = ?";
    private static final String SELECT_NOTI_TEACHER_BY_ID = "SELECT n.notificationid, n.title, n.content, n.date, n.categoryid,n.teacherid, c.classname \n"
            + "FROM [dbo].[notification] n JOIN [dbo].[class] c ON c.classid = n.classid \n"
            + "WHERE notificationid = ?";
    private static final String INSERT_APPLICATION_STUDENT = "INSERT INTO [dbo].[application] (title, categoryid, date, studentid, fileContent) VALUES (?, ?, ?, ?,?)";
    private static final String SELECT_APPLICATION_STUDENT = "SELECT n.applicationid, n.title, n.categoryid, n.date, n.teacherid, n.studentid, c.category FROM [dbo].[application] n JOIN [dbo].[application_category] c ON c.categoryid = n.categoryid WHERE studentid = ? ORDER BY applicationid Desc";
    private static final String SELECT_APPLICATION = "SELECT n.applicationid, n.title, n.categoryid, n.date, n.fileContent, n.studentid, c.firstname, c.lastname FROM [dbo].[application] n JOIN [dbo].[student] c ON c.studentid = n.studentid ORDER BY applicationid Desc";
    private static final String INSERT_TIMETABLE = "INSERT INTO timetable (day, hour, classid, majorid, teacherid, semesterid) VALUES (?,?,?,?,?,?)";
    private static final String SELECT_TIMETABLE_STUDENT = "SELECT n.activityid, n.[day], n.[hour], n.classid, n.majorid, n.teacherid, n.semesterid, c.classname, m.majorname\n"
            + "FROM [dbo].[timetable] n\n"
            + "JOIN [dbo].[class] c ON c.classid = n.classid\n"
            + "JOIN [dbo].[subject] m ON m.majorid = n.majorid\n"
            + "WHERE hour = ? AND c.classid = ?";
    private static final String SELECT_TIMETABLE_TEACHER = "SELECT n.activityid, n.[day], n.[hour], n.classid, n.majorid, n.teacherid, n.semesterid, c.classname, m.majorname FROM [dbo].[timetable] n JOIN [dbo].[class] c ON c.classid = n.classid JOIN [dbo].[subject] m ON m.majorid = n.majorid WHERE hour = ? AND teacherid = ?";
    private static final String SELECT_TEACHER_BY_CLASSID = "select teacher.teacherid, lastname, firstname, major, email, address, phonenumber, dob, gender from teacher inner join class_assign on teacher.teacherid = class_assign.teacherid where class_assign.classid= ?";
    private static final String DELETE_NOTI = "DELETE FROM notification WHERE notificationid = ?";
    private static final String SELECT_STUDENT_BY_ID = "SELECT * from student where studentid = ?";

    public Student selectStudentById(String studentid) {

        PreparedStatement stm;
        ResultSet rs;
        Student student = null;
        try {

            String sql = SELECT_STUDENT_BY_ID;
            stm = conn.prepareStatement(sql);
            stm.setString(1, studentid);

            rs = stm.executeQuery();
            while (rs.next()) {
                student = new Student(
                        rs.getString("studentid"),
                        rs.getString("lastname"),
                        rs.getString("firstname"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("phonenumber"),
                        rs.getInt("classid"),
                        rs.getBoolean("gender"),
                        rs.getDate("dob"),
                        false
                );
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }
    private static final String SELECT_ALL_FEE = "SELECT [transactionid], [studentid], [date], [totalbill], [categoryid] FROM payment_history";

    
    public void deleteNoti(String notificationid) throws SQLException {
        PreparedStatement stm;
        ResultSet rs;

        try {
            String sql = DELETE_NOTI;
            stm = conn.prepareStatement(sql);
            stm.setString(1, notificationid);
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Teacher> selectTeacherByClassid(String classid) {
        PreparedStatement stm;
        ResultSet rs;
        List<Teacher> tc = new ArrayList<>();

        try {
            String sql = SELECT_TEACHER_BY_CLASSID;
            stm = conn.prepareStatement(sql);
            stm.setString(1, classid);

            rs = stm.executeQuery();
            while (rs.next()) {
                tc.add(new Teacher(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8),
                        rs.getBoolean(9)
                ));
            }

        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tc;
    }

    public List<Timetable> selectTimetableTeacher(String hour, String teacherid) {

        PreparedStatement stm;
        ResultSet rs;

        List<Timetable> st = new ArrayList<>();
        try {

            String sql = SELECT_TIMETABLE_TEACHER;
            stm = conn.prepareStatement(sql);
            stm.setString(1, hour);
            stm.setString(2, teacherid);

            rs = stm.executeQuery();
            while (rs.next()) {
                st.add(new Timetable(
                        rs.getInt("activityid"),
                        rs.getString("day"),
                        rs.getString("hour"),
                        rs.getInt("classid"),
                        rs.getString("majorid"),
                        rs.getString("teacherid"),
                        rs.getString("semesterid"),
                        rs.getString("majorname"),
                        rs.getString("classname")
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }

    public List<Timetable> selectTimetableStudent(String hour, String classid) {

        PreparedStatement stm;
        ResultSet rs;

        List<Timetable> st = new ArrayList<>();
        try {

            String sql = SELECT_TIMETABLE_STUDENT;
            stm = conn.prepareStatement(sql);
            stm.setString(1, hour);
            stm.setString(2, classid);

            rs = stm.executeQuery();
            while (rs.next()) {
                st.add(new Timetable(
                        rs.getInt("activityid"),
                        rs.getString("day"),
                        rs.getString("hour"),
                        rs.getInt("classid"),
                        rs.getString("majorid"),
                        rs.getString("teacherid"),
                        rs.getString("semesterid"),
                        rs.getString("majorname"),
                        rs.getString("classname")
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }

    public void insertTimetable(Timetable timetable) throws SQLException {
        PreparedStatement stm;
        try {
            String sql = INSERT_TIMETABLE;
            stm = conn.prepareStatement(sql);
            stm.setString(1, timetable.getDay());
            stm.setString(2, timetable.getHour());
            stm.setInt(3, timetable.getClassid());
            stm.setString(4, timetable.getMajorid());
            stm.setString(5, timetable.getTeacherid());
            stm.setString(6, timetable.getSemesterid());

            stm.executeUpdate(); // không trả dữ liệu thì dùng executeUpdate
        } catch (Exception e) {
            System.out.println("loi: " + e);
        }
    }

    public Staff getAStaffByEmail(String email) {
        PreparedStatement stm;
        ResultSet rs;
        Staff stf = new Staff();
        try {
            String sql = "select * from staff where email= ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);

            rs = stm.executeQuery();
            while (rs.next()) {
                return stf = new Staff(
                        rs.getString("staffid"),
                        rs.getString("lastname"),
                        rs.getString("firstname"),
                        rs.getString("email"),
                        rs.getString("phonenumber")
                );

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public List<Application> selectApplication() {

        PreparedStatement stm;
        ResultSet rs;

        List<Application> app = new ArrayList<>();
        try {

            String sql = SELECT_APPLICATION;
            stm = conn.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                app.add(new Application(
                        rs.getInt("applicationid"),
                        rs.getString("title"),
                        rs.getInt("categoryid"),
                        rs.getDate("date"),
                        rs.getString("studentid"),
                        rs.getBytes("fileContent"),
                        rs.getString("firstname"),
                        rs.getString("lastname")
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return app;
    }

    public Application getApplicationById(int applicationId) {
        List<Application> applications = selectApplication();
        for (Application app : applications) {
            if (app.getApplicationid() == applicationId) {
                return app;
            }
        }
        return null; // Trả về null nếu không tìm thấy ứng dụng
    }

    public List<Application> selectApplicationStudent(String studentid) {

        PreparedStatement stm;
        ResultSet rs;

        List<Application> app = new ArrayList<>();
        try {

            String sql = SELECT_APPLICATION_STUDENT;
            stm = conn.prepareStatement(sql);
            stm.setString(1, studentid);

            rs = stm.executeQuery();
            while (rs.next()) {
                app.add(new Application(
                        rs.getInt("applicationid"),
                        rs.getString("title"),
                        rs.getInt("categoryid"),
                        rs.getDate("date"),
                        rs.getString("studentid"),
                        rs.getString("teacherid"),
                        rs.getString("category")
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return app;
    }

    public void insertApplicationStudent(String title, String categoryid, LocalDate date, String studentid, InputStream fileContent) throws SQLException {
        PreparedStatement stm;
        try {
            String sql = INSERT_APPLICATION_STUDENT;
            stm = conn.prepareStatement(sql);
            stm.setString(1, title);
            stm.setString(2, categoryid);
            stm.setDate(3, java.sql.Date.valueOf(date));
            stm.setString(4, studentid);
            if (fileContent != null) {
                stm.setBlob(5, fileContent);
            }

            stm.executeUpdate(); // không trả dữ liệu thì dùng executeUpdate
        } catch (Exception e) {
            System.out.println("loi" + e + "loi");
        }
    }

    public Notification selectNotiByNotiId(String notificationid) {
        PreparedStatement stm;
        ResultSet rs;
        Notification noti = null;

        try {
            String sql = SELECT_NOTI_BY_ID;
            stm = conn.prepareStatement(sql);
            stm.setString(1, notificationid);

            rs = stm.executeQuery();
            if (rs.next()) {
                noti = new Notification(
                        rs.getInt("notificationid"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getDate("date"),
                        rs.getInt("categoryid"),
                        rs.getString("teacherid")
                );
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noti;

    }

    public Notification selectNotiTeacherByNotiId(String notificationid) {
        PreparedStatement stm;
        ResultSet rs;
        Notification noti = null;

        try {
            String sql = SELECT_NOTI_TEACHER_BY_ID;
            stm = conn.prepareStatement(sql);
            stm.setString(1, notificationid);

            rs = stm.executeQuery();
            if (rs.next()) {
                noti = new Notification(
                        rs.getInt("notificationid"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getDate("date"),
                        rs.getInt("categoryid"),
                        rs.getString("teacherid"),
                        rs.getString("classname")
                );
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noti;

    }

    public void updateNoti(String title, String content, String classid, String notificationid) throws SQLException {
        String sql = UPDATE_NOTI;
        try ( PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, title);
            stm.setString(2, content);
            stm.setString(3, classid);
            stm.setString(4, notificationid);

            stm.executeUpdate(); // không trả dữ liệu thì dùng executeUpdate
        } catch (Exception e) {
            System.out.println("loi" + e + "loi");
        }

    }

    public List<AttendanceStatus> selectStudentAttendanceStatus(String studentid) {

        PreparedStatement stm;
        ResultSet rs;

        List<AttendanceStatus> sta = new ArrayList<>();
        try {

            String sql = SELECT_STUDENT_ATTENDANCE_STATUS;
            stm = conn.prepareStatement(sql);
            stm.setString(1, studentid);
            stm.setString(2, "0");

            rs = stm.executeQuery();
            while (rs.next()) {
                sta.add(new AttendanceStatus(
                        rs.getDate(2),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sta;
    }

    public void insertAttendanceStatus(LocalDate date, boolean status, String studentid, String semesterid, String note) throws SQLException {
        PreparedStatement stm;
        try {
            String sql = INSERT_ATTENDANCE_STATUS;
            stm = conn.prepareStatement(sql);
            stm.setDate(1, java.sql.Date.valueOf(date));
            stm.setBoolean(2, status);
            stm.setString(3, studentid);
            stm.setString(4, semesterid);
            stm.setString(5, note);
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
            stm.setDate(1, date);
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
                        rs.getBoolean(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }

    public void updateAttendanceStatus(boolean status, String studentid, String note) throws SQLException {
        PreparedStatement stm;
        try {
            String sql = UPDATE_ATTENDANCE_STATUS;
            stm = conn.prepareStatement(sql);

            stm.setBoolean(1, status);
            stm.setString(2, note);
            stm.setString(3, studentid);

            stm.executeUpdate(); // không trả dữ liệu thì dùng executeUpdate
        } catch (Exception e) {
            System.out.println("loi" + e + "loi");
        }
    }

    public List<Notification> selectAllNotiTeacherId(String teacherid) {

        PreparedStatement stm;
        ResultSet rs;

        List<Notification> noti = new ArrayList<>();
        try {

            String sql = SELECT_ALL_NOTI_TEACHER_PAGE;
            stm = conn.prepareStatement(sql);
            stm.setString(1, teacherid);

            rs = stm.executeQuery();
            while (rs.next()) {
                noti.add(new Notification(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noti;
    }

    public List<Notification> selectAllNotiTeacherPage(String teacherid) {

        PreparedStatement stm;
        ResultSet rs;

        List<Notification> noti = new ArrayList<>();
        try {

            String sql = SELECT_ALL_NOTI_TEACHER_PAGE;
            stm = conn.prepareStatement(sql);
            stm.setString(1, teacherid);

            rs = stm.executeQuery();
            while (rs.next()) {
                noti.add(new Notification(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noti;
    }

    public void insertNotiSchool(String title, String content, LocalDate date, int category) throws SQLException {
        PreparedStatement stm;
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

    public void insertNotiTeacher(String title, String content, LocalDate date, int category, String classid, String teacherid) throws SQLException {
        PreparedStatement stm;
        try {
            String sql = INSERT_NOTI_TEACHER;
            stm = conn.prepareStatement(sql);
            stm.setString(1, title);
            stm.setString(2, content);
            stm.setDate(3, java.sql.Date.valueOf(date));
            stm.setInt(4, category);
            stm.setString(5, classid);
            stm.setString(6, teacherid);

            stm.executeUpdate(); // không trả dữ liệu thì dùng executeUpdate
        } catch (Exception e) {
            System.out.println("loi" + e + "loi");
        }
    }

    public Account getAccountByEmail(String email) {
        PreparedStatement stm;
        ResultSet rs;
        Account acc = new Account();

        try {
            String sql = "select * from account where email =?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);

            rs = stm.executeQuery();
            if (rs.next()) {
                acc = new Account(rs.getString("email"), rs.getString("password"), rs.getInt("roleid"), rs.getString("token"));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acc;

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

    public Class selectClassById(String classid) {
        PreparedStatement stm;
        ResultSet rs;
        Class cls = null;

        try {
            String sql = SELECT_CLASS_BY_ID;
            stm = conn.prepareStatement(sql);
            stm.setString(1, classid);

            rs = stm.executeQuery();
            if (rs.next()) {
                cls = new Class(
                        rs.getInt("classid"),
                        rs.getString("classname")
                );
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cls;

    }

    public List<Notification> selectAllNotiTeacher(String categoryid, String classid) {

        PreparedStatement stm;
        ResultSet rs;

        List<Notification> noti = new ArrayList<>();
        try {

            String sql = SELECT_ALL_NOTI_TEACHER;
            stm = conn.prepareStatement(sql);
            stm.setString(1, categoryid);
            stm.setString(2, classid);

            rs = stm.executeQuery();
            while (rs.next()) {
                Teacher teacher = selectTeacherById(rs.getString(7));
                noti.add(new Notification(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
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
            stm.setString(1, categoryid);

            rs = stm.executeQuery();
            while (rs.next()) {
                Teacher teacher = selectTeacherById(rs.getString(7));
                noti.add(new Notification(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
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
            stm.setString(1, classid);

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
                        true
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

    public List<Class> getAllClasses() {

        PreparedStatement stm;
        ResultSet rs;

        List<Class> classList = new ArrayList();
        try {

            String sql = SELECT_ALL_CLASS;
            stm = conn.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                classList.add(new Class(rs.getInt("classid"),
                        rs.getString("classname")));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return classList;
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

            String sql = "select s.studentid,s.lastname,s.firstname,s.email,s.[address],s.phonenumber,s.classid,s.gender,s.dob,c.classname,s.indentify\n"
                    + "from student s  join class c on s.classid=c.classid where s.email =?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);

            rs = stm.executeQuery();
            while (rs.next()) {
                return st = new Student(rs.getString("studentid"), rs.getString("lastname"),
                        rs.getString("firstname"), rs.getString("email"),
                        rs.getString("address"), rs.getString("phonenumber"), rs.getInt("classid"),
                        rs.getBoolean("gender"), rs.getDate("dob"), rs.getString("classname"),rs.getInt("indentify"));

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

    public Teacher getLastTeacher() {
        PreparedStatement stm;
        ResultSet rs;
        Teacher tc = new Teacher();

        try {

            String sql = "select top 1 t.teacherid,t.lastname,t.firstname,t.email,t.address,t.phonenumber,t.gender,t.dob,s.majorname\n"
                    + "from teacher t join subject s on t.major=s.majorid order by teacherid desc";
            stm = conn.prepareStatement(sql);
            //stm.setString(1, email);

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
                classList.add(new Class(rs.getInt("classid"), rs.getString("classname").replaceAll("\\s+", "")));

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

    public List<Mark> getListMarkByClasses(int classid) {
        PreparedStatement stm;
        ResultSet rs;
        List<Mark> markList = new ArrayList();
        try {

            String sql = "select s.studentid,s.lastname,s.firstname,AVG(COALESCE(m.progress_mark, 0)) AS progress_mark, \n"
                    + "		AVG(COALESCE(m.middle, 0)) AS middle_mark, \n"
                    + "		AVG(COALESCE(m.final, 0)) AS final_mark, \n"
                    + "		AVG(COALESCE(m.total, 0)) AS total_mark,se.semester,se.year \n"
                    + "                  from mark m inner join student s on m.studentid = s.studentid  \n"
                    + "                  inner join semester se on m.semseterid = se.semesterid \n"
                    + "                  where s.classid=? \n"
                    + "		group by s.studentid,s.lastname,s.firstname,se.semester,se.year order by firstname";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, classid);
            rs = stm.executeQuery();
            while (rs.next()) {
                markList.add(new Mark(rs.getString("studentid"),
                        rs.getString("lastname"), rs.getString("firstname"),
                        rs.getBigDecimal("progress_mark"), rs.getBigDecimal("middle_mark"), rs.getBigDecimal("final_mark"), rs.getBigDecimal("total_mark"), rs.getInt("semester"), rs.getInt("year")));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return markList;
    }

    public List<Mark> getListMarkByClassAndTeacher(String teacherid, int classid) {
        PreparedStatement stm;
        ResultSet rs;
        List<Mark> markList = new ArrayList();
        try {

            String sql = "select s.studentid,s.lastname,s.firstname,m.progress_mark,m.middle,m.final,m.total,su.majorname,se.semester,se.year\n"
                    + "from mark m inner join student s on m.studentid = s.studentid \n"
                    + "inner join subject su on m.majorid=su.majorid inner join semester se on m.semseterid = se.semesterid\n"
                    + "where m.teacherid=? and s.classid=? order by firstname";
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

    public List<Teacher> getAllTeacher() {
        PreparedStatement stm;
        ResultSet rs;
        List<Teacher> tc = new ArrayList<>();

        try {

            String sql = "select t.teacherid,t.lastname,t.firstname,t.email,t.address,t.phonenumber,t.gender,t.dob,s.majorname\n"
                    + "from teacher t join subject s on t.major=s.majorid order by t.firstname ";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                tc.add(new Teacher(rs.getString("teacherid"), rs.getString("lastname"), rs.getString("firstname"), rs.getString("majorname"), rs.getString("email"),
                        rs.getString("address"), rs.getString("phonenumber"), rs.getDate("dob"), rs.getBoolean("gender")));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tc;
    }

    public void updateStudent(String studenid, String firstname, String lastname, String phone, String address, Date dob, boolean gender) {
        PreparedStatement stm;

        try {
            String sql = "update student set firstname = ?,lastname=?,"
                    + "phonenumber=?,[address]=?,gender=?,dob=? where studentid=?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, firstname);
            stm.setString(2, lastname);
            stm.setString(3, phone);
            stm.setString(4, address);
            stm.setBoolean(5, gender);
            stm.setDate(6, dob);
            stm.setString(7, studenid);

            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateTeacher(String teacherid, String firstname, String lastname, String phone, String address, Date dob, boolean gender) {
        PreparedStatement stm;

        try {
            String sql = "update teacher set firstname = ?,lastname=?,"
                    + "phonenumber=?,[address]=?,gender=?,dob=? where teacherid=?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, firstname);
            stm.setString(2, lastname);
            stm.setString(3, phone);
            stm.setString(4, address);
            stm.setBoolean(5, gender);
            stm.setDate(6, dob);
            stm.setString(7, teacherid);

            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteStudent(String email) {
        PreparedStatement stm;

        try {
            String sql = "delete from student where email =?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);

            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteTeacher(String email) {
        PreparedStatement stm;

        try {
            String sql = "delete from teacher where email =?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);

            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addStudent(String studentid, String firstname, String lastname, String email, String phone, String address, Date dob, boolean gender, int classid, String semesterid) {
        PreparedStatement stm;

        try {
            String sql = "insert into student(studentid,lastname,firstname,email,address,phonenumber,classid,gender,dob,semesterid) values\n"
                    + "(?,?,?,?,?,?,?,?,?,?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, studentid);
            stm.setString(2, lastname);
            stm.setString(3, firstname);
            stm.setString(4, email);
            stm.setString(5, address);
            stm.setString(6, phone);
            stm.setInt(7, classid);
            stm.setBoolean(8, gender);
            stm.setDate(9, dob);
            stm.setString(10, semesterid);

            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addTeacher(String teacherid, String firstname, String lastname, String email, String phone, String address, Date dob, String major, boolean gender) {
        PreparedStatement stm;

        try {
            String sql = "insert into teacher(teacherid,lastname,firstname,email,address,phonenumber,major,gender,dob) values\n"
                    + "(?,?,?,?,?,?,?,?,?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, teacherid);
            stm.setString(2, lastname);
            stm.setString(3, firstname);
            stm.setString(4, email);
            stm.setString(5, address);
            stm.setString(6, phone);
            stm.setString(7, major);
            stm.setBoolean(8, gender);
            stm.setDate(9, dob);
            //stm.setString(10, semesterid);

            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Student getLastStudent() {
        PreparedStatement stm;
        ResultSet rs;

        Student st = new Student();
        try {

            String sql = "select top 1 s.studentid,s.lastname,s.firstname,s.email,s.[address],s.phonenumber,s.classid,s.gender,s.dob,c.classname\n"
                    + "from student s  join class c on s.classid=c.classid order by studentid desc";
            stm = conn.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                return st = new Student(rs.getString("studentid"), rs.getString("lastname"),
                        rs.getString("firstname"), rs.getString("email"),
                        rs.getString("address"), rs.getString("phonenumber"), rs.getInt("classid"),
                        rs.getBoolean("gender"), rs.getDate("dob"), rs.getString("classname"));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Student> getAllStudent() {
        PreparedStatement stm;
        ResultSet rs;

        List<Student> st = new ArrayList<>();
        try {

            String sql = "select s.studentid,s.lastname,s.firstname,s.email,s.[address],s.phonenumber,s.classid,s.gender,s.dob,c.classname\n"
                    + "from student s  join class c on s.classid=c.classid ";
            stm = conn.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                st.add(new Student(rs.getString("studentid"), rs.getString("lastname"),
                        rs.getString("firstname"), rs.getString("email"),
                        rs.getString("address"), rs.getString("phonenumber"), rs.getInt("classid"),
                        rs.getBoolean("gender"), rs.getDate("dob"), rs.getString("classname")));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }

    public Admin getAdminByEmail(String email) {
        PreparedStatement stm;
        ResultSet rs;
        Admin tc = new Admin();

        try {

            String sql = "select staffid,lastname,firstname,email,phonenumber\n"
                    + "from staff where email = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);

            rs = stm.executeQuery();
            while (rs.next()) {
                return tc = new Admin(rs.getString("staffid"), rs.getString("lastname"), rs.getString("firstname"), rs.getString("email"),
                        rs.getString("phonenumber"));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Major> getAllMajor() {
        PreparedStatement stm;
        ResultSet rs;
        List<Major> list = new ArrayList<>();

        try {

            String sql = "select * from subject";
            stm = conn.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Major(rs.getString(1), rs.getString(2)));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Account getStaffAccountByEmail(String email) {
        PreparedStatement stm;
        ResultSet rs;

        Account acc = new Account();
        try {

            String sql = "Select a.email, a.password,a.roleid,s.lastname,s.firstname,s.staffid from account a Join staff s on a.email=s.email where a.email =? ";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);

            rs = stm.executeQuery();
            while (rs.next()) {
                return acc = new Account(rs.getString("staffid"), rs.getString("lastname"),
                        rs.getString("firstname"), rs.getString("email"), rs.getString("password"), rs.getInt("roleid"));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Account getStudentAccountByEmail(String email) {
        PreparedStatement stm;
        ResultSet rs;

        Account acc = new Account();
        try {

            String sql = "Select a.email, a.password,a.roleid,s.lastname,s.firstname,s.studentid from account a join student s on a.email=s.email where a.email =? ";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);

            rs = stm.executeQuery();
            while (rs.next()) {
                return acc = new Account(rs.getString("studentid"), rs.getString("lastname"),
                        rs.getString("firstname"), rs.getString("email"), rs.getString("password"), rs.getInt("roleid"));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Account getTeacherAccountByEmail(String email) {
        PreparedStatement stm;
        ResultSet rs;

        Account acc = new Account();
        try {

            String sql = "Select a.email, a.password,a.roleid,s.lastname,s.firstname,s.teacherid from account a Join teacher s on a.email=s.email where a.email =? ";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);

            rs = stm.executeQuery();
            while (rs.next()) {
                return acc = new Account(rs.getString("teacherid"), rs.getString("lastname"),
                        rs.getString("firstname"), rs.getString("email"), rs.getString("password"), rs.getInt("roleid"));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Account getEmptyAccountByEmail(String email) {
        PreparedStatement stm;
        ResultSet rs;

        Account acc = new Account();
        try {

            String sql = " SELECT a.email, a.password, a.roleid\n"
                    + "FROM account AS a\n"
                    + "LEFT JOIN student AS s ON a.email = s.email left join teacher t on a.email = t.email left join staff st on a.email = st.email\n"
                    + "WHERE s.email IS NULL and t.email is null and st.email is null and a.email = ? ";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);

            rs = stm.executeQuery();
            while (rs.next()) {
                return acc = new Account(rs.getString("email"), rs.getString("password"), rs.getInt("roleid"));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateAccount(String email, String newPassword, int role) {
        PreparedStatement stm;
        try {

            String sql = "UPDATE account SET password = ?, roleid = ? WHERE email = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, newPassword);
            stm.setInt(2, role);
            stm.setString(3, email);

            stm.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addAccount(String email, String newPassword, int role) {
        PreparedStatement stm;
        try {

            String sql = "insert into Account(email,password,roleid) values(?,?,?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);

            stm.setString(2, newPassword);
            stm.setInt(3, role);

            stm.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
            public List<PayFee> getPayFeeList() throws SQLException {

              List<PayFee> payFeeList = new ArrayList<>();

              try (PreparedStatement stm = conn.prepareStatement(SELECT_ALL_FEE)) {

                ResultSet rs = stm.executeQuery();

                while (rs.next()) {
                  PayFee payFee = mapResultSetToPayFee(rs);
                  payFeeList.add(payFee);
                }

              } catch (SQLException e) {
                Logger logger = Logger.getLogger(PayFee.class.getName());
                logger.log(Level.SEVERE, "Lỗi lấy danh sách phí", e);
                throw e;
              }

               return payFeeList;


            }
            public void addPayFee(payment_category newFee) throws SQLException {

                String sql = "INSERT INTO payment_category (categoryid,payment_category, Amount) VALUES (?,?, ?)";

                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setInt(1, newFee.getCategoryid()); 
                stmt.setString(2,newFee.getPayment_category());
                stmt.setString(3, newFee.getAmount());

                stmt.executeUpdate();
              }
            
              private PayFee mapResultSetToPayFee(ResultSet rs) throws SQLException {
                return new PayFee(
                   rs.getInt("transactionid"),
                   rs.getString("studentid"),
                   rs.getDate("date"),
                              rs.getInt("totalbill"),
                              rs.getInt("categoryid")
                );
              }
    

    public List<Semester> getAllSemester() {
        PreparedStatement stm;
        ResultSet rs;

        List<Semester> list = new ArrayList<>();

        try {

            String sql = "select * from semester";
            stm = conn.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Semester(rs.getString("semesterid"), rs.getInt("year"), rs.getInt("semester")));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Mark> getListMarkBySemester(String major, String semester) {
        PreparedStatement stm;
        ResultSet rs;
        List<Mark> markList = new ArrayList();
        try {

            String sql = "select m.semseterid,s.studentid,s.lastname,s.firstname,m.progress_mark,m.middle,m.final,m.total,su.majorname,se.semester,se.year\n"
                    + "from mark m inner join student s on m.studentid = s.studentid \n"
                    + "inner join subject su on m.majorid=su.majorid inner join semester se on m.semseterid = se.semesterid\n"
                    + "where s.indentify\n"
                    + "is not null and m.semseterid =? and m.majorid =?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, semester);
            stm.setString(2, major);
            rs = stm.executeQuery();
            while (rs.next()) {
                markList.add(new Mark(rs.getString("studentid"),
                        rs.getString("lastname"), rs.getString("firstname"),
                        rs.getBigDecimal("progress_mark"), rs.getBigDecimal("middle"),
                        rs.getBigDecimal("final"), rs.getBigDecimal("total"), rs.getString("majorname"), rs.getInt("semester"),
                        rs.getInt("year"), rs.getString("semseterid")));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return markList;

    }

    public void updateMarkV2(BigDecimal p, BigDecimal m, BigDecimal f, BigDecimal t, String studentid, String semesterid, String majorid) {
        PreparedStatement stm;

        try {
            String sql = "update mark set progress_mark=?, middle=?,final=?,total=? "
                    + "where semseterid = ? and studentid=? and majorid =?";
            stm = conn.prepareStatement(sql);
            stm.setBigDecimal(1, p);
            stm.setBigDecimal(2, m);
            stm.setBigDecimal(3, f);
            stm.setBigDecimal(4, t);
            stm.setString(5, semesterid);
            stm.setString(6, studentid);
            stm.setString(7, majorid);

            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Mark> getListMarkOfAStudentV2(String semesterid,int identify) {
        PreparedStatement stm;
        ResultSet rs;
        List<Mark> markList = new ArrayList();
        try {

            String sql = "select  s.studentid,s.lastname,s.firstname,m.progress_mark,m.middle,m.final,m.total,su.majorname from mark m left join student s on m.studentid = s.studentid join subject su\n"
                    + " on m.majorid=su.majorid where s.indentify\n"
                    + "is not null and m.semseterid =? and s.indentify =? ";
            stm = conn.prepareStatement(sql);
            stm.setString(1, semesterid);
            stm.setInt(2, identify);

            rs = stm.executeQuery();
            while (rs.next()) {
                markList.add(new Mark(rs.getString("studentid"),
                        rs.getString("lastname"), rs.getString("firstname"),
                        rs.getBigDecimal("progress_mark"), rs.getBigDecimal("middle"), rs.getBigDecimal("final"), rs.getBigDecimal("total"), rs.getString("majorname") ));

            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return markList;

    }

    public static void main(String[] args) {
        Dao dao = Dao.getInstance();
        Student a = dao.getAStudentByEmail("student121@gmail.com");
        System.out.println(a);
    }

}
