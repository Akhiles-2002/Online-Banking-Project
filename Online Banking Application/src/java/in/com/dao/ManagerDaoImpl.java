package in.com.dao;

import in.com.dto.Employee;
import in.com.dto.Manager;
import in.com.util.JdbcUtil;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManagerDaoImpl implements IManagerDao {

    private Connection connection = null;
    private PreparedStatement insertPreparedStatement = null;
    private PreparedStatement retrievePreparedStatement = null;
    private ResultSet resultSet = null;
    private String status = "fail";

    @Override
    public Manager managerRegister(String fullname, String gender, String contactno, String emailid, String password) {
        String sqlInsertQuery = "insert into manager(`fullname`,`gender`,`contactno`,`emailid`,`password`) values (?,?,?,?,?)";
        Manager manager = null;

        try {
            //Estatlishing the Connection
            connection = JdbcUtil.getJdbcConnection();

            if (connection != null) {
                insertPreparedStatement = connection.prepareStatement(sqlInsertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            }
            if (insertPreparedStatement != null) {
                insertPreparedStatement.setString(1, fullname);
                insertPreparedStatement.setString(2, gender);
                insertPreparedStatement.setString(3, contactno);
                insertPreparedStatement.setString(4, emailid);
                insertPreparedStatement.setString(5, password);

                int rowAffected = insertPreparedStatement.executeUpdate();
                manager = new Manager();

                resultSet = insertPreparedStatement.getGeneratedKeys();
                Integer managerId = null;

                if (resultSet.next()) {
                    managerId = resultSet.getInt(1);
                    manager.setManagerId(managerId);
                    manager.setFullname(fullname);
                    manager.setGender(gender);
                    manager.setContactno(contactno);
                    manager.setEmailId(emailid);
                    manager.setPassword(password);

                    if (rowAffected == 1) {
                        return manager;
                    }
                }

            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return manager;
    }

    @Override
    public String managerLogin(Integer managerId, String password) {
        String sqlQuery = "select managerId, password from manager where managerId=? and password=?";

        try {
            connection = JdbcUtil.getJdbcConnection();

            if (connection != null) {
                retrievePreparedStatement = connection.prepareStatement(sqlQuery);
            }
            if (retrievePreparedStatement != null) {
                retrievePreparedStatement.setInt(1, managerId);
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
    public Employee registerEmployee(String fullname, String gender, String contactno, String emailid, String password) {
        String sqlInsertQuery = "insert into employee(`fullname`,`gender`,`contactno`,`emailid`,`password`) values (?,?,?,?,?)";
        Employee employee = null;

        try {
            //Estatlishing the Connection
            connection = JdbcUtil.getJdbcConnection();

            if (connection != null) {
                insertPreparedStatement = connection.prepareStatement(sqlInsertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            }
            if (insertPreparedStatement != null) {
                insertPreparedStatement.setString(1, fullname);
                insertPreparedStatement.setString(2, gender);
                insertPreparedStatement.setString(3, contactno);
                insertPreparedStatement.setString(4, emailid);
                insertPreparedStatement.setString(5, password);

                int rowAffected = insertPreparedStatement.executeUpdate();
                employee = new Employee();

                resultSet = insertPreparedStatement.getGeneratedKeys();
                Integer employeeId = null;

                if (resultSet.next()) {
                    employeeId = resultSet.getInt(1);
                    employee.setEmployeeId(employeeId);
                    employee.setFullname(fullname);
                    employee.setGender(gender);
                    employee.setContactno(contactno);
                    employee.setEmailId(emailid);
                    employee.setPassword(password);

                    if (rowAffected == 1) {
                        return employee;
                    }
                }

            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return employee;
    }

    @Override
    public Employee searchEmployee(Integer employeeId) {
        System.out.println("Employee id is : " + employeeId);
        ResultSet resultSet1 = null;
        String sqlSelectQuery = "select employeeId, fullname, gender, contactno, emailid, password from employee where employeeId=?";
        Employee employee = null;

        try {
            connection = JdbcUtil.getJdbcConnection();
            System.out.println("Connection Established...");

            if (connection != null) {
                retrievePreparedStatement = connection.prepareStatement(sqlSelectQuery);
                System.out.println("Prepared Statement Object is created...");
            }
            if (retrievePreparedStatement != null) {
                retrievePreparedStatement.setInt(1, employeeId);

                resultSet1 = retrievePreparedStatement.executeQuery();
                System.out.println("ResultSet Object is created...");
            }
            if (resultSet1 != null) {
                if (resultSet1.next()) {
                    employee = new Employee();
                    System.out.println("Employee Object is created...");

                    employee.setEmployeeId(resultSet1.getInt(1));
                    employee.setFullname(resultSet1.getString(2));
                    employee.setGender(resultSet1.getString(3));
                    employee.setContactno(resultSet1.getString(4));
                    employee.setEmailId(resultSet1.getString(5));
                    employee.setPassword(resultSet1.getString(6));

                    System.out.println("Employee Object is : " + employee);
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
        return employee;
    }

    @Override
    public String deleteEmployee(Integer employeeId) {
        String sqlDeleteQuery = "delete from employee where employeeId=?";

        try {
            connection = JdbcUtil.getJdbcConnection();

            if (connection != null) {
                insertPreparedStatement = connection.prepareStatement(sqlDeleteQuery);
            }
            if (insertPreparedStatement != null) {
                insertPreparedStatement.setInt(1, employeeId);

                int rowAffected = insertPreparedStatement.executeUpdate();

                if (rowAffected == 1) {
                    status = "success";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public String updateEmployee(Employee employee) {
        
        String sqlUpdateQuery = "UPDATE employee SET fullname=?, gender=?, contactno=?, emailid=?, password=? WHERE employeeId=?";

        try {
            connection = JdbcUtil.getJdbcConnection();

            if (connection != null) {
                insertPreparedStatement = connection.prepareStatement(sqlUpdateQuery);
            }
            if (insertPreparedStatement != null) {
                insertPreparedStatement.setString(1, employee.getFullname());
                insertPreparedStatement.setString(2, employee.getGender());
                insertPreparedStatement.setString(3, employee.getContactno());
                insertPreparedStatement.setString(4, employee.getEmailId());
                insertPreparedStatement.setString(5, employee.getPassword());
                insertPreparedStatement.setInt(6, employee.getEmployeeId());

                int rowAffected = insertPreparedStatement.executeUpdate();
                System.out.println("Row Affected : " + rowAffected);

                if (rowAffected == 1) {
                    return "success";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Status After Sending: " + status);
        return status;
    }

    @Override
    public List<Employee> showAllEmployees() {
        List<Employee> employeeList = null;
        Employee employee = null;

        try {
            connection = JdbcUtil.getJdbcConnection();

            if (connection != null) {
                String sqlSelectQuery = "select employeeId, fullname, gender, contactno, emailid, password from employee";
                retrievePreparedStatement = connection.prepareStatement(sqlSelectQuery);
            }
            if (retrievePreparedStatement != null) {
                resultSet = retrievePreparedStatement.executeQuery();
            }
            if (resultSet != null) {
                employeeList = new ArrayList<>();
                while (resultSet.next()) {
                    employee = new Employee();
                    employee.setEmployeeId(resultSet.getInt(1));
                    employee.setFullname(resultSet.getString(2));
                    employee.setGender(resultSet.getString(3));
                    employee.setContactno(resultSet.getString(4));
                    employee.setEmailId(resultSet.getString(5));
                    employee.setPassword(resultSet.getString(6));

                    employeeList.add(employee);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
