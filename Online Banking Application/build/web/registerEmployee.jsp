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
            
            table{
                padding-left: 100px;
            }

            .libreg {
                color: black;
                height: 500px;
                width: 550px;
                background-color: lightblue;
                opacity: 0.9;
                margin-left: 300px;
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
            style="float: left; height: 650px; width: 80%; background-size: 1215px 650px;">
            <!-- <img src="background-modified.jpg" width="1215px" height="650px" /> -->

            <div class="libreg">
                <h1 style="text-align: center;">Register Employee</h1>
                <br /> <br />
                <form method="post" action="./registerEmployee">
                    <table cellpadding="10px">
                        <tr>
                            <th>Full Name ::</th>
                            <td><input type="text" name="fullname" placeholder="Enter Full Name" required="required"/></td>
                        </tr>
                        <tr>
                            <th>Gender ::</th>
                            <td><input type="radio" name="gender" value="Male" checked='checked'/><label>Male</label>
                                <input type="radio" name="gender" value="Female" checked='checked'/><label>Female</label></td>
                        </tr>
                        <tr>
                            <th>E-Mail Id ::</th>
                            <td><input type="email" name="emailid" placeholder="Enter Email Id" required="required"/></td>
                        </tr>
                        <tr>
                            <th>Contact No. ::</th>
                            <td><input type="tel" name="contactno" placeholder="Enter Contact Number" required="required"/></td>
                        </tr>
                        <tr>
                            <th>Password ::</th>

                            <td><input type="password" name="password" placeholder="Enter Password" required="required"/></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><input type="submit"
                                                                  value="Register" style="width: 150px; height: 30px;" /></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>


