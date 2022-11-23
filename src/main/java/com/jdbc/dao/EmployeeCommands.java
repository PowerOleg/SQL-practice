package com.jdbc.dao;

import com.jdbc.pojo.Employee;
import com.mysql.fabric.xmlrpc.base.Data;

import java.util.List;

public interface EmployeeCommands {
    void insert(Employee employee);
    List<Employee> get (Data work_start_date, int salary);
    void remove(Employee employee);
}
