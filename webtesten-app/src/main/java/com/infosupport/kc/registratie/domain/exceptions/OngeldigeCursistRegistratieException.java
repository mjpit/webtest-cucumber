package com.infosupport.kc.registratie.domain.exceptions;

public class OngeldigeCursistRegistratieException extends Exception {
	private static final long serialVersionUID = 1L;

	public OngeldigeCursistRegistratieException() {
	}

	public OngeldigeCursistRegistratieException(String message) {
		super(message);
	}

	public OngeldigeCursistRegistratieException(String message, Throwable cause) {
		super(message, cause);
	}

	public OngeldigeCursistRegistratieException(Throwable cause) {
		super(cause);
	}
}
