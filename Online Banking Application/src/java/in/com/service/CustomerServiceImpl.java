package in.com.service;

import in.com.dao.ICustomerDao;
import in.com.daofactory.CustomerDaoFactory;
import in.com.dto.Customer;
import java.util.Date;

public class CustomerServiceImpl implements ICustomerService {

    private ICustomerDao customerDao = null;

    @Override
    public Customer registerCustomer(String fullname, String gender, String contactno, String emailId, String address, String password, Float balance, String accountType, Date date) {
        customerDao = CustomerDaoFactory.getCustomerDao();
        System.out.println("Service Impl class :" + contactno);
        return customerDao.registerCustomer(fullname, gender, contactno, emailId, address, password, balance, accountType, date);
    }
    
    @Override
    public Customer myaccount(Integer customerId) {
        customerDao = CustomerDaoFactory.getCustomerDao();
        return customerDao.myaccount(customerId);
    }

    @Override
    public String loginCustomer(Integer customerId, String password) {
        customerDao = CustomerDaoFactory.getCustomerDao();
        return customerDao.loginCustomer(customerId, password);
    }
    
    @Override
    public String transferMoney(Integer customerId, Integer toAccount, Float amount, String password){
        customerDao = CustomerDaoFactory.getCustomerDao();
        return customerDao.transferMoney(customerId, toAccount, amount, password);
    }
    
    @Override
    public String enquiry(String message, Integer accountNo){
        customerDao = CustomerDaoFactory.getCustomerDao();
        return customerDao.enquiry(message, accountNo);
    }
    
    @Override
    public String billPayments(Integer customerId, Integer toAccount, Float amount, String password){
        customerDao = CustomerDaoFactory.getCustomerDao();
        return customerDao.billPayments(customerId, toAccount, amount, password);
    }

    @Override
    public String deposits(Integer toAccount, Integer customerId, Float amount, String password){
        customerDao = CustomerDaoFactory.getCustomerDao();
        return customerDao.deposits(toAccount, customerId, amount, password);
    }
    
}
