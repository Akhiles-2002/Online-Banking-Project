package in.com.dto;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer accountNo;
    private String accountType;
    private Float balance;
    private Date accountOpeningDate;

    public Account(Integer accountNo, String accountType, Float balance, Date accountOpeningDate) {
        this.accountNo = accountNo;
        this.accountType = accountType;
        this.balance = balance;
        this.accountOpeningDate = accountOpeningDate;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Date getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public void setAccountOpeningDate(Date accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    @Override
    public String toString() {
        return "Account{" + "accountNo=" + accountNo + ", accountType=" + accountType + ", balance=" + balance + ", accountOpeningDate=" + accountOpeningDate + '}';
    }

}
