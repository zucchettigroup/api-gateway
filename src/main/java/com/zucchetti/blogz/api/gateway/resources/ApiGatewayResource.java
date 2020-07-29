package com.zucchetti.blogz.api.gateway.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.zucchetti.blogz.api.gateway.models.Blog;
import com.zucchetti.blogz.api.gateway.models.User;
import com.zucchetti.blogz.api.gateway.services.BlogService;
import com.zucchetti.blogz.api.gateway.services.UserService;

@Path("/api-gateway")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApiGatewayResource
{
	@Inject
	@RestClient
	UserService userService;
	
	@Inject
	@RestClient
	BlogService blogService;
	
	@Path("/createUser")
	@POST
	public User createUser(User user)
	{
		return userService.createUser(user);
	}
	
	@Path("/findUser")
	@POST
	public User findUser(User user)
	{
		return userService.findUser(user);
	}
	
	@POST
	@Path("/updateUser")
    public User updateUser(User user) 
    {
		return userService.updateUser(user);
    }
	
	@POST
	@Path("/deleteUser")
    public void deleteUser(User user) 
    {
		userService.deleteUser(user);
    }
	
	@POST
	@Path("/createBlog")
    public Blog createBlog(Blog blog) 
    {
		return blogService.createBlog(blog);
    }
}