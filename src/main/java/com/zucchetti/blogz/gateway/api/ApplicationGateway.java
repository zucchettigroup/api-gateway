package com.zucchetti.blogz.gateway.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.zucchetti.blogz.gateway.UserService;
import com.zucchetti.blogz.gateway.model.User;

@Path("/api-gateway")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApplicationGateway
{
	@Inject
	@RestClient
	UserService userService;
	
	@Path("/user")
	@POST
	public Response saveUser(User user)
	{
		return userService.createUser(user);
	}
}
