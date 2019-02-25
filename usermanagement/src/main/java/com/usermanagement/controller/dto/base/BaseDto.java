package com.usermanagement.controller.dto.base;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public abstract class BaseDto {

	protected String identifier;

	protected Date createDate;

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