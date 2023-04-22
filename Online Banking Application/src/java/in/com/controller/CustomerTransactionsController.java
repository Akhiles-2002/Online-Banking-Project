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

@WebServlet(name = "CustomerTransactionsController", urlPatterns = {"/transactions"})
public class CustomerTransactionsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher requestDispatcher = null;
        ICustomerService customerService = CustomerServiceFactory.getCustomerService();
        
        Integer customerId = Integer.parseInt(request.getParameter("customerId"));
        Integer toaccount = Integer.parseInt(request.getParameter("toaccount"));
        Float amount = Float.parseFloat(request.getParameter("amount"));
        String password = request.getParameter("password");
        
        String status = customerService.transferMoney(customerId, toaccount, amount, password);
        
        System.out.println("Jdbc Status is " + status);
        
        request.setAttribute("status", status);
        requestDispatcher = request.getRequestDispatcher("./transactionsConfirm.jsp");
        requestDispatcher.forward(request, response);
        
    }

}
