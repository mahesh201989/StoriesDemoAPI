package com.stories.demo.config;

public class MoxtraSingleSignOnProcessException extends Exception{

	private static final long serialVersionUID = 1L;

	MoxtraSingleSignOnProcessException(String msg, Exception e){
		super(msg);
	}
}
