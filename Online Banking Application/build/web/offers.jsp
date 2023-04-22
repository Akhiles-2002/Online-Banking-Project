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

                <h1 style="text-align : center; padding: 10px;  margin-right: 100px;">About Offers</h1>

                <p>
                    Dear valued customers,

                    As the festive season approaches, we are thrilled to announce that our bank will be offering exciting deals and 
                    discounts to make your celebrations even more special. From Diwali to Holi and beyond, we have a range of 
                    exclusive offers that you won't want to miss out on.

                    Stay tuned for updates on our website and social media channels to be the first to know about our upcoming 
                    festival offers. Our team is working tirelessly to bring you the best deals on banking products and services 
                    that will make your life easier and more enjoyable.

                    Whether you're looking for a new credit card, a loan for your dream home, or simply want to open a savings account, 
                    our festive offers are designed to help you save money and achieve your financial goals.

                    Thank you for choosing us as your trusted banking partner. We look forward to celebrating the festive season with 
                    you and making it a truly memorable one.
                    <br/>
                    Warm regards,
                    <br/>
                    by Easy Banking
                </p>
            </div>
        </div>
    </body>
</html>
