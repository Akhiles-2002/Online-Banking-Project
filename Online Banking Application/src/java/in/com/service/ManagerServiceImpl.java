package in.com.service;

import in.com.dao.IManagerDao;
import in.com.daofactory.ManagerDaoFactory;
import in.com.dto.Employee;
import in.com.dto.Manager;
import java.util.List;

public class ManagerServiceImpl implements IManagerService {

    private IManagerDao managerDao = null;

    @Override
    public Manager managerRegister(String fullname, String gender, String contactno, String emailid, String password) {
        managerDao = ManagerDaoFactory.getManagerDao();
        return managerDao.managerRegister(fullname, gender, contactno, emailid, password);
    }

    @Override
    public String managerLogin(Integer managerId, String password) {
        managerDao = ManagerDaoFactory.getManagerDao();
        return managerDao.managerLogin(managerId, password);
    }

    @Override
    public Employee registerEmployee(String fullname, String gender, String contactno, String emailid, String password) {
        managerDao = ManagerDaoFactory.getManagerDao();
        return managerDao.registerEmployee(fullname, gender, contactno, emailid, password);
    }

    @Override
    public Employee searchEmployee(Integer employeeId) {
        managerDao = ManagerDaoFactory.getManagerDao();
        return managerDao.searchEmployee(employeeId);
    }

    @Override
    public String deleteEmployee(Integer employeeId) {
        managerDao = ManagerDaoFactory.getManagerDao();
        return managerDao.deleteEmployee(employeeId);
    }

    @Override
    public String updateEmployee(Employee employee) {
        managerDao = ManagerDaoFactory.getManagerDao();
        String status = managerDao.updateEmployee(employee);
        return status;
    }

    @Override
    public List<Employee> showAllEmployees() {
        managerDao = ManagerDaoFactory.getManagerDao();
        return managerDao.showAllEmployees();
    }

}
