package in.com.controller;

import in.com.dto.Customer;
import in.com.service.IEmployeeService;
import in.com.servicefactory.EmployeeServiceFactory;
import in.com.servicefactory.ManagerServiceFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CustomerDeleteController", urlPatterns = {"/deleteCustomer"})
public class CustomerDeleteController extends HttpServlet {

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

        String status = employeeService.deleteCustomer(customerId);

        request.setAttribute("status", status);
        requestDispatcher = request.getRequestDispatcher("./customerDeleteResult.jsp");
        requestDispatcher.forward(request, response);

       
    }

}
