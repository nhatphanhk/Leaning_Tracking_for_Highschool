/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nhatp
 */
public class payment_category {
    private int categoryid;
    private String payment_category;
    private String Amount;


public payment_category() {

}
 public payment_category(int categoryid, String payment_category, String Amount) {
        this.categoryid=categoryid;
        this.payment_category = payment_category;
        this.Amount = Amount;
        
    }

    public int getCategoryid() {
        return categoryid;
    }

    public String getPayment_category() {
        return payment_category;
    }

    public String getAmount() {
        return Amount;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public void setPayment_category(String payment_category) {
        this.payment_category = payment_category;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    
}

