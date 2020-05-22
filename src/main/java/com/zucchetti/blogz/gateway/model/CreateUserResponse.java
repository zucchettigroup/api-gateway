package com.zucchetti.blogz.gateway.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class CreateUserResponse
{
	public List<String> errors = new ArrayList<>();
	public Optional<Integer> userId = Optional.empty();
	
	public static final CreateUserResponse createFromResponse(Response r)
	{
		final CreateUserResponse b = new CreateUserResponse();
		if(r.getStatus() == Status.NOT_ACCEPTABLE.getStatusCode())
		{
			b.errors = r.readEntity(List.class);
		}
		else if(r.getStatus() == Status.OK.getStatusCode())
		{
			b.userId = Optional.of(r.readEntity(int.class));
		}
		return b;
	}
}
