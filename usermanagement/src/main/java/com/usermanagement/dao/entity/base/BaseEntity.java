package com.usermanagement.dao.entity.base;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity implements Serializable {

    @Id
    protected String identifier;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    protected Date createDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    protected Date updateDate;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}