<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Window</title>
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
                        <a href="./customerWindow.jsp">Customer</a>
                    </div>

                    <div class="links">
                        <a href="./accountDetails.html">My Account & Profile</a>
                    </div>
                    <div class="links">
                        <a href="./transactions.html">Payment and Transactions</a>
                    </div>
                    <div class="links">
                        <a href="./billpayments.html">Bill Payments</a>
                    </div>
                    <div class="links">
                        <a href="./deposits.html">Deposits</a>
                    </div>
                    <div class="links">
                        <a href="./eServices.html">E-Services</a>
                    </div>
                    <div class="links">
                        <a href="./requestAndEnquiries.html">Request and Enquiries</a>
                    </div>
                    <div class="links">
                        <a href="./customerLogout.jsp">Logout</a>
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
                <jsp:forward page="./customerLogin.jsp"></jsp:forward>
            </c:otherwise>
        </c:choose>
    </body>
</html>