package in.com.controller;

import in.com.dto.Employee;
import in.com.service.IManagerService;
import in.com.servicefactory.ManagerServiceFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmployeeUpdateController", urlPatterns = {"/updateEmployee"})
public class EmployeeUpdateController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        if(request != null){
        IManagerService managerService = ManagerServiceFactory.getManagerService();
        Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String fullname = request.getParameter("fullname");
        String gender = request.getParameter("gender");
        String contactno = request.getParameter("contactno");
        String emailId = request.getParameter("emailid");
        String password = request.getParameter("password");
        
        Employee employee = new Employee();

        employee.setEmployeeId(employeeId);
        employee.setFullname(fullname);
        employee.setGender(gender);
        employee.setContactno(contactno);
        employee.setEmailId(emailId);
        employee.setPassword(password);

        System.out.println("Employee Details Before Sending: " + employee);

        String status = managerService.updateEmployee(employee);
        System.out.println("Employee Details After Sending: " + employee);
        System.out.println("Status After Sending: " + status);

        request.setAttribute("status", status);
        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("../employeeUpdateResponse.jsp");
        //requestDispatcher.forward(request, response);
        response.sendRedirect("./employeeUpdateResponse.jsp");
        }
    }
}
