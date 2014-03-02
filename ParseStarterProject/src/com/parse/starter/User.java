package com.parse.starter;

public class User {
	private String first, last;
	private final String userName;
	private static long userId = 0;
	private String password;
	private Contact contacts;
	private String email;
	
	public User(String first, String last, String email, String userName) {
		this.first = first;
		this.last = last;
		this.userName = userName;
		this.email = email;
		this.userId++;
	}
	
	public void setPassword(String pwd)
	{
			this.password = pwd;
	}
	
	public boolean isPasswordCorrect(String password)
	{
		return password.equals(this.password);
	}		
	
	public void setFirstName(String firstName)
	{
		this.first = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.last = lastName;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getFirstName()
	{
		return this.first;
	}
	
	public String getLastName()
	{
		return this.last;
	}
	
	public String getUserName()
	{
		return this.userName;
	}
	
	public Contact getContacts()
	{
		return this.contacts;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
}
