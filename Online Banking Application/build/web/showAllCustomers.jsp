<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Customers</title>
        <style>
            body {
                margin: 10px;
                color: white;
                background-image: url('Banking1.jpg');
            }
            input {
                border-radius: 15px;
            }
            header {
                margin: 0px;
                padding: 25px;
            }

            .links {
                background-color: white;
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
            }

            a {
                color: blue;
                text-decoration: none;
            }
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

            .libreg {
                color: black;
                height: 600px; /* increase the height to show more rows */
                width: 1000px;
                background-color: lightblue;
                margin-left: 50px;
                border-radius: 12px;
                text-align: center;
                padding: 20px;
            }
            
        </style>

    </head>
    <body>

        <header
            style="height: 70px; background-color: purple; border-bottom: 5px solid white;">
            <h1 align="center">ONLINE BANKING APPLICATION</h1>
        </header>


        <div
            style="background-color: Honeydew; height: 650px; width: 20%; float: left;">

            <div class="links">
                <a href="./employeeWindow.jsp">Employee</a>
            </div>

            <div class="links">
                <a href="./openAccount.jsp">Open Customer Account</a>
            </div>
            <div class="links">
                <a href="./searchcustomer.html">Search customer</a>
            </div>
            <div class="links">
                <a href="./updatecustomer.html">Update customer</a>
            </div>
            <div class="links">
                <a href="./deletecustomer.html">Delete customer</a>
            </div>
            <div class="links">
                <a href="./showAllcustomers">Show All customers</a>
            </div>
            <div class="links">
                <a href="./employeeLogout.jsp">Logout</a>
            </div>

        </div>

        <div
            style="float: left; height: 650px; width: 80%; background-image: url('./Banking1.jpg'); background-size: 1250px 650px;">
            <!-- <img src="background-modified.jpg" width="1215px" height="650px" /> -->

            <div class="libreg" style=" overflow-y: auto">
                <h1>All Customer Record</h1>
                <br />
                <c:choose>
                    <c:when test="${customerList ne null}">
                        <table border="1" cellpadding="5px" align="center">
                            <tr style="color: white;">
                                <th>Customers Id</th>
                                <th>Full Name</th>
                                <th>Gender</th>
                                <th>EMail Id</th>
                                <th>Password</th> 
                                <th>Account Number</th>
                                <th>Balance</th>
                                <th>Account Type</th>
                                <th>Opening Date</th>
                            </tr>
                            <br/>
                            <c:forEach var="customer" items="${customerList}">
                                <tr>
                                    <!-- Display the employee details -->
                                    <td>${customer.customerId}</td>
                                    <td>${customer.fullname}</td>
                                    <td>${customer.gender}</td>
                                    <td>${customer.emailId}</td>
                                    <td>${customer.password}</td>
                                    <td>${customer.accountNo}</td>
                                    <td>${customer.balance}</td>
                                    <td>${customer.accountType}</td>
                                    <td><fmt:formatDate value="${customer.openingDate}" pattern="dd-MMM-yyyy"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                        <br />
                        <br />
                    </c:when>
                    <c:otherwise>
                        <h2 style="color: red; text-align: center;">No Records Available</h2>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
</html>


