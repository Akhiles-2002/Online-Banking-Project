<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
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
                padding: 10px;
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

            a{
                text-decoration: none;
            }

            table{
                padding-left: 100px;
            }

            .libreg {
                color: black;
                height: 625px;
                width: 700px;
                background-color: lightblue;
                opacity: 0.9;
                margin-left: 200px;
                border-radius: 12px;
                text-align: center;
                padding-left: 10px;
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

        <div
            style="float: left; height: 650px; width: 80%; background-size: 1215px 650px;">
            <!-- <img src="background-modified.jpg" width="1215px" height="650px" /> -->

            <div class="libreg">
                <h1 style="text-align: center; padding-top: 0px;">Account Opening Form</h1><br/><br/>
                <form method="post" action="./openAccount">

                    <table cellpadding="12px">
                        <tr>
                            <th>Full Name ::</th>
                            <td><input type="text" name="fullname" placeholder="Enter Full Name" required="required"/> </td>
                        </tr>
                        <tr>
                            <th>Gender ::</th>
                            <td><input type="radio" name="gender" value="Male" checked="checked"/><label>Male</label>
                                <input type="radio" name="gender" value="Female" checked="checked"/><label>Female</label></td>
                        </tr>
                        <tr>
                            <th>Contact No. ::</th>
                            <td><input type="text" name="contactno" placeholder="Enter Contact No." required="required"/> </td>
                        </tr>
                        <tr>
                            <th>Email Id ::</th>
                            <td><input type="email" name="emailid" placeholder="Enter Email Id" required="required"/> </td>
                        </tr>
                        <tr>
                            <th>Address ::</th>
                            <td><input type="text" name="address" placeholder="Enter Address" required="required"/> </td>
                        </tr>
                        <tr>
                            <th>Set Password ::</th>
                            <td><input type="password" name="password" placeholder="Enter Password" required="required"/> </td>
                        </tr>
                        <tr>
                            <th>Account Type ::</th>
                            <td><input type="radio" name="accounttype" value="savings" checked="checked"/><label>Savings Account</label>
                                <input type="radio" name="accounttype" value="current" checked="checked"/><label>Current Account</label></td>
                        </tr>
                        <tr>
                            <th>Account Opening Balance ::</th>
                            <td><input type="text" name="balance" placeholder="Enter Amount" required="required"/> </td>
                        </tr>
                        <tr>
                            <th>Account Opening Date ::</th>
                            <td><input type="date" name="openingdate" placeholder="Enter Today Date" required="required"/> </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><input type="submit" value="Open Account" /> </td>
                        </tr>

                    </table>		
                </form>
            </div>   
        </div>
    </body>
</html>


