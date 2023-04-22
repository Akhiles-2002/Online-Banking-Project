<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Details</title>
        <style>
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
                border: 1px solid black;
                border-radius: 12px;
                background-color: cyan;
                color: blue;
                text-decoration: none;
                padding: 8px;
            }


        </style>
    </head>
    <body style="background-color: lightblue; text-align: center">
        <h1>ONLINE BANKING APPLICATION</h1>

        <c:choose>
            <c:when test="${customer ne null}">
                <h1 style="color: green; text-align: center;">Account Opened Successfully</h1>
                <h1>Customer Details</h1>
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
                <a href="./chooserole.html">Go to Login Page</a>
            </c:when>
            <c:otherwise>
                <h1 style="color: red; text-align: center;">Account Opeining Failed</h1>
            </c:otherwise>
        </c:choose>
    </body>
</html>
