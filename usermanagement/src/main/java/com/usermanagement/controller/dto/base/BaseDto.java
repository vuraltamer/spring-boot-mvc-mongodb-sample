package com.usermanagement.controller.dto.base;

public abstract class BaseDto {

	protected String identifier;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
}