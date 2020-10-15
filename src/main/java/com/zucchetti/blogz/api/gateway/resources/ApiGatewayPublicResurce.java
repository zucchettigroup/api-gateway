package com.zucchetti.blogz.api.gateway.resources;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.zucchetti.blogz.api.gateway.models.User;
import com.zucchetti.blogz.api.gateway.services.UserService;

@Path("/public/api-gateway")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApiGatewayPublicResurce {
	
	@Inject
	@RestClient
	UserService userService;
	
	@PermitAll
	@Path("/createUser")
	@POST
	public User createUser(User user)
	{
		return userService.createUser(user);
	}
	
	@PermitAll
	@Path("/findUser")
	@POST
	public Response findUser(User user)
	{
		return userService.findUser(user);
	}
}
