/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author nhatp
 */
public class PayFee {
    private int transactionid;
    private String studentid;
    private Date date;
    private int totalbill;
    private int categoryid;

    public PayFee() {

    }

    public PayFee(int transactionid, String studentid, Date date, int totalbill, int categoryid) {
        this.transactionid = transactionid;
        this.studentid = studentid;
        this.date = date;
        this.totalbill = totalbill;
        this.categoryid = categoryid;
    }

    public int getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(int transactionid) {
        this.transactionid = transactionid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalbill() {
        return totalbill;
    }

    public void setTotalbill(int totalbill) {
        this.totalbill = totalbill;
    }

    public int getCategoryid() {
        return categoryid;
    }
    
    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }
}