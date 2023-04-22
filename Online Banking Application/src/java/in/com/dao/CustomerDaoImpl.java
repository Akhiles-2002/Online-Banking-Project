package in.com.dao;

import in.com.dto.Customer;
import in.com.util.JdbcUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class CustomerDaoImpl implements ICustomerDao {

    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement insertPreparedStatement = null;
    private PreparedStatement insertPreparedStatement1 = null;
    private PreparedStatement retrievePreparedStatement = null;
    private Customer customer = null;
    String status = "fail";

    @Override
    public Customer registerCustomer(String fullname, String gender, String contactno, String emailId, String address, String password, Float balance, String accountType, Date date) {
        String sqlInsertQuery = "insert into customer (`fullname`,`gender`,`contactno`,`emailid`,`address`,`password`) values(?,?,?,?,?,?)";

        connection = JdbcUtil.getJdbcConnection();
        try {
            if (connection != null) {
                connection.setAutoCommit(false);
                insertPreparedStatement = connection.prepareStatement(sqlInsertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            }
            if (insertPreparedStatement != null) {
                insertPreparedStatement.setString(1, fullname);
                insertPreparedStatement.setString(2, gender);
                insertPreparedStatement.setString(3, contactno);
                insertPreparedStatement.setString(4, emailId);
                insertPreparedStatement.setString(5, address);
                insertPreparedStatement.setString(6, password);

                int rowAffected = insertPreparedStatement.executeUpdate();
                customer = new Customer();

                resultSet = insertPreparedStatement.getGeneratedKeys();
                Integer customerId = null;

                if (resultSet.next()) {
                    customerId = resultSet.getInt(1);
                    System.out.println("Customer id is " + customerId);
                    customer.setCustomerId(customerId);
                    customer.setFullname(fullname);
                    customer.setGender(gender);
                    customer.setContactno(contactno);
                    customer.setEmailId(emailId);
                    customer.setAddress(address);
                    customer.setPassword(password);
                }

                if (rowAffected == 1) {
                    String sqlInsertAccountQuery = "insert into account (`balance`,`accounttype`,`customerid`,`openingdate`) values(?,?,?,?)";
                    PreparedStatement insertAccountPreparedStatement = connection.prepareStatement(sqlInsertAccountQuery, PreparedStatement.RETURN_GENERATED_KEYS);
                    insertAccountPreparedStatement.setFloat(1, balance);
                    insertAccountPreparedStatement.setString(2, accountType);
                    insertAccountPreparedStatement.setInt(3, customerId);
                    insertAccountPreparedStatement.setDate(4, new java.sql.Date(date.getTime()));
                    int rowAffectedAccount = insertAccountPreparedStatement.executeUpdate();

                    resultSet = insertAccountPreparedStatement.getGeneratedKeys();
                    Integer accountNo = null;

                    if (resultSet.next()) {
                        accountNo = resultSet.getInt(1);
                        customer.setAccountNo(accountNo);
                        customer.setBalance(balance);
                        customer.setAccountType(accountType);
                        customer.setCustomerId(customerId);
                        customer.setOpeningDate(date);
                    }

                    if (rowAffectedAccount == 1) {
                        connection.commit();
                        return customer;
                    }
                }
            }

        } catch (SQLException se) {
            se.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return customer;
    }

    @Override
    public Customer myaccount(Integer customerId) {

        String sqlSelectQuery = "SELECT customer.customerid, customer.fullname, customer.gender, customer.contactno, customer.emailid, customer.address, customer.password, \n"
                + "       account.accountno, account.balance, account.accounttype, account.openingdate\n"
                + "FROM customer\n"
                + "JOIN account ON customer.customerid = account.customerid\n"
                + "WHERE customer.customerid = ?";

        connection = JdbcUtil.getJdbcConnection();
        try {
            if (connection != null) {
                retrievePreparedStatement = connection.prepareStatement(sqlSelectQuery);
            }
            if (retrievePreparedStatement != null) {
                customer = new Customer();
                retrievePreparedStatement.setInt(1, customerId);

                resultSet = retrievePreparedStatement.executeQuery();
            }
            if (resultSet != null) {

                if (resultSet.next()) {
                    customer.setCustomerId(resultSet.getInt("customerid"));
                    customer.setFullname(resultSet.getString("fullname"));
                    customer.setGender(resultSet.getString("gender"));
                    customer.setContactno(resultSet.getString("contactno"));
                    customer.setEmailId(resultSet.getString("emailid"));
                    customer.setAddress(resultSet.getString("address"));
                    customer.setPassword(resultSet.getString("password"));
                    customer.setAccountNo(resultSet.getInt("accountno"));
                    customer.setBalance(resultSet.getFloat("balance"));
                    customer.setAccountType(resultSet.getString("accounttype"));
                    java.sql.Date openingDate = resultSet.getDate("openingdate");
                    if (openingDate == null) {
                        customer.setOpeningDate(null);
                    } else {
                        customer.setOpeningDate(new java.util.Date(openingDate.getTime()));
                    }
                    return customer;
                }
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public String loginCustomer(Integer customerId, String password) {
        String sqlQuery = "select customerid, password from customer where customerId=? and password=?";

        try {
            connection = JdbcUtil.getJdbcConnection();

            if (connection != null) {
                retrievePreparedStatement = connection.prepareStatement(sqlQuery);
            }
            if (retrievePreparedStatement != null) {
                retrievePreparedStatement.setInt(1, customerId);
                retrievePreparedStatement.setString(2, password);
                resultSet = retrievePreparedStatement.executeQuery();
            }
            if (resultSet != null) {
                if (resultSet.next()) {

                    customer = new Customer();
                    customer.setCustomerId(customerId);
                    return "success";
                }
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
        System.out.println("Status is : " + status);
        return status;
    }

    @Override
    public String transferMoney(Integer customerId, Integer toAccount, Float amount, String password) {

        PreparedStatement retrievePreparedStatement = null;
        PreparedStatement updatePreparedStatement1 = null;
        PreparedStatement updatePreparedStatement2 = null;
        PreparedStatement insertPreparedStatement1 = null;
        PreparedStatement insertPreparedStatement2 = null;
        ResultSet resultSet = null;
        String status = "transaction failed";

        try {
            connection = JdbcUtil.getJdbcConnection();
            connection.setAutoCommit(false);
            String sqlSelectQuery = "SELECT customer.customerid, customer.password, \n"
                    + " account.accountno, account.balance\n"
                    + "FROM customer\n"
                    + "JOIN account ON customer.customerid = account.customerid\n"
                    + "WHERE customer.customerid = ?";
// Get the balance of the account from which money is being transferred
            retrievePreparedStatement = connection.prepareStatement(sqlSelectQuery);
            retrievePreparedStatement.setInt(1, customerId);

            resultSet = retrievePreparedStatement.executeQuery();
            if (resultSet.next()) {
                Integer customerid = resultSet.getInt(1);
                String pass = resultSet.getString(2);
                Integer accountno = resultSet.getInt(3);
                Float balance = resultSet.getFloat(4);

                if (customerid.equals(customerId) && pass.equals(password)) {
                    // Check if there is enough balance to transfer
                    if (balance >= amount) {
                        // Deduct the amount from the fromAccount and update the balance
                        balance -= amount;
                        updatePreparedStatement1 = connection.prepareStatement("UPDATE account SET balance = ? WHERE accountno = ?");
                        updatePreparedStatement1.setFloat(1, balance);
                        updatePreparedStatement1.setInt(2, accountno);
                        int r1 = updatePreparedStatement1.executeUpdate();
                        System.out.println("1st account Balance update successfully");

                        if (r1 == 1) {
                            // Add the amount to the toAccount and update the balance
                            updatePreparedStatement2 = connection.prepareStatement("UPDATE account SET balance = balance + ? WHERE accountno = ?");
                            updatePreparedStatement2.setFloat(1, amount);
                            updatePreparedStatement2.setInt(2, toAccount);
                            int r2 = updatePreparedStatement2.executeUpdate();
                            System.out.println("2nd account Balance update successfully");

                            if (r2 == 1) {
                                // Insert transaction records for both accounts

                                insertPreparedStatement1 = connection.prepareStatement("INSERT INTO transaction (`transdesc`,`transtype`,`transamount`,`transdate`,`accountno`) VALUES (?, ?, ?, NOW(), ?)");
                                insertPreparedStatement1.setString(1, "Transfer money to account " + toAccount);
                                insertPreparedStatement1.setString(2, "debit");
                                insertPreparedStatement1.setFloat(3, amount);
                                insertPreparedStatement1.setInt(4, accountno);
                                int r3 = insertPreparedStatement1.executeUpdate();
                                System.out.println("1st Insertion successfully");

                                if (r3 == 1) {
                                    insertPreparedStatement2 = connection.prepareStatement("INSERT INTO transaction (`transdesc`,`transtype`,`transamount`,`transdate`,`accountno`) VALUES (?, ?, ?, NOW(), ?)");
                                    insertPreparedStatement2.setString(1, "Received money from account " + accountno);
                                    insertPreparedStatement2.setString(2, "credit");
                                    insertPreparedStatement2.setFloat(3, amount);
                                    insertPreparedStatement2.setInt(4, toAccount);
                                    int r4 = insertPreparedStatement2.executeUpdate();
                                    System.out.println("2nd Insertion successfully");

                                    if (r4 == 1) {
                                        connection.commit();
                                        return "Money Transfer Successfully to Account Number " + toAccount;
                                    }
                                }

                            } else {
                                connection.rollback();
                                System.out.println("Else block Rollback 1");
                                status = "transaction failed";
                            }

                        } else {
                            connection.rollback();
                            System.out.println("Else block Rollback 2");
                            status = "transaction failed";
                        }

                    } else {
                        status = "insufficient balance";
                    }
                }
            } else {
                status = "Customer Id and Password are Incorrect";
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
// Close all the resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (retrievePreparedStatement != null) {
                    retrievePreparedStatement.close();
                }
                if (updatePreparedStatement1 != null) {
                    updatePreparedStatement1.close();
                }
                if (updatePreparedStatement2 != null) {
                    updatePreparedStatement2.close();
                }
                if (insertPreparedStatement1 != null) {
                    insertPreparedStatement1.close();
                }
                if (insertPreparedStatement2 != null) {
                    insertPreparedStatement2.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    @Override
    public String enquiry(String message, Integer accountNo) {

        String sqlInsertQuery = "insert into enquiry (`query`,`accountno`) values (?,?)";

        Connection connection = JdbcUtil.getJdbcConnection();
        PreparedStatement preparedStatement = null;

        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(sqlInsertQuery);
            }
            if (preparedStatement != null) {
                preparedStatement.setString(1, message);
                preparedStatement.setInt(2, accountNo);

                int rowAffected = preparedStatement.executeUpdate();

                if (rowAffected == 1) {
                    return "success";
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public String billPayments(Integer customerId, Integer toAccount, Float amount, String password) {
        PreparedStatement retrievePreparedStatement = null;
        PreparedStatement updatePreparedStatement1 = null;
        PreparedStatement updatePreparedStatement2 = null;
        PreparedStatement insertPreparedStatement1 = null;
        PreparedStatement insertPreparedStatement2 = null;
        ResultSet resultSet = null;
        String status = "transaction failed";

        try {
            connection = JdbcUtil.getJdbcConnection();
            connection.setAutoCommit(false);
            String sqlSelectQuery = "SELECT customer.customerid, customer.password, \n"
                    + " account.accountno, account.balance\n"
                    + "FROM customer\n"
                    + "JOIN account ON customer.customerid = account.customerid\n"
                    + "WHERE customer.customerid = ?";
// Get the balance of the account from which money is being transferred
            retrievePreparedStatement = connection.prepareStatement(sqlSelectQuery);
            retrievePreparedStatement.setInt(1, customerId);

            resultSet = retrievePreparedStatement.executeQuery();
            if (resultSet.next()) {
                Integer customerid = resultSet.getInt(1);
                String pass = resultSet.getString(2);
                Integer accountno = resultSet.getInt(3);
                Float balance = resultSet.getFloat(4);

                if (customerid.equals(customerId) && pass.equals(password)) {
                    // Check if there is enough balance to transfer
                    if (balance >= amount) {
                        // Deduct the amount from the fromAccount and update the balance
                        balance -= amount;
                        updatePreparedStatement1 = connection.prepareStatement("UPDATE account SET balance = ? WHERE accountno = ?");
                        updatePreparedStatement1.setFloat(1, balance);
                        updatePreparedStatement1.setInt(2, accountno);
                        int r1 = updatePreparedStatement1.executeUpdate();
                        System.out.println("1st account Balance update successfully");

                        if (r1 == 1) {
                            // Add the amount to the toAccount and update the balance
                            updatePreparedStatement2 = connection.prepareStatement("UPDATE account SET balance = balance + ? WHERE accountno = ?");
                            updatePreparedStatement2.setFloat(1, amount);
                            updatePreparedStatement2.setInt(2, toAccount);
                            int r2 = updatePreparedStatement2.executeUpdate();
                            System.out.println("2nd account Balance update successfully");

                            if (r2 == 1) {
                                // Insert transaction records for both accounts

                                insertPreparedStatement1 = connection.prepareStatement("INSERT INTO transaction (`transdesc`,`transtype`,`transamount`,`transdate`,`accountno`) VALUES (?, ?, ?, NOW(), ?)");
                                insertPreparedStatement1.setString(1, "Transfer money to account " + toAccount);
                                insertPreparedStatement1.setString(2, "debit");
                                insertPreparedStatement1.setFloat(3, amount);
                                insertPreparedStatement1.setInt(4, accountno);
                                int r3 = insertPreparedStatement1.executeUpdate();
                                System.out.println("1st Insertion successfully");

                                if (r3 == 1) {
                                    insertPreparedStatement2 = connection.prepareStatement("INSERT INTO transaction (`transdesc`,`transtype`,`transamount`,`transdate`,`accountno`) VALUES (?, ?, ?, NOW(), ?)");
                                    insertPreparedStatement2.setString(1, "Received money from account " + accountno);
                                    insertPreparedStatement2.setString(2, "credit");
                                    insertPreparedStatement2.setFloat(3, amount);
                                    insertPreparedStatement2.setInt(4, toAccount);
                                    int r4 = insertPreparedStatement2.executeUpdate();
                                    System.out.println("2nd Insertion successfully");

                                    if (r4 == 1) {
                                        connection.commit();
                                        return "Bill Paid Successfully to Account Number " + toAccount;
                                    }
                                }

                            } else {
                                connection.rollback();
                                System.out.println("Else block Rollback 1");
                                status = "Bill payment failed";
                            }

                        } else {
                            connection.rollback();
                            System.out.println("Else block Rollback 2");
                            status = "Bill payment failed";
                        }

                    } else {
                        status = "insufficient balance";
                    }
                }
            } else {
                status = "Customer Id and Password are Incorrect";
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
// Close all the resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (retrievePreparedStatement != null) {
                    retrievePreparedStatement.close();
                }
                if (updatePreparedStatement1 != null) {
                    updatePreparedStatement1.close();
                }
                if (updatePreparedStatement2 != null) {
                    updatePreparedStatement2.close();
                }
                if (insertPreparedStatement1 != null) {
                    insertPreparedStatement1.close();
                }
                if (insertPreparedStatement2 != null) {
                    insertPreparedStatement2.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    @Override
    public String deposits(Integer toAccount, Integer customerId, Float amount, String password) {

        PreparedStatement retrievePreparedStatement = null;
        PreparedStatement updatePreparedStatement1 = null;
        PreparedStatement updatePreparedStatement2 = null;
        PreparedStatement insertPreparedStatement1 = null;
        PreparedStatement insertPreparedStatement2 = null;
        ResultSet resultSet = null;
        String status = "transaction failed";

        try {
            connection = JdbcUtil.getJdbcConnection();
            connection.setAutoCommit(false);
            String sqlSelectQuery = "SELECT customer.customerid, customer.password, \n"
                    + " account.accountno, account.balance\n"
                    + "FROM customer\n"
                    + "JOIN account ON customer.customerid = account.customerid\n"
                    + "WHERE customer.customerid = ?";
// Get the balance of the account from which money is being transferred
            retrievePreparedStatement = connection.prepareStatement(sqlSelectQuery);
            retrievePreparedStatement.setInt(1, customerId);

            resultSet = retrievePreparedStatement.executeQuery();
            if (resultSet.next()) {
                Integer customerid = resultSet.getInt(1);
                String pass = resultSet.getString(2);
                Integer accountno = resultSet.getInt(3);
                Float balance = resultSet.getFloat(4);

                if (customerid.equals(customerId) && pass.equals(password)) {
                    // Check if there is enough balance to transfer
                    if (balance >= amount) {
                        // Deduct the amount from the fromAccount and update the balance
                        balance -= amount;
                        updatePreparedStatement1 = connection.prepareStatement("UPDATE account SET balance = ? WHERE accountno = ?");
                        updatePreparedStatement1.setFloat(1, balance);
                        updatePreparedStatement1.setInt(2, accountno);
                        int r1 = updatePreparedStatement1.executeUpdate();
                        System.out.println("1st account Balance update successfully");

                        if (r1 == 1) {
                            // Add the amount to the toAccount and update the balance
                            updatePreparedStatement2 = connection.prepareStatement("UPDATE account SET balance = balance + ? WHERE accountno = ?");
                            updatePreparedStatement2.setFloat(1, amount);
                            updatePreparedStatement2.setInt(2, toAccount);
                            int r2 = updatePreparedStatement2.executeUpdate();
                            System.out.println("2nd account Balance update successfully");

                            if (r2 == 1) {
                                // Insert transaction records for both accounts

                                insertPreparedStatement1 = connection.prepareStatement("INSERT INTO transaction (`transdesc`,`transtype`,`transamount`,`transdate`,`accountno`) VALUES (?, ?, ?, NOW(), ?)");
                                insertPreparedStatement1.setString(1, "Transfer money to account " + toAccount);
                                insertPreparedStatement1.setString(2, "debit");
                                insertPreparedStatement1.setFloat(3, amount);
                                insertPreparedStatement1.setInt(4, accountno);
                                int r3 = insertPreparedStatement1.executeUpdate();
                                System.out.println("1st Insertion successfully");

                                if (r3 == 1) {
                                    insertPreparedStatement2 = connection.prepareStatement("INSERT INTO transaction (`transdesc`,`transtype`,`transamount`,`transdate`,`accountno`) VALUES (?, ?, ?, NOW(), ?)");
                                    insertPreparedStatement2.setString(1, "Received money from account " + accountno);
                                    insertPreparedStatement2.setString(2, "credit");
                                    insertPreparedStatement2.setFloat(3, amount);
                                    insertPreparedStatement2.setInt(4, toAccount);
                                    int r4 = insertPreparedStatement2.executeUpdate();
                                    System.out.println("2nd Insertion successfully");

                                    if (r4 == 1) {
                                        connection.commit();
                                        return "Deposit Successfully to Account Number" + toAccount;
                                    }
                                }

                            } else {
                                connection.rollback();
                                System.out.println("Else block Rollback 1");
                                status = "Bill payment failed";
                            }

                        } else {
                            connection.rollback();
                            System.out.println("Else block Rollback 2");
                            status = "Bill payment failed";
                        }

                    } else {
                        status = "insufficient balance";
                    }
                }
            } else {
                status = "Customer Id and Password are Incorrect";
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
// Close all the resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (retrievePreparedStatement != null) {
                    retrievePreparedStatement.close();
                }
                if (updatePreparedStatement1 != null) {
                    updatePreparedStatement1.close();
                }
                if (updatePreparedStatement2 != null) {
                    updatePreparedStatement2.close();
                }
                if (insertPreparedStatement1 != null) {
                    insertPreparedStatement1.close();
                }
                if (insertPreparedStatement2 != null) {
                    insertPreparedStatement2.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }

}
