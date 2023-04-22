package in.com.controller;

import in.com.dto.Customer;
import in.com.service.ICustomerService;
import in.com.servicefactory.CustomerServiceFactory;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmployeeOpenAccountController", urlPatterns = {"/openAccount"})
public class EmployeeOpenAccountController extends HttpServlet {
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

        String fullname = request.getParameter("fullname");
        String gender = request.getParameter("gender");
        String contactno = request.getParameter("contactno");
        String emailId = request.getParameter("emailid");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String accountType = request.getParameter("accounttype");
        Float balance = Float.parseFloat(request.getParameter("balance"));
        String dateString = request.getParameter("openingdate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        if (dateString != null) {
            try {
                date = dateFormat.parse(dateString);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        Customer customer = new Customer();
        customer.setFullname(fullname);
        customer.setGender(gender);
        customer.setContactno(contactno);
        customer.setEmailId(emailId);
        customer.setAddress(address);
        customer.setPassword(password);
        customer.setBalance(balance);
        customer.setAccountType(accountType);
        customer.setOpeningDate(date);
        System.out.println("in servlet before calling service : " + customer);
        
        System.out.println("Parameter is " + fullname);
        System.out.println("Parameter is " + gender);
        System.out.println("Parameter is " + contactno);
        System.out.println("Parameter is " + emailId);
        System.out.println("Parameter is " + address);
        System.out.println("Parameter is " + password);
        System.out.println("Parameter is " + balance);
        System.out.println("Parameter is " + accountType);
        System.out.println("Parameter is " + dateString);

        customer = customerService.registerCustomer(fullname, gender, contactno, emailId, address, password, balance, accountType, date);
        System.out.println("Servlet Customer after calling : " + customer);

        request.setAttribute("customer", customer);
        requestDispatcher = request.getRequestDispatcher("./openAccountConf.jsp");
        requestDispatcher.forward(request, response);
    }


}
