package in.com.dto;

import java.io.Serializable;

public class Employee implements Serializable{
    
    private Integer employeeId;
    private String fullname;
    private String gender;
    private String contactno;
    private String emailId;
    private String password;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeId=" + employeeId + ", fullname=" + fullname + ", gender=" + gender + ", contactno=" + contactno + ", emailId=" + emailId + ", password=" + password + '}';
    }
    
}
