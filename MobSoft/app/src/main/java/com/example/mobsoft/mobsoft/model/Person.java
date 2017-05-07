package com.example.mobsoft.mobsoft.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 10..
 */
@Table
public class Person extends SugarRecord {
    private String name;
    private String username;
    private String password;
    private String role;

    public Person() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    List<Invoice> getInvoices(){
        return Invoice.find(Invoice.class, "owner = ?", getId().toString());
    }
}