package com.tercilio.os.api.service.exceptions;

import java.io.Serializable;

public class DataIntegratyViolationException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public DataIntegratyViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegratyViolationException(String message) {
		super(message);
	}
}