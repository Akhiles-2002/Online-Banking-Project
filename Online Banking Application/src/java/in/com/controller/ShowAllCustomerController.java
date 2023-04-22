package in.com.controller;

import in.com.dto.Customer;
import in.com.service.IEmployeeService;
import in.com.servicefactory.EmployeeServiceFactory;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ShowAllCustomerController", urlPatterns = {"/showAllCustomers"})
public class ShowAllCustomerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
        RequestDispatcher requestDispatcher = null;
                
        List<Customer> customerList = employeeService.showAllCustomers();
        
        System.out.println(customerList);
        request.setAttribute("customerList", customerList);
        requestDispatcher = request.getRequestDispatcher("./showAllCustomers.jsp");
        requestDispatcher.forward(request, response);
        
    }

}
