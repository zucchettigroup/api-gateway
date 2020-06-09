package com.zucchetti.blogz.gateway;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.zucchetti.blogz.gateway.model.User;

@Path("/users")
@RegisterRestClient(configKey = "user-service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserService
{
	@Path("/user")
	@POST
	Response createUser(User user);
	
	@Path("/user/{id}")
	@DELETE
	Response deleteUser(@PathParam("id") int userId);
}
