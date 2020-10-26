package com.zucchetti.blogz.api.gateway;

import java.util.Collections;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.zucchetti.blogz.api.gateway.models.Blog;
import com.zucchetti.blogz.api.gateway.resources.ApiGatewayResource;
import com.zucchetti.blogz.api.gateway.services.BlogService;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.quarkus.test.security.TestSecurity;
import io.restassured.RestAssured;

@QuarkusTest
@TestHTTPEndpoint(ApiGatewayResource.class)
class ApiGatewayResourceTest
{
	@InjectMock
	@RestClient
	BlogService blogService;
	
	@BeforeEach
    public void setup()
	{
		Mockito.when(blogService.findBlogs()).thenReturn(Collections.emptyList());
    }
	
	@Test
	@TestSecurity(authorizationEnabled = false)
	void findBlogs()
	{
		final List<Blog> fromGateway = RestAssured.when().get("/findBlogs").<List<Blog>>as(List.class);
		Assertions.assertIterableEquals(Collections.emptyList(), fromGateway);
	}
	
	@Test
	@Disabled
	void saveBlog()
	{
//		Mockito.when(blogService.findBlogs()).thenReturn(Collections.emptyList());
//		
//		final List<Blog> fromService = blogService.findBlogs();
//		final List<Blog> fromGateway = RestAssured.when().get("/findBlogs").<List<Blog>>as(List.class);
//		Assertions.assertIterableEquals(fromService, fromGateway);
	}
}