package com.zucchetti.blogz.gateway.api;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException>
{
	@Override
	public Response toResponse(UserNotFoundException exception)
	{
		return Response.status(Status.NOT_FOUND.getStatusCode()).entity("Utente non trovato (" + exception.id + ')').type(MediaType.TEXT_PLAIN).build();
	}
}
