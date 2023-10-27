/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author tramy
 */
public class Notification {

    private int notificationid;
    private String title;
    private String content;
    private Date date;
    private int categoryid;
    private int classid;
    private String teacherid;
    private Teacher teacher;
    private String classname;
    private Boolean readStatus;
//    private Class classname;

    // Getters and Setters
    public int getnotificationid() {
        return notificationid;
    }

    public Notification() {
    }

    
    // UPDATE NOTI BY TEACHER
    public Notification(int notificationid, String title, String content, int classid) {    
        this.notificationid = notificationid;
        this.title = title;
        this.content = content;
        this.classid = classid;
    }

    // SELECT ALL NOTI TEACHER PAGE
    public Notification(int notificationid, String title, String content, Date date, int categoryid, int classid, String teacherid, String classname) {
        this.notificationid = notificationid;
        this.title = title;
        this.content = content;
        this.date = date;
        this.categoryid = categoryid;
        this.classid = classid;
        this.teacherid = teacherid;
        this.classname = classname;
    }
    
    
    // SELECT NOTI BY NOTI ID
    public Notification(int notificationid, String title, String content, Date date, int categoryid, String teacherid) {
        this.notificationid = notificationid;
        this.title = title;
        this.content = content;
        this.date = date;
        this.categoryid = categoryid;
        this.teacherid = teacherid;
    }
    // SELECT NOTI TEACHER BY NOTI ID
    public Notification(int notificationid, String title, String content, Date date, int categoryid, String teacherid, String classname) {
        this.notificationid = notificationid;
        this.title = title;
        this.content = content;
        this.date = date;
        this.categoryid = categoryid;
        this.teacherid = teacherid;
        this.classname = classname;
    }

    public Notification(int notificationid, String title, String content, Date date, int categoryid,String teacherid, int classid, Teacher teacher) {
        this.notificationid = notificationid;
        this.title = title;
        this.content = content;
        this.date = date;
        this.categoryid = categoryid;
        this.classid = classid;
        this.teacherid = teacherid;
        this.teacher = teacher;
    }

    public Notification(int notificationid, String title, String content, int categoryid, int classid, String teacherid) {
        this.notificationid = notificationid;
        this.title = title;
        this.content = content;
        this.categoryid = categoryid;
        this.classid = classid;
        this.teacherid = teacherid;
    }

    public String getclassname() {
        return classname;
    }

    public void setclassname(String classname) {
        this.classname = classname;
    }
    
    

    public Boolean getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Boolean readStatus) {
        this.readStatus = readStatus;
    }

//    public Class getclassname() {
//        return classname;
//    }
//
//    public void setclassname(Class classname) {
//        this.classname = classname;
//    }


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public void setnotificationid(int notificationid) {
        this.notificationid = notificationid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getcategoryid() {
        return categoryid;
    }

    public void setcategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    @Override
    public String toString() {
        return "Notification{" + "notificationid=" + notificationid + ", title=" + title + ", content=" + content + ", date=" + date + ", categoryid=" + categoryid + ", classid=" + classid + ", classname=" + classname + ", teacherid=" + teacherid + '}';
    }

//    @Override
//    public String toString() {
//        return "Notification{" + "notificationid=" + notificationid + ", title=" + title + ", content=" + content + ", date=" + date + ", categoryid=" + categoryid + ", classid=" + classid + ", teacherid=" + teacherid + ", teacher=" + teacher + ", classname=" + classname + '}';
//    }

    

    

}
