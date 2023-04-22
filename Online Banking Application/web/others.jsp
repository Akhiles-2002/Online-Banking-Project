<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deposits Result Page</title>
        <style>
            body {
                margin: 0px;
                color: white;
            }

            header {
                margin: 0px;
                padding: 5px;
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

            a {
                color: blue;
                text-decoration: none;
            }

            .libreg {
                color: black;
                height: 500px;
                width: 700px;
                background-color: lightblue;
                border: 2px solid;
                border-radius: 12px;
                opacity: 0.9;
                margin-left: 300px;
                margin-top: 30px;
                text-align: center;
            }

            input {
                border-radius: 10px;
            }
            textArea{
                width: 400px;
                height: 200px;
            }
            
        </style>

    </head>
    <body>

        <!-- This is Header -->
        <header
            style="height:90px; background-color: purple; border-bottom: 5px solid white;">
            <h1 align="center">ONLINE BANKING APPLICATION</h1>
        </header>

        <div
            style="background-color: white; height: 650px; width: 20%; float: left; ">

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
            style="float: left; height: 650px; width: 80%; background-image: url('Banking1.jpg'); background-size: 1215px 650px;">
            <div class="libreg">
                <form action="./otherenquiry" method="post">
                <h1 style="text-align : center; padding: 10px;  margin-right: 100px;">Tell About Your Problem</h1>

                <label>Enter Account Number : </label>
                <input type="text" name="accountno" placeholder="Enter Your Account No." width="300px"/>
                <br/>
                <br/>
                <label>Write some line : </label>
                <textarea name="message">
                    
                </textarea>
                <br/>
                <br/>
                <input type="submit"
                       value="Submit" style="width: 150px; height: 30px;" />
                </form>
            </div>
        </div>
    </body>
</html>
