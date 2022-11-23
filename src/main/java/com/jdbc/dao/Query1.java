package com.jdbc.dao;

import com.jdbc.pojo.Department;
import com.jdbc.pojo.Employee;
import com.mysql.fabric.xmlrpc.base.Data;

import static com.jdbc.Configs.*;
import static com.jdbc.Const.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

    }

    @Override
    public List<Employee> get(Data work_start_date, int salary) {
        return null;
    }

    @Override
    public void remove(Employee employee) {

    }

    @Override
    public void insertDepartment(Department department) {
        
    }
}
