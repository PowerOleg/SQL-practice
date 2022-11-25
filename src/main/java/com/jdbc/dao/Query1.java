package com.jdbc.dao;

import com.jdbc.pojo.Department;
import com.jdbc.pojo.Employee;
import com.mysql.fabric.xmlrpc.base.Data;

import static com.jdbc.Configs.*;
import static com.jdbc.Const.*;

import java.sql.*;
import java.util.List;

public class Query1 implements EmployeeCommands, DepartmentCommands {

    private Connection getConnection() {
        Connection dbConnection = null;
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("No connection");
            e.printStackTrace();
        }
        return dbConnection;
    }

    @Override
    public void insert(Employee employee) {
    Connection dbConnection = null;
    PreparedStatement preparedStatement = null;

        try {
            dbConnection = getConnection();
            String sqlQuery = null;
            if (employee.getDepartment_id() == null) {
                sqlQuery = "INSERT INTO employee (work_start_date, name, salary) VALUES (?,?,?)";
                preparedStatement = dbConnection.prepareStatement(sqlQuery);

                preparedStatement.setDate(1, employee.getWork_start_date());
                preparedStatement.setString(2, employee.getName());
                preparedStatement.setInt(3, employee.getSalary());
                preparedStatement.executeUpdate();
            } else {
                sqlQuery = "INSERT INTO employee (department_id, work_start_date, name, salary) VALUES (?,?,?,?)";
                preparedStatement = dbConnection.prepareStatement(sqlQuery);

                preparedStatement.setInt(1, employee.getDepartment_id());
                preparedStatement.setDate(2, employee.getWork_start_date());
                preparedStatement.setString(3, employee.getName());
                preparedStatement.setInt(4, employee.getSalary());
                preparedStatement.executeUpdate();
            }




        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Override
    public Employee/*List<Employee>*/ select(Date work_start_date, int salary) {
    Connection dbConnection = null;
    PreparedStatement preparedStatement = null;
    Employee employee = new Employee();

        try {
            /* ? */       String sqlQuery = "SELECT id, department_id, work_start_date," +
            " name, salary FROM employee WHERE work_start_date = ? AND salary = ?";
                dbConnection = getConnection();
                preparedStatement = dbConnection.prepareStatement(sqlQuery);
                preparedStatement.setDate(1, work_start_date);
                preparedStatement.setInt(2, salary);

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {                                  //
                employee.setId(resultSet.getInt("id"));
                employee.setDepartment_id(resultSet.getInt("department_id"));
                employee.setWork_start_date(resultSet.getDate("work_start_date"));
                employee.setName(resultSet.getString("name"));
                employee.setSalary(resultSet.getInt("salary"));
                }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                preparedStatement.close();
                } catch (SQLException e) {
                e.printStackTrace();
                }
                }
                if (dbConnection != null) {
                try {
                dbConnection.close();
                } catch (SQLException e) {
                e.printStackTrace();
                }
                }
                }

        return employee;                                                //
    }

    @Override
    public void remove(Employee employee) {

    }

    @Override
    public void insertDepartment(Department department) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        try {
            String sqlQuery = "INSERT INTO department (id, name, lead_id) VALUES (?,?,?)";
            dbConnection = getConnection();
            preparedStatement = dbConnection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, department.getId());
            preparedStatement.setString(2, department.getName());
            preparedStatement.setInt(3, department.getLead_id());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}










