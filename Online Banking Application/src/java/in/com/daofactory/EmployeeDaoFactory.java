package in.com.daofactory;

import in.com.dao.EmployeeDaoImpl;
import in.com.dao.IEmployeeDao;

public class EmployeeDaoFactory {

    private static IEmployeeDao employeeDao = null;

    private EmployeeDaoFactory() {

    }

    public static IEmployeeDao getEmployeeDao() {
        if (employeeDao == null) {
            employeeDao = new EmployeeDaoImpl();
        }
        return employeeDao;
    }

}
