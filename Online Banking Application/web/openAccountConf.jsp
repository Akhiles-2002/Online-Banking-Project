<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
                background-color: white;
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
            .libreg {
                color: black;
                height: 600px;
                width: 800px;
                background-color: lightblue;
                border-radius: 12px;
                opacity: 0.9;
                margin-left: 500px;
                text-align: center;
                padding-left: 30px;
            }
            .links:hover {
                background-color: cyan;
            }

            /* Set some basic styles for the table */
            table {
                border-collapse: collapse;
                margin: 0 auto;
                width: 70%;
            }

            /* Set alternating background colors for the rows */
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            /* Style the table headers */
            th {
                background-color: #4CAF50;
                color: white;
                font-weight: bold;
                padding: 10px 8px;
                text-align: left;
                height: 20px;
            }    
            a{
                color: blue;
                text-decoration: none;
                padding: 8px;
            }
        </style>

    </head>
    <body bgcolor="gray">

        <header
            style="height: 100px; background-color: purple; color:white; border-bottom: 5px solid gray;">
            <h3 align="center">ONLINE BANKING APPLICATION</h3>
        </header>

        <!--For Menu Option to the Admin  -->
        <div
            style="background-color: honeydew; height: 650px; width: 20%; float: left;">

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
        <div class="libreg">
            <c:choose>
                <c:when test="${customer ne null}">
                    <h2 style="color: green; text-align: center;">Account Opened Successfully</h2>
                    <h2>Customer Details</h2>
                    <table style="border: 1px solid black; cellpadding:10px; text-align: center; ">
                        <tr>
                            <th>Customer ID</th>
                            <td>${customer.customerId}</td>
                        </tr>
                        <tr>
                            <th>Full Name</th>
                            <td>${customer.fullname}</td> 
                        </tr>
                        <tr>
                            <th>Gender</th>
                            <td>${customer.gender}</td>                  
                        </tr>
                        <tr>
                            <th>Email Id</th>
                            <td>${customer.emailId}</td>                 
                        </tr>
                        <tr>
                            <th>Address</th>
                            <td>${customer.address}</td> 
                        </tr>
                        <tr>
                            <th>Password</th>
                            <td>${customer.password}</td>
                        </tr>
                        <tr>
                            <th>Opening Date</th>
                            <td><fmt:formatDate value="${customer.openingDate}" pattern="dd-MMM-yyyy"/></td>
                        </tr>
                        <tr>
                            <th>Account No.</th>
                            <td>${customer.accountNo}</td>
                        </tr>
                        <tr>
                            <th>Balance</th>
                            <td>${customer.balance}</td>
                        </tr>
                        <tr>
                            <th>Account Type</th> 
                            <td>${customer.accountType}</td>
                        </tr>
                    </table>
                    <br/><br/>
                </c:when>
                <c:otherwise>
                    <h1 style="color: red; text-align: center;">Account Opening Failed</h1>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>