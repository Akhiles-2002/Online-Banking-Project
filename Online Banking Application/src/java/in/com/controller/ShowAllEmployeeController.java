package in.com.controller;

import in.com.dto.Employee;
import in.com.service.IManagerService;
import in.com.servicefactory.ManagerServiceFactory;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ShowAllEmployeeController", urlPatterns = {"/showAllEmployees"})
public class ShowAllEmployeeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        IManagerService managerService = ManagerServiceFactory.getManagerService();
        RequestDispatcher requestDispatcher = null;
                
        List<Employee> employeeList = managerService.showAllEmployees();
        
        System.out.println(employeeList);
        request.setAttribute("employeeList", employeeList);
        requestDispatcher = request.getRequestDispatcher("./showAllEmployees.jsp");
        requestDispatcher.forward(request, response);
    }
}
