package in.com.dao;

import in.com.dto.Customer;
import in.com.dto.Employee;
import in.com.util.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDaoImpl implements IEmployeeDao {

    private Connection connection = null;
    private PreparedStatement insertPreparedStatement = null;
    private PreparedStatement retrievePreparedStatement = null;
    private ResultSet resultSet = null;
    private String status = "fail";

    @Override
    public Customer openAccount(String fullname, String gender, String contactno, String emailId, String address, String password, Float balance, String accountType, Date date) {
        String sqlInsertQuery = "insert into customer (`fullname`,`gender`,`contactno`,`emailid`,`address`,`password`) values(?,?,?,?,?,?)";

        Customer customer = null;
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
    public Customer searchCustomer(Integer customerId) {
        ResultSet resultSet1 = null;
        String sqlSelectQuery = "SELECT c.customerId, c.fullname, c.gender, c.contactno, c.emailid, c.password, a.accountno,"
                + " a.balance, a.accounttype, a.openingdate FROM customer c INNER JOIN account a "
                + "ON c.customerId = a.customerId WHERE c.customerId = ?";
        Customer customer = null;

        try {
            connection = JdbcUtil.getJdbcConnection();
            System.out.println("Connection Established...");

            if (connection != null) {
                retrievePreparedStatement = connection.prepareStatement(sqlSelectQuery);
                System.out.println("Prepared Statement Object is created...");
            }
            if (retrievePreparedStatement != null) {
                retrievePreparedStatement.setInt(1, customerId);

                resultSet1 = retrievePreparedStatement.executeQuery();
                System.out.println("ResultSet Object is created...");
            }
            if (resultSet1 != null) {
                if (resultSet1.next()) {
                    customer = new Customer();
                    System.out.println("Customer Object is created...");

                    customer.setCustomerId(resultSet1.getInt(1));
                    customer.setFullname(resultSet1.getString(2));
                    customer.setGender(resultSet1.getString(3));
                    customer.setContactno(resultSet1.getString(4));
                    customer.setEmailId(resultSet1.getString(5));
                    customer.setPassword(resultSet1.getString(6));
                    customer.setAccountNo(resultSet1.getInt(7));
                    customer.setBalance(resultSet1.getFloat(8));
                    customer.setAccountType(resultSet1.getString(9));
                    customer.setOpeningDate(resultSet1.getDate(10));

                    //customer.setAccount(account);
                    System.out.println("Customer Object is : " + customer);
                }
                resultSet1.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet1 != null) {
                    resultSet1.close();
                }
                if (retrievePreparedStatement != null) {
                    retrievePreparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return customer;
    }

    @Override
    public String deleteCustomer(Integer customerId) {

        PreparedStatement preparedStatement = null;
        String sqlDeleteQuery1 = "delete from account where customerId=?";

        try {
            connection = JdbcUtil.getJdbcConnection();

            if (connection != null) {
                connection.setAutoCommit(false);
                insertPreparedStatement = connection.prepareStatement(sqlDeleteQuery1);
            }
            if (insertPreparedStatement != null) {
                insertPreparedStatement.setInt(1, customerId);

                int rowAffected = insertPreparedStatement.executeUpdate();

                if (rowAffected == 1) {
                    String sqlDeleteQuery2 = "delete from customer where customerId=?";
                    preparedStatement = connection.prepareStatement(sqlDeleteQuery2);

                    if (preparedStatement != null) {
                        preparedStatement.setInt(1, customerId);

                        int deleteSuceessfull = preparedStatement.executeUpdate();
                        if (deleteSuceessfull == 1) {
                            connection.commit();
                            return "success";
                        }
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
        return status;
    }

    @Override
    public String updateCustomer(Customer customer) {
        String sqlUpdateQuery = "UPDATE customer SET fullname=?, gender=?, emailid=?, password=? WHERE customerId=?";

        try {
            connection = JdbcUtil.getJdbcConnection();

            if (connection != null) {
                insertPreparedStatement = connection.prepareStatement(sqlUpdateQuery);
            }
            if (insertPreparedStatement != null) {
                insertPreparedStatement.setString(1, customer.getFullname());
                insertPreparedStatement.setString(2, customer.getGender());
                insertPreparedStatement.setString(3, customer.getEmailId());
                insertPreparedStatement.setString(4, customer.getPassword());
                insertPreparedStatement.setInt(5, customer.getCustomerId());

                int rowAffected = insertPreparedStatement.executeUpdate();
                System.out.println("Row Affected : " + rowAffected);

                if (rowAffected == 1) {
                    return "success";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Status Sending: " + status);
        return status;
    }

    @Override
    public String loginEmployee(Integer employeeId, String password) {

        String sqlQuery = "select employeeId, password from employee where employeeId=? and password=?";

        try {
            connection = JdbcUtil.getJdbcConnection();

            if (connection != null) {
                retrievePreparedStatement = connection.prepareStatement(sqlQuery);
            }
            if (retrievePreparedStatement != null) {
                retrievePreparedStatement.setInt(1, employeeId);
                retrievePreparedStatement.setString(2, password);
                resultSet = retrievePreparedStatement.executeQuery();
            }
            if (resultSet != null) {
                if (resultSet.next()) {
                    return "success";
                }
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }

        return status;
    }

    @Override
    public List<Customer> showAllCustomers() {
        List<Customer> customerList = null;
        Customer customer = null;

        try {
            connection = JdbcUtil.getJdbcConnection();

            if (connection != null) {
                String sqlSelectQuery = "SELECT customer.customerId, customer.fullname, customer.gender, customer.contactno, "
                        + "customer.emailid, customer.password, account.accountno, account.balance, "
                        + "account.accounttype, account.openingdate FROM customer JOIN account "
                        + "ON customer.customerId = account.customerId ";

                retrievePreparedStatement = connection.prepareStatement(sqlSelectQuery);
            }
            if (retrievePreparedStatement != null) {
                resultSet = retrievePreparedStatement.executeQuery();
            }
            if (resultSet != null) {
                customerList = new ArrayList<>();
                while (resultSet.next()) {
                    customer = new Customer();
                    customer.setCustomerId(resultSet.getInt(1));
                    customer.setFullname(resultSet.getString(2));
                    customer.setGender(resultSet.getString(3));
                    customer.setContactno(resultSet.getString(4));
                    customer.setEmailId(resultSet.getString(5));
                    customer.setPassword(resultSet.getString(6));
                    customer.setAccountNo(resultSet.getInt(7));
                    customer.setBalance(resultSet.getFloat(8));
                    customer.setAccountType(resultSet.getString(9));
                    customer.setOpeningDate(resultSet.getDate(10));

                    customerList.add(customer);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }

}
