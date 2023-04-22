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

@WebServlet(name = "CustomerSearchController", urlPatterns = {"/searchCust"})
public class CustomerSearchController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        Customer customer = new Customer();
        IEmployeeService employeeService = null;
        
        Integer customerId = Integer.parseInt(request.getParameter("customerId"));
        employeeService = EmployeeServiceFactory.getEmployeeService();
        customer.setCustomerId(customerId);
        
        customer = employeeService.searchCustomer(customerId);
        
        request.setAttribute("customer", customer);
        requestDispatcher  = request.getRequestDispatcher("./customerSearchResult.jsp"); 
        requestDispatcher.forward(request, response);
    }

}
