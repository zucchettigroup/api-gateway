package com.zucchetti.blogz.api.gateway.resources;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import com.zucchetti.blogz.api.gateway.models.Blog;
import com.zucchetti.blogz.api.gateway.models.Keys;
import com.zucchetti.blogz.api.gateway.models.User;
import com.zucchetti.blogz.api.gateway.services.BlogService;
import com.zucchetti.blogz.api.gateway.services.UserService;

@Path("/api-gateway")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApiGatewayResource
{
//	@Context
//	private HttpHeaders headers;
	
	@Inject
	@RestClient
	UserService userService;
	
	@Inject
	@RestClient
	BlogService blogService;
	
	@RolesAllowed({ "User", "Admin" })
	@PUT
	@Path("/updateUser")
    public User updateUser(User user) 
    {
		return userService.updateUser(user);
    }
	
	@RolesAllowed({ "User", "Admin" })
	@DELETE
	@Path("/deleteUser")
    public void deleteUser(User user) 
    {
		userService.deleteUser(user);
    }
	
	@RolesAllowed({ "Admin" })
	@GET
	@Path("/generateKeys")
    public Keys generateKey() 
    {
		return userService.generateKey();
    }
	
	@RolesAllowed({ "User", "Admin" })
	@POST
	@Path("/createBlog")
    public Blog createBlog(Blog blog) 
    {
		return blogService.createBlog(blog);
    }
	
	@RolesAllowed({ "User", "Admin" })
	@PUT
	@Path("/updateBlog")
    public Blog updateBlog(Blog blog)
    {
		return blogService.updateBlog(blog);
    }
	
	@RolesAllowed({ "User", "Admin" })
	@DELETE
	@Path("/deleteBlog")
    public Blog deleteBlog(Blog blog) 
    {
		
		return blogService.deleteBlog(blog);
    }
	
	@RolesAllowed({ "User", "Admin" })
	@GET
	@Path("/findBlogs")
    public List<Blog> findBlogs() 
    {
		return blogService.findBlogs();
    }
	
//	@PermitAll
//	@GET
//	@Path("/dockerTest")
//    public Blog dockerTest() 
//    {
//		return blogService.dockerTest();
//    }
}