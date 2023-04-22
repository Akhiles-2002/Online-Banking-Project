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

@WebServlet(name = "EmployeeEditController", urlPatterns = {"/editEmployee"})
public class EmployeeEditController extends HttpServlet {
    
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
         
        Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));
        
        Employee employee = managerService.searchEmployee(employeeId);
        
        request.setAttribute("employee", employee);
        requestDispatcher = request.getRequestDispatcher("./editEmployee.jsp");
        requestDispatcher.forward(request, response);
    }
}
