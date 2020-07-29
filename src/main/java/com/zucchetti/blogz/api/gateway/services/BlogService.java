package com.zucchetti.blogz.api.gateway.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.zucchetti.blogz.api.gateway.models.Blog;

@Path("/users")
@RegisterRestClient(configKey = "users-service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BlogService
{
	@Path("/createBlog")
	@POST
	Blog createBlog(Blog blog);
	
//	@Path("/updateBlog")
//	@POST
//	User updateUser(User user);
//	
//	@Path("/deleteBlog")
//	@POST
//	User deleteUser(User user);
	
}