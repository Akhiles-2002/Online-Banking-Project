package in.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ChooseRoleController", urlPatterns = {"/chooserole"})
public class ChooseRoleController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String role = request.getParameter("role");

        System.out.println("role is :" + role);

        if (role.equalsIgnoreCase("customer")) {
            System.out.println("we are going to customer login page...");
            response.sendRedirect("./customerLogin.jsp");
        } else if (role.equalsIgnoreCase("manager")) {
            response.sendRedirect("./managerLogin.jsp");
        } else if (role.equalsIgnoreCase("employee")) {
            response.sendRedirect("./employeeLogin.jsp");
        } else if(role.equals("")){
            // Invalid user type
            response.sendRedirect("./error.jsp");
        }else{
            response.sendRedirect("./error.jsp");
        }

    }

}
