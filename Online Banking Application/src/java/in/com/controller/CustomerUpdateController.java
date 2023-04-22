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

@WebServlet(name = "CustomerUpdateController", urlPatterns = {"/updateCustomer"})
public class CustomerUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
        Integer customerId = Integer.parseInt(request.getParameter("customerId"));
        String fullname = request.getParameter("fullname");
        String gender = request.getParameter("gender");
        String contactno = request.getParameter("contactno");
        String emailId = request.getParameter("emailid");
        String password = request.getParameter("password");
        
        Customer customer = new Customer();

        customer.setCustomerId(customerId);
        customer.setFullname(fullname);
        customer.setGender(gender);
        customer.setContactno(contactno);
        customer.setEmailId(emailId);
        customer.setPassword(password);

        String status = employeeService.updateCustomer(customer);

        System.out.println("Status After Sending: " + status);

        request.setAttribute("status", status);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("./customerUpdateResponse.jsp");
        requestDispatcher.forward(request, response);
       //response.sendRedirect("./employeeUpdateResponse.jsp");
        
    }

}
