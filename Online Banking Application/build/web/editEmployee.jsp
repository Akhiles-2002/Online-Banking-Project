<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Edit Window</title>
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

            input {
                border-radius: 10px;
            }
            
            .links:hover {
                background-color: cyan;
            }
            
            .libreg {
                color: black;
                height: 500px;
                width: 600px;
                background-color: lightblue;
                border: 2px solid;
                border-radius: 12px;
                opacity: 0.9;
                margin-left: 300px;
                margin-top: 30px;
                text-align: center;
            }
            
            a {
                color: blue;
                text-decoration: none;
            }
        </style>

    </head>
    <body bgcolor="gray">


        <header
            style="height: 100px; background-color: purple; color:white; border-bottom: 5px solid gray;">
            <h1 align="center">ONLINE BANKING APPLICATION</h1>
        </header>

        <!--For Menu Option to the Admin  -->
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

        <!-- Body  -->
        <div
            style="float: left; height: 650px; width: 80%; background-image: url('./Banking1.jpg'); background-size: 1215px 650px;">
            <!-- <img src="background-modified.jpg" width="1215px" height="650px" /> -->

            <div class="libreg" style=" padding-left: 100px;">
                <h1 style="text-align: justify-all;">Edit Employee Details</h1>
                <c:choose>
                    <c:when test="${employee ne null}">
                        <br />
                        <br />
                        <form method="post" action="./updateEmployee">
                            <table cellpadding="10px">
                                <tr>
                                    <th>Employee Id</th>
                                    <td><input type="text" name="employeeId"
                                               value="${employee.employeeId}" readonly="readonly" /></td>
                                </tr>
                                <tr>
                                    <th>Employee Name</th>
                                    <td><input type="text" name="fullname"
                                               value="${employee.fullname}" /></td>
                                </tr>
                                <tr>
                                    <th>Gender</th>
                                    <td><input type="radio" name="gender"
                                               value="${employee.gender}" /><label>Male</label> <input
                                               type="radio" name="gender" value="${employee.gender}" /><label>Female</label></td>
                                </tr>
                                <tr>
                                    <th>Contact No.</th>
                                    <td><input type="text" name="contactno"
                                               value="${employee.contactno}" /></td>
                                </tr>
                                <tr>
                                    <th>Email Id</th>
                                    <td><input type="email" name="emailid"
                                               value="${employee.emailId}" /></td>
                                </tr>
                                <tr>
                                    <th>Set Password</th>

                                    <td><input type="password" name="password"
                                               value="${employee.password}" /></td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center"><input type="submit"
                                                      value="Update" style="width: 150px; height: 30px;" /></td>
                                </tr>
                            </table>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <h1 style="color: red; text-align: center;">Record Not
                            Available</h1>

                        <div class="links" style="width: 300px; margin-left: 150px;">
                            <a href="./updateEmployee.html">Update Librarian</a>
                        </div>

                        <div class="links" style="width: 300px; margin-left: 150px;">
                            <a href="./managerWindow.jsp">Go Back</a>
                        </div>

                    </c:otherwise>
                </c:choose>
            </div>

        </div>
    </body>
</html>