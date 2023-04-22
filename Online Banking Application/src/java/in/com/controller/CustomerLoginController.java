package in.com.controller;

import in.com.service.ICustomerService;
import in.com.servicefactory.CustomerServiceFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CustomerLoginController", urlPatterns = {"/customerLogin"})
public class CustomerLoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = null;
        ICustomerService customerService = null;
        String status = null;
        RequestDispatcher requestDispatcher = null;

        Integer customerId = Integer.parseInt(request.getParameter("customerid"));
        String password = request.getParameter("password");

        session = request.getSession();
        customerService = CustomerServiceFactory.getCustomerService();
        status = customerService.loginCustomer(customerId, password);

        System.out.println(status);

        session.setAttribute("customerId", customerId);
        session.setAttribute("status", status);
       
        requestDispatcher = request.getRequestDispatcher("./customerWindow.jsp");
        requestDispatcher.forward(request, response);  
    }

}
