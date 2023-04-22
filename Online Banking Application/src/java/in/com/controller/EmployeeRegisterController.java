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

@WebServlet(name = "EmployeeRegisterController", urlPatterns = {"/registerEmployee"})
public class EmployeeRegisterController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        RequestDispatcher requestDispatcher = null;
        IManagerService managerService = ManagerServiceFactory.getManagerService();
        Employee employee = new Employee();
        
        String fullname = request.getParameter("fullname");
        String gender = request.getParameter("gender");
        String contactNo = request.getParameter("contactno");
        String emailId = request.getParameter("emailid");
        String password = request.getParameter("password");
        
        employee.setFullname(fullname);
        employee.setGender(gender);
        employee.setContactno(contactNo);
        employee.setEmailId(emailId);
        employee.setPassword(password);
        
        employee = managerService.registerEmployee(fullname, gender, contactNo, emailId, password);
        
        request.setAttribute("employee", employee);
        requestDispatcher = request.getRequestDispatcher("./employeeRegiConfirm.jsp");
        requestDispatcher.forward(request, response);
        
    }

}
