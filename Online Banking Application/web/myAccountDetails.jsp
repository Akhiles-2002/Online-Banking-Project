<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result</title>
        <style>
            body {
                margin: 0px;
                color: white;
            }

            header {
                margin: 0px;
                padding: 25px;
            }

            .links {
                background-color: lightblue;
                height: 30px;
                text-align: center;
                padding: 20px;
                border: 2px solid black;
                border-radius: 10px;
                padding: 20px;
                margin: 20px;
                padding: 5px;
            }

            .links:hover {
                background-color: cyan;
                border: 2px solid black;
            }

            .libreg {
                color: black;
                height: 600px;
                width: 800px;
                background-color: lightblue;
                border-radius: 12px;
                opacity: 0.9;
                margin-left: 200px;
                text-align: center;
                padding-left: 30px;
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
            }

            /* Style the table cells */
            td {
                padding: 8px;
                text-align: left;
            }

            input {
                border-radius: 10px;
            }
            
        </style>

    </head>
    <body>

        <!-- This is Header -->
        <header
            style="height:70px; background-color: purple; border-bottom: 5px solid white;">
            <h1 align="center">ONLINE BANKING APPLICATION</h1>
        </header>


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

        <div
            style="float: left; height: 650px; width: 80%; background-image: url('./Banking1.jpg'); background-size: 1215px 650px;">
            <!-- <img src="background-modified.jpg" width="1215px" height="650px" /> -->

            <div class="libreg">
                <h1>Customer Details</h1>
                <c:choose>
                    <c:when test="${customer ne null}">
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
                    </c:when>
                    <c:otherwise>
                        <p>Customer details not found</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
</html>






















