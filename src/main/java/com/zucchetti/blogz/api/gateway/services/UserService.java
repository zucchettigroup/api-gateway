package com.zucchetti.blogz.api.gateway.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.zucchetti.blogz.api.gateway.models.User;

@Path("/users")
@RegisterRestClient(configKey = "users-service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserService
{
	@Path("/createUser")
	@POST
	User createUser(User user);
	
	@Path("/findUser")
	@POST
	User findUser(User user);
	
	@Path("/updateUser")
	@PUT
	User updateUser(User user);
	
	@Path("/deleteUser")
	@DELETE
	User deleteUser(User user);
	
}