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
            String sqlQuery = "INSERT INTO employee (department_id, work_start_date, name, salary) VALUES (?,?,?,?)";
            dbConnection = getConnection();
            preparedStatement = dbConnection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, employee.getDepartment_id());
            preparedStatement.setDate(2, employee.getWork_start_date());
            preparedStatement.setString(3, employee.getName());
            preparedStatement.setInt(4, employee.getSalary());
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

    @Override
    public List<Employee> get(Date work_start_date, int salary) {


        return null;
    }

    @Override
    public void remove(Employee employee) {

    }

    @Override
    public void insertDepartment(Department department) {
        
    }
}
    SELECT id, department_id, work_start_date, name, salary FROM employee WHERE work_start_date = ?, salary = ?