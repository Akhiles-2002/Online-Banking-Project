<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Edit window</title>
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
                width: 500px;
                background-color: lightblue;
                border: 2px solid;
                border-radius: 12px;
                opacity: 0.9;
                margin-left: 300px;
                margin-top: 30px;
                text-align: center;
                padding-left: 100px;
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

        <!-- Body  -->
        <div
            style="float: left; height: 650px; width: 80%; background-image: url('./Banking1.jpg'); background-size: 1215px 650px;">
            <!-- <img src="background-modified.jpg" width="1215px" height="650px" /> -->

            <div class="libreg" style=" padding-left: 100px;">
                <h1 style="text-align: justify;">Edit Customer Details</h1>
                <c:choose>
                    <c:when test="${customer ne null}">
                        <br />
                        <br />
                        <form method="post" action="./updateCustomer">
                            <table cellpadding="10px">
                                <tr>
                                    <th>Customer Id</th>
                                    <td><input type="text" name="customerId"
                                               value="${customer.customerId}" readonly="readonly" /></td>
                                </tr>
                                <tr>
                                    <th>Customer Name</th>
                                    <td><input type="text" name="fullname"
                                               value="${customer.fullname}" /></td>
                                </tr>
                                <tr>
                                    <th>Gender</th>
                                    <td><input type="radio" name="gender"
                                               value="${customer.gender}" /><label>Male</label> <input
                                               type="radio" name="gender" value="${customer.gender}" /><label>Female</label></td>
                                </tr>
                                <tr>
                                    <th>Email Id</th>
                                    <td><input type="email" name="emailid"
                                               value="${customer.emailId}" /></td>
                                </tr>
                                <tr>
                                    <th>Set Password</th>

                                    <td><input type="password" name="password"
                                               value="${customer.password}" /></td>
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
                            <a href="./updateCustomer.html">Update Librarian</a>
                        </div>

                        <div class="links" style="width: 300px; margin-left: 150px;">
                            <a href="./employeeWindow.jsp">Go Back</a>
                        </div>

                    </c:otherwise>
                </c:choose>
            </div>

        </div>
    </body>
</html>