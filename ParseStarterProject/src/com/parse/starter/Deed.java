package com.parse.starter;

public class Deed {
	private User source, dest;
	public String description;
	private static long deedId = 0;
	public Deed(User src, User dest, String description) {
		this.source = src;
		this.dest = dest;
		this.description = description;
		deedId++;
	}
	
	public User getSource() {
		return this.source;
	}
	
	public User getDestination() {
		return this.dest;
	}
	
	public String getDescription() {
		return this.description;
	}
	

}
