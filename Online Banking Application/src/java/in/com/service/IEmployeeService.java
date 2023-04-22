package in.com.service;

import in.com.dto.Customer;
import java.util.Date;
import java.util.List;

public interface IEmployeeService {
    
    public Customer openAccount(String fullname, String gender, String contactno, String emailId, String address, String password, Float balance, String accountType, Date date);

    public Customer searchCustomer(Integer customerId);

    public String deleteCustomer(Integer customerId);

    public String updateCustomer(Customer customer);

    public String loginEmployee(Integer employeeId, String password);

    public List<Customer> showAllCustomers();
    
}
