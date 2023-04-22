package in.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CustomerEnquiryController", urlPatterns = {"/enquiry"})
public class CustomerEnquiryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String choose = request.getParameter("choose");

        System.out.println("Choosen by Customer :" + choose);

        if (choose.equalsIgnoreCase("Offers")) {
            response.sendRedirect("./offers.jsp");
        } else if (choose.equalsIgnoreCase("Deduction")) {
            response.sendRedirect("./deduction.jsp");
        } else if (choose.equalsIgnoreCase("Other")) {
            response.sendRedirect("./others.jsp");
        } else if(choose.equals("")){
            // Invalid user type
            response.sendRedirect("./error.jsp");
        }else{
            response.sendRedirect("./error.jsp");
        }
    }

}
