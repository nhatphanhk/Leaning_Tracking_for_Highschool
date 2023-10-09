/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Model.Account;
import Model.Student;
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
public class Dao implements Serializable{
    private Connection conn=DBUtil.makeConnection();
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
    
    
    
    
        
        public static void main(String[] args) {
            Student st = getInstance().getAStudentByEmail("student1@gmail.com");
            System.out.println(st.toString());
    }
    }
    
   

