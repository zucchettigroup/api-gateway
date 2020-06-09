package com.zucchetti.blogz.gateway.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class User
{
	public @NotNull int id;
	public @NotEmpty String username;
	public @Email String email;

	public User()	{}
	public User(int id, String username, String email)
	{
		this.id = id;
		this.username = username;
		this.email = email;
	}	
}
