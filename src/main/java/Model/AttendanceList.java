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
public class AttendanceList {

    private String studentid;
    private String lastName;
    private String firstName;
    private Boolean gender;
    private Date dob;
    private String phoneNumber;
    private Boolean status;
    private String note;

    public AttendanceList(String studentid, String lastName, String firstName, Boolean gender, Date dob, String phoneNumber, Boolean status, String note) {
        this.studentid = studentid;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.note = note;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "AttendanceList{" + "studentid=" + studentid + ", lastName=" + lastName + ", firstName=" + firstName + ", gender=" + gender + ", dob=" + dob + ", phoneNumber=" + phoneNumber + ", status=" + status + ", note=" + note + '}';
    }

    

   
    
}
