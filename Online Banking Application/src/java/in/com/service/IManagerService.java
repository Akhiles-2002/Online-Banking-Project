package in.com.service;

import in.com.dto.Employee;
import in.com.dto.Manager;
import java.util.List;

public interface IManagerService {
    
    public Manager managerRegister(String fullname, String gender, String contactno, String emailid, String password);

    public String managerLogin(Integer managerId, String password);
    
    public Employee registerEmployee(String fullname, String gender, String contactno, String emailid, String password);

    public Employee searchEmployee(Integer employeeId);

    public String deleteEmployee(Integer employeeId);

    public String updateEmployee(Employee employee);

    public List<Employee> showAllEmployees();
    
}
