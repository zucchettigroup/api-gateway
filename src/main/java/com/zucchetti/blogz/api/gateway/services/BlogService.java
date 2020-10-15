package com.zucchetti.blogz.api.gateway.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.zucchetti.blogz.api.gateway.models.Blog;
import com.zucchetti.blogz.api.gateway.security.StoresClientHeadersFactoryImpl;

@Path("/blog")
@RegisterRestClient(configKey = "blog-service")
@RegisterClientHeaders(value = StoresClientHeadersFactoryImpl.class)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BlogService
{
	@Path("/createBlog")
	@POST
	Blog createBlog(Blog blog);
	
	@Path("/updateBlog")
	@PUT
	Blog updateBlog(Blog blog);
	
	@Path("/deleteBlog")
	@DELETE
	Blog deleteBlog(Blog blog);
	
	@Path("/findBlogs")
	@GET
	List<Blog> findBlogs();
	
	@Path("/dockerTest")
	@GET
	Blog dockerTest();
}