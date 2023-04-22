package in.com.servicefactory;

import in.com.service.EmployeeServiceImpl;
import in.com.service.IEmployeeService;

public class EmployeeServiceFactory {

    private static IEmployeeService employeeService = null;

    private EmployeeServiceFactory() {

    }

    public static IEmployeeService getEmployeeService() {
        if (employeeService == null) {
            employeeService = new EmployeeServiceImpl();
        }
        return employeeService;
    }

}
