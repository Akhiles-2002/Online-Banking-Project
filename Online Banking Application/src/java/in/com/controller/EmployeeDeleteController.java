package in.com.controller;

import in.com.dto.Employee;
import in.com.service.IManagerService;
import in.com.servicefactory.ManagerServiceFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmployeeDeleteController", urlPatterns = {"/deleteEmployee"})
public class EmployeeDeleteController extends HttpServlet {

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

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        Employee employee = new Employee();
        IManagerService managerService = null;

        Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));
        managerService = ManagerServiceFactory.getManagerService();
        employee.setEmployeeId(employeeId);

        String status = managerService.deleteEmployee(employeeId);

        request.setAttribute("status", status);
        requestDispatcher = request.getRequestDispatcher("./employeeDeleteResult.jsp");
        requestDispatcher.forward(request, response);

    }

}
