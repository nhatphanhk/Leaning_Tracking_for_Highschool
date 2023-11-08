/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Semester {
    
    private String semesterid;
    private int year;
    private int semester;

    public Semester(String semesterid, int year, int semester) {
        this.semesterid = semesterid;
        this.year = year;
        this.semester = semester;
    }
    

    

    public Semester() {
    }

    public String getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(String semesterid) {
        this.semesterid = semesterid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Semester{" + "semesterid=" + semesterid + ", year=" + year + ", semester=" + semester + '}';
    }
    
    

    
    
    
}
