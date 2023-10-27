package Model;

import java.sql.Date;

/**
 *
 * @author tramy
 */
public class Application {
    private int applicationid;
    private String title;
    private int categoryid;
    private Date date;
    private String studentid;
    private String teacherid;
    private String category;
    private String firstname;
    private String lastname;


    //SELECT APPLICATION STUDENT
    public Application(int applicationid, String title, int categoryid, Date date, String studentid,String teacherid, String category) {
        this.applicationid = applicationid;
        this.title = title;
        this.categoryid = categoryid;
        this.date = date;
        this.teacherid = teacherid;
        this.studentid = studentid;
        this.category = category;
    }

    //SELECT APPLICATION TEACHER

    public Application(int applicationid, String title, int categoryid, Date date, String studentid, String teacherid, String firstname, String lastname) {
        this.applicationid = applicationid;
        this.title = title;
        this.categoryid = categoryid;
        this.date = date;
        this.studentid = studentid;
        this.teacherid = teacherid;
        this.firstname = firstname;
        this.lastname = lastname;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public int getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(int applicationid) {
        this.applicationid = applicationid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
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

    @Override
    public String toString() {
        return "Application{" + "applicationid=" + applicationid + ", title=" + title + ", categoryid=" + categoryid + ", date=" + date + ", studentid=" + studentid + ", teacherid=" + teacherid + ", category=" + category + ", firstname=" + firstname + ", lastname=" + lastname + '}';
    }






}
