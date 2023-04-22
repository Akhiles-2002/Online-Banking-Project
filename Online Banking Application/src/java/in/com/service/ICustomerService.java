package in.com.service;

import in.com.dto.Customer;
import java.util.Date;

public interface ICustomerService {

    public Customer registerCustomer(String fullname, String gender, String contactno, String emailId, String address, String password, Float balance, String accountType, Date date);

    public Customer myaccount(Integer customerId);

    public String loginCustomer(Integer customerId, String password);

    public String transferMoney(Integer customerId, Integer toAccount, Float amount, String password);

    public String enquiry(String message, Integer accountNo);

    public String billPayments(Integer customerId, Integer toAccount, Float amount, String password);

    public String deposits(Integer toAccount, Integer customerId, Float amount, String password);

}
