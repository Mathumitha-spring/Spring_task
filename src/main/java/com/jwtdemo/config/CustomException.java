package com.jwtdemo.config;

public class CustomException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException()
	{
		super("my own exception");
	}
}
