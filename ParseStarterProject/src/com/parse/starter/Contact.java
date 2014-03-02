package com.parse.starter;

public class Contact {
	private User[] contacts;
	private final long userId;
	public Contact(long userId) {
		this.userId = userId;
	}
}
