package in.com.controller;

import in.com.service.IEmployeeService;
import in.com.servicefactory.EmployeeServiceFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EmployeeLoginController", urlPatterns = {"/employeeLog"})
public class EmployeeLoginController extends HttpServlet {
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

        RequestDispatcher requestDispatcher = null;
        HttpSession session = null;
        IEmployeeService employeeService = null;
        String status = null;

        Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String password = request.getParameter("password");

        session = request.getSession();
        employeeService = EmployeeServiceFactory.getEmployeeService();
        status = employeeService.loginEmployee(employeeId, password);

        System.out.println(status);

        session.setAttribute("employeeId", employeeId);
        session.setAttribute("status", status);

        requestDispatcher = request.getRequestDispatcher("./employeeWindow.jsp");
        requestDispatcher.forward(request, response);
    }


}
