package Model;

/**
 *
 * @author tramy
 */
public class Timetable {
    private int activityid;
    private String day;
    private String hour;
    private int classid;
    private String majorid;
    private String teacherid;
    private String semesterid;
    private String majorname;
    private String classname;

    public Timetable() {
    }

    // INSERT TIMETABLE    
    public Timetable(String day, String hour, int classid, String majorid, String teacherid, String semesterid) {
        this.day = day;
        this.hour = hour;
        this.classid = classid;
        this.majorid = majorid;
        this.teacherid = teacherid;
        this.semesterid = semesterid;
    }
    // SELECT TIMETABLE 
    public Timetable(int activityid, String day, String hour, int classid, String majorid, String teacherid, String semesterid, String majorname, String classname) {
        this.activityid = activityid;
        this.day = day;
        this.hour = hour;
        this.classid = classid;
        this.majorid = majorid;
        this.teacherid = teacherid;
        this.semesterid = semesterid;
        this.majorname = majorname;
        this.classname = classname;
    }


    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }


    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    public int getActivityid() {
        return activityid;
    }

    public void setActivityid(int activityid) {
        this.activityid = activityid;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getMajorid() {
        return majorid;
    }

    public void setMajorid(String majorid) {
        this.majorid = majorid;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(String semesterid) {
        this.semesterid = semesterid;
    }

    @Override
    public String toString() {
        return "Timetable{" + "activityid=" + activityid + ", day=" + day + ", hour=" + hour + ", classid=" + classid + ", majorid=" + majorid + ", teacherid=" + teacherid + ", semesterid=" + semesterid + ", majorname=" + majorname + ", classname=" + classname + '}';
    }




}
