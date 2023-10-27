/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Major {
    
    private String majorid;
    private String majorname;

    public Major() {
    }

    public Major(String majorid, String majorname) {
        this.majorid = majorid;
        this.majorname = majorname;
    }

    public String getMajorid() {
        return majorid;
    }

    public void setMajorid(String majorid) {
        this.majorid = majorid;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }
    

    @Override
    public String toString() {
        return "Major{" + "majorid=" + majorid + ", majorname=" + majorname + '}';
    }
    
    
    
}
