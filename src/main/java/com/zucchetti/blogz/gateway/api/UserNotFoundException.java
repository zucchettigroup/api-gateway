package com.zucchetti.blogz.gateway.api;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception
{
	public final String id;
	
	public UserNotFoundException(String id)
	{
		this.id = id;
	}
}
