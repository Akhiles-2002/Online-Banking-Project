package in.com.controller;

import in.com.service.IManagerService;
import in.com.servicefactory.ManagerServiceFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ManagerLogController", urlPatterns = {"/managerLog"})
public class ManagerLogController extends HttpServlet {

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
        IManagerService managerService = null;
        String status = null;

        Integer managerId = Integer.parseInt(request.getParameter("managerId"));
        String password = request.getParameter("password");

        session = request.getSession();
        managerService = ManagerServiceFactory.getManagerService();
        status = managerService.managerLogin(managerId, password);

        System.out.println(status);

        session.setAttribute("managerId", managerId);
        session.setAttribute("status", status);

        requestDispatcher = request.getRequestDispatcher("./managerWindow.jsp");
        requestDispatcher.forward(request, response);
    }

}
