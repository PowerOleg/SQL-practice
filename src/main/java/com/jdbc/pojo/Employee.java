package com.jdbc.pojo;

import com.mysql.fabric.xmlrpc.base.Data;

import java.sql.Date;

public class Employee {
    private int id;
    private int department_id;
//    long now = System.currentTimeMillis();
//    Date sqlDate = new Date(now);
    private Date work_start_date;
    private String name;
    private int salary;

    public Employee() {}

    public Employee(int department_id, Date work_start_date, String name, int salary) {
//        this.id = id;
        this.department_id = department_id;
        this.work_start_date = work_start_date;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public Date getWork_start_date() {
        return work_start_date;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public void setWork_start_date(Date work_start_date) {
        this.work_start_date = work_start_date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
