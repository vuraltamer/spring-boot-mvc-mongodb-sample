package com.usermanagement.controller.dto;

import com.usermanagement.controller.dto.base.BaseDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PersonDto extends BaseDto {

    private String username;

    @Size(min = 2, message = "Invalid firstname!")
    private String firstname;

    @Size(min = 2, message = "Invalid lastname!")
    private String lastname;

    @Size(min = 10, max = 10, message = "Phone number must be 10 characters!")
    @Pattern(regexp = "[0-9]+", message = "Phone number must contain digit.")
    private String msisdn;

    @NotNull
    @Email(message = "Email should be valid!")
    private String email;

    public PersonDto() {
    }

    public PersonDto(String username, String firstname, String lastname, String msisdn, String email) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.msisdn = msisdn;
        this.email = email;
    }

    public PersonDto(String identifier, String username, String firstname, String lastname, String msisdn, String email) {
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

