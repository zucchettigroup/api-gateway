package com.zucchetti.blogz.gateway.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

public class CreateUserResponse
{
	public List<String> errors = new ArrayList<>();
	public Optional<Integer> userId = Optional.empty();
	
	public static final CreateUserResponse createFromResponse(Response r)
	{
		return r.readEntity(CreateUserResponse.class);
	}
}
