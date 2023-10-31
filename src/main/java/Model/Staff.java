package Model;

/**
 *
 * @author tramy
 */
public class Staff {
    private String staffid;
    private String lastname;
    private String firstname;
    private String email;
    private String phone;

    public Staff() {
    }


    // select staff by staffid
    public Staff(String staffid, String lastname, String firstname, String email, String phone) {
        this.staffid = staffid;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.phone = phone;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


  

    @Override
    public String toString() {
        return "Staff{" + "staffid=" + staffid + ", lastname=" + lastname + ", firstname=" + firstname + ", email=" + email + ", phone=" + phone + '}';
    }


}
