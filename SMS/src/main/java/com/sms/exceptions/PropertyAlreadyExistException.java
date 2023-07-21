package com.sms.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private String message;

	public PropertyAlreadyExistException(String message) {
		super(message);
		this.message = message;
	}
	
	
}
