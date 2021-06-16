package com.spring.exception;

public class NotFoundException extends Exception {
	public NotFoundException() {
		super("아이디가 존재하지 않습니다.");
	}
}
