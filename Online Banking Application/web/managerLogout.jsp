<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%   
    // Invalidate the session if it exists
    if (session != null) {
        session.invalidate();
    }
    
    // Redirect to the index page
    response.sendRedirect("index.html");
%>
