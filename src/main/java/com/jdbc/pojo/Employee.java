package com.jdbc.pojo;

import com.mysql.fabric.xmlrpc.base.Data;

public class Employee {
    private int id;
    private int department_id;
    private Data work_start_date;
    private String name;
    private int salary;

    public Employee() {}

    public Employee(int id, int department_id, Data work_start_date, String name, int salary) {
        this.id = id;
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

    public Data getWork_start_date() {
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

    public void setWork_start_date(Data work_start_date) {
        this.work_start_date = work_start_date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
