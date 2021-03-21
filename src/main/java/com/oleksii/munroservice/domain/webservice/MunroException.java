package com.oleksii.munroservice.domain.webservice;

public class MunroException extends RuntimeException {
	
	MunroException(String msg) {
		super("something went wrong while retrieving one of the Munro data" + msg);
	}

}
