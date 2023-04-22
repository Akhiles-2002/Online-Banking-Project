package in.com.controller;

import in.com.dto.Customer;
import in.com.service.ICustomerService;
import in.com.servicefactory.CustomerServiceFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MyAccountController", urlPatterns = {"/myaccount"})
public class MyAccountController extends HttpServlet {

  
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
        RequestDispatcher requestDispatcher = null;
        ICustomerService customerService = null;
        
        Integer customerId = Integer.parseInt(request.getParameter("customerid"));
        
        System.out.println("Request URI :: " + request.getRequestURI());
        System.out.println("Servlet info ::" + request.getServletPath());
        System.out.println("Path info   :: " + request.getPathInfo());
        
        customerService = CustomerServiceFactory.getCustomerService();
        Customer customer = customerService.myaccount(customerId);
        
        System.out.println("Customer Data in Servlet : "+customer);
        
        request.setAttribute("customer", customer);
        requestDispatcher = request.getRequestDispatcher("./myAccountDetails.jsp");
        requestDispatcher.forward(request, response);
    }

}
