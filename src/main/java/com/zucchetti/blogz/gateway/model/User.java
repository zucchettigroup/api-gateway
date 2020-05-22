package com.zucchetti.blogz.gateway.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class User
{
	public @NotNull String id;
	public @NotEmpty String username;
	public @Email(regexp = "username@email.com") String email;

	public User()	{}
	public User(String id, String username, String email)
	{
		this.id = id;
		this.username = username;
		this.email = email;
	}	
}
