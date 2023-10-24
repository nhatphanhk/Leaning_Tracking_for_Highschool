/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author htk09
 */
public class AttendanceStatus {

    @Override
    public String toString() {
        return "AttendanceStatus{" + "date=" + date + ", studentid=" + studentid + ", semesterid=" + semesterid + '}';
    }

    private Date date;
    private String studentid;
    private String semesterid;

    public AttendanceStatus(Date date, String studentid, String semesterid) {
        this.date = date;
        this.studentid = studentid;
        this.semesterid = semesterid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(String semesterid) {
        this.semesterid = semesterid;
    }
    
    
    
}
