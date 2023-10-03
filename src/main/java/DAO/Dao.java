/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Account;
import Model.Student;
import Model.Teacher;
import Model.Class;
import java.io.Serializable;
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
        Dao dao = Dao.getInstance();
        List<Class> list = dao.getAllClass();
        for (Class item : list) {
            System.out.println(item.toString());
        }
    }

}
