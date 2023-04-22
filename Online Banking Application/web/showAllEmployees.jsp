<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Employees</title>
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
                height: 600px;
                width: 900px;
                background-color: lightblue;
                margin-left: 50px;
                border-radius: 12px;
                text-align: center;
                padding-left: 100px;
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
            style="float: left; height: 650px; width: 80%; background-image: url('./Banking1.jpg'); background-size: 1250px 650px;">
            <!-- <img src="background-modified.jpg" width="1215px" height="650px" /> -->

            <div class="libreg" style=" overflow-y: auto">
                <h2>All Employee Record</h2>
                <br />
                <c:choose>
                    <c:when test="${employeeList ne null}">
                        <table border="1" cellpadding="5px" align="center">
                            <tr style="color: white;">
                                <th>Employee Id</th>
                                <th>Full Name</th>
                                <th>Gender</th>
                                <th>Contact No</th>
                                <th>EMail Id</th>
                                <th>Password</th> 
                            </tr>
                            <br/>
                            <c:forEach var="employee" items="${employeeList}">
                                <tr>
                                    <!-- Display the employee details -->
                                    <td>${employee.employeeId}</td>
                                    <td>${employee.fullname}</td>
                                    <td>${employee.gender}</td>
                                    <td>${employee.contactno}</td>
                                    <td>${employee.emailId}</td>
                                    <td>${employee.password}</td>
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


