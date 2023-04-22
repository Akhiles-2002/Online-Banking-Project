package in.com.controller;

import in.com.dto.Manager;
import in.com.service.IManagerService;
import in.com.servicefactory.ManagerServiceFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ManagerRegiController", urlPatterns = {"/regiManager"})
public class ManagerRegiController extends HttpServlet {

    
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
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        RequestDispatcher requestDispatcher = null;
        IManagerService managerService = ManagerServiceFactory.getManagerService();
        Manager manager = new Manager();
        
        String fullname = request.getParameter("fullname");
        String gender = request.getParameter("gender");
        String contactNo = request.getParameter("contactno");
        String emailId = request.getParameter("emailid");
        String password = request.getParameter("password");
        
        manager.setFullname(fullname);
        manager.setGender(gender);
        manager.setContactno(contactNo);
        manager.setEmailId(emailId);
        manager.setPassword(password);
        
        manager = managerService.managerRegister(fullname, gender, contactNo, emailId, password);
        
        request.setAttribute("manager", manager);
        requestDispatcher = request.getRequestDispatcher("./managerRegiConfirm.jsp");
        requestDispatcher.forward(request, response);
        
    }

}
