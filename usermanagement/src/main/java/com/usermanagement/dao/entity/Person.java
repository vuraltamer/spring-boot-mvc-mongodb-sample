package com.usermanagement.dao.entity;

import com.usermanagement.dao.entity.base.BaseEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Person")
public class Person extends BaseEntity {

    @Indexed
    private String username;

    private String firstname;

    private String lastname;

    private String msisdn;

    private String email;

    public Person() {
    }

    public Person(String username, String firstname, String lastname, String msisdn, String email) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.msisdn = msisdn;
        this.email = email;
    }

    public Person(String identifier, String username, String firstname, String lastname, String msisdn, String email) {
        this.identifier = identifier;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.msisdn = msisdn;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
