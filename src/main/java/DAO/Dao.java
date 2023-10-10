/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Account;
import Model.Student;
import Model.Teacher;
import Model.Class;
import Model.Mark;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    private Dao() {
    }

    public static Dao getInstance() {

        if (instance == null) {
            instance = new Dao();
        }
        return instance;
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

            String sql = "SELECT \n"
                    + "    s.studentid,\n"
                    + "    s.lastname,\n"
                    + "    s.firstname,\n"
                    + "    s.email,\n"
                    + "    s.address,\n"
                    + "    s.phonenumber,\n"
                    + "    s.gender,\n"
                    + "    s.dob,\n"
                    + "    c.classname,\n"
                    + "    se.semester,\n"
                    + "    se.year\n"
                    + "FROM student s\n"
                    + "INNER JOIN class c ON s.classid = c.classid\n"
                    + "INNER JOIN semester se ON s.semesterid = se.semesterid\n"
                    + "WHERE s.email = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);

            rs = stm.executeQuery();
            while (rs.next()) {
                return st = new Student(rs.getString("studentid"), rs.getString("lastname"),
                        rs.getString("firstname"), rs.getString("email"),
                        rs.getString("address"), rs.getString("phonenumber"),
                        rs.getBoolean("gender"), rs.getDate("dob"),
                        rs.getString("classname"), rs.getInt("semester"), rs.getInt("year"));

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
     
     
     public void updateToken(String token, String email){
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
            stm.setString(1,email );
            
            
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
