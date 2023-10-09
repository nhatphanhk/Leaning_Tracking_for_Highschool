/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Model.Account;
import Model.Notification;
import Model.Student;
import Model.Teacher;
import Model.Class;

import java.io.Serializable;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Admin
 */


public class Dao implements Serializable{
    private Connection conn=DBUtil.makeConnection();
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
    private static final String SELECT_ALL_NOTI_TEACHER = "SELECT * FROM [dbo].[notification] WHERE categoryid = ? AND classid = ?";
    private static final String SELECT_ALL_NOTI_SCHOOL = "SELECT * FROM [dbo].[notification] WHERE categoryid = ?";
    private static final String SELECT_TEACHER_BY_ID = "SELECT firstname, lastname FROM [dbo].[teacher] WHERE teacherid = ?";

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
                        rs.getDate(9)
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
    
    public Account login(String email,String password) {

        PreparedStatement stm;
        ResultSet rs;

        Account acc = new Account();
        try {
            
            String sql = "SELECT * FROM account where email=? and password =?";
            stm = conn.prepareStatement(sql);
            stm.setString(1,email );
            stm.setString(2,password );
            
            rs = stm.executeQuery();
            while (rs.next()) {
                return acc= new Account(rs.getString("email"),
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
    public List<Class> getAllClass(){
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

        
        public static void main(String[] args) {
            Student st = getInstance().getAStudentByEmail("student1@gmail.com");
            System.out.println(st.toString());
    }
    }
    
   

