package in.com.controller;

import in.com.dto.Customer;
import in.com.service.IEmployeeService;
import in.com.servicefactory.EmployeeServiceFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CustomerEditController", urlPatterns = {"/editCustomer"})
public class CustomerEditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher requestDispatcher = null;
        IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
         
        Integer customerId = Integer.parseInt(request.getParameter("customerId"));
        
        Customer customer = employeeService.searchCustomer(customerId);
        
        request.setAttribute("customer", customer);
        requestDispatcher = request.getRequestDispatcher("./editCustomer.jsp");
        requestDispatcher.forward(request, response);
        
    }

}
