<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
                background-color: white;
            }

            .links {
                background-color: lightblue;
                height: 30px;
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
                border: 2px solid black;
            }

            .libreg {
                color: black;
                height: 500px;
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
                text-decoration: none;
                color: blue;
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
            style="height:100px; background-color: purple; border-bottom: 5px solid white;">
            <h1 align="center">ONLINE BANKING APPLICATION</h1>
        </header>


        <div
            style="background-color: white; height: 650px; width: 20%; float: left;">

            <div class="links">
                <a href="./managerWindow.jsp">Manager</a>
            </div>

            <div class="links">
                <a href="./registerEmployee.jsp">Register Employee</a>
            </div>
            <div class="links">
                <a href="./searchEmployee.html">Search Employee</a>
            </div>
            <div class="links">
                <a href="./updateEmployee.html">Update Employee</a>
            </div>
            <div class="links">
                <a href="./deleteEmployee.html">Delete Employee</a>
            </div>
            <div class="links">
                <a href="./showAllEmployees">Show All Employees</a>
            </div>
            <div class="links">
                <a href="./managerLogout.jsp">Logout</a>
            </div>
        </div>

        <div
            style="float: left; height: 650px; width: 80%; background-image: url('./Banking1.jpg'); background-size: 1215px 650px;">
            <!-- <img src="background-modified.jpg" width="1215px" height="650px" /> -->

            <div class="libreg">
                <c:choose>
                    <c:when test="${employee ne null}">
                        <h1>Employee Details</h1>
                        <table style="border: 1px solid black; cellpadding:10px; text-align: center; ">
                            <tr>
                                <th>Employee ID</th>
                                <td>${employee.employeeId}</td>
                            </tr>
                            <tr>
                                <th>Full Name</th>
                                <td>${employee.fullname}</td> 
                            </tr>
                            <tr>
                                <th>Gender</th>
                                <td>${employee.gender}</td>                  
                            </tr>
                            <tr>
                                <th>Email Id</th>
                                <td>${employee.emailId}</td>                 
                            </tr>
                            <tr>
                                <th>Password</th>
                                <td>${employee.password}</td>
                            </tr>
                        </table>
                        <br/><br/>
                        <div class="links" style="width: 300px; margin-left: 250px;">
                            <a href="./searchEmployee.html">Search More Employees</a>
                        </div>
                        <div class="links" style="width: 300px; margin-left: 250px;">
                            <a href="./managerWindow.jsp">Go Back</a>
                        </div>
                    </c:when>
                    <c:otherwise>
                         <h1 style="color: red; text-align: center">Record Not Found
                            for Entered Id</h1>

                        <div class="links" style="width: 300px; margin-left: 250px;">
                            <a href="./searchEmployee.html">Search More Employees</a>
                        </div>

                        <div class="links" style="width: 300px; margin-left: 250px;">
                            <a href="./managerWindow.jsp">Go Back</a>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
</html>






















