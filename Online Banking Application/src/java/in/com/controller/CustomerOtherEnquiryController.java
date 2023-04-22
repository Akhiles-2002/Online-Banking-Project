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

@WebServlet(name = "CustomerOtherEnquiryController", urlPatterns = {"/otherenquiry"})
public class CustomerOtherEnquiryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher requestDispatcher = null;
        ICustomerService customerService = null;
        
        String query = request.getParameter("message");
        Integer accountNo = Integer.parseInt(request.getParameter("accountno"));
        
        customerService = CustomerServiceFactory.getCustomerService();
        String status = customerService.enquiry(query, accountNo);
        
        requestDispatcher = request.getRequestDispatcher("./othersEnquiry.jsp");
        requestDispatcher.forward(request, response);
    }

}
    
