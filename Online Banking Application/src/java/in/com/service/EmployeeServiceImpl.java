package in.com.service;

import in.com.dao.IEmployeeDao;
import in.com.daofactory.EmployeeDaoFactory;
import in.com.dto.Customer;
import java.util.Date;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeDao employeeDao = null;

    @Override
    public Customer openAccount(String fullname, String gender, String contactno, String emailId, String address, String password, Float balance, String accountType, Date date) {
        employeeDao = EmployeeDaoFactory.getEmployeeDao();
        return employeeDao.openAccount(fullname, gender, contactno, emailId, address, password, balance, accountType, date);
    }

    @Override
    public Customer searchCustomer(Integer customerId) {
        employeeDao = EmployeeDaoFactory.getEmployeeDao();
        return employeeDao.searchCustomer(customerId);
    }

    @Override
    public String deleteCustomer(Integer customerId) {
        employeeDao = EmployeeDaoFactory.getEmployeeDao();
        return employeeDao.deleteCustomer(customerId);
    }

    @Override
    public String updateCustomer(Customer customer) {
        employeeDao = EmployeeDaoFactory.getEmployeeDao();
        return employeeDao.updateCustomer(customer);
    }

    @Override
    public String loginEmployee(Integer employeeId, String password) {
        employeeDao = EmployeeDaoFactory.getEmployeeDao();
        return employeeDao.loginEmployee(employeeId, password);
    }

    @Override
    public List<Customer> showAllCustomers() {
        employeeDao = EmployeeDaoFactory.getEmployeeDao();
        return employeeDao.showAllCustomers();
    }

}
