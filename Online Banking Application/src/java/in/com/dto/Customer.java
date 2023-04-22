package in.com.dto;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Integer customerId;
    private String fullname;
    private String gender;
    private String contactno;
    private String emailId;
    private String address;
    private String password;
    private Date openingDate;
    private Integer accountNo;
    private Float balance;
    private String accountType;
    
    public Customer(){
        
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public void setContactno(String conatactNo) {
        this.contactno = contactno;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }  

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", fullname=" + fullname + ", gender=" + gender + ", contactno=" + contactno + ", emailId=" + emailId + ", address=" + address + ", password=" + password + ", openingDate=" + openingDate + ", accountNo=" + accountNo + ", balance=" + balance + ", accountType=" + accountType + '}';
    }
    
}
