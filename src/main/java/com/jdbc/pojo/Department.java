package com.jdbc.pojo;

public class Department {
    private int id;
    private String name;
    private int lead_id;

    public Department() {}

    public Department(int id, String name, int lead_id) {
        this.id = id;
        this.name = name;
        this.lead_id = lead_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLead_id() {
        return lead_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLead_id(int lead_id) {
        this.lead_id = lead_id;
    }
}
