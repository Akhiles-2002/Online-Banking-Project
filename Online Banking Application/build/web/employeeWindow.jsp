<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Window</title>
        <style>
            body {
                margin: 0px;
                color: white;
            }

            header {
                margin: 0px;
                padding: 5px;
            }

             .links {
                background-color: lightblue;
                height: 30px;
                color: blue;
                text-align: center;
                padding: 0px;
                border: 2px solid gray;
                border-radius: 10px;
                padding: 20px;
                margin: 20px;
                padding: 5px;
            }

            .links:hover {
                background-color: cyan;
            }
            a {
                color: blue;
                text-decoration: none;
            }
        </style>

    </head>
    <body bgcolor="gray">

        <c:choose>
            <c:when test="${'success' eq status}">

                <header
                    style="height: 100px; background-color: purple; color:white; border-bottom: 5px solid gray;">
                    <h1 align="center">ONLINE BANKING APPLICATION</h1>
                </header>

                <!--For Menu Option to the Admin  -->
                <div
                    style="background-color: white; height: 650px; width: 20%; float: left;">

                    <div class="links">
                        <a href="./employeeWindow.jsp">Employee</a>
                    </div>
                    <div class="links">
                        <a href="./openAccount.jsp">Open Customer Account</a>
                    </div>
                    <div class="links">
                        <a href="./searchCustomer.html">Search Customer</a>
                    </div>
                    <div class="links">
                        <a href="./updateCustomer.html">Update Customer</a>
                    </div>
                    <div class="links">
                        <a href="./deleteCustomer.html">Delete Customer</a>
                    </div>
                    <div class="links">
                        <a href="./showAllCustomers">Show All Customers</a>
                    </div>
                    <div class="links">
                        <a href="./employeeLogout.jsp">Logout</a>
                    </div>
                </div>

                <!-- Body  -->
                <div
                    style="float: left; height: 650px; width: 80%; background-image: url('Banking1.jpg'); background-size: 1215px 650px;">

                    <p style="font-size: 30px; color: white; text-align: center">Welcome
                        To Online Banking</p>
                </div>
            </c:when>
            <c:otherwise>
                <jsp:forward page="./employeeLogin.jsp"></jsp:forward>
            </c:otherwise>
        </c:choose>
    </body>
</html>