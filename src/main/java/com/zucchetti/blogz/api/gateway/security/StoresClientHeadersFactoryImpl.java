package com.zucchetti.blogz.api.gateway.security;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;

public class StoresClientHeadersFactoryImpl implements ClientHeadersFactory {

	@Inject
	JsonWebToken jwt;
	
    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> inbound, MultivaluedMap<String, String> outbound) {

    	MultivaluedMap<String, String> headers = new MultivaluedHashMap<>();
    	if (jwt.getRawToken() != null)
    	{
    		headers.add("Authorization", "Bearer " + jwt.getRawToken());
    	}
    	
//    	String inboundToken = inbound.getFirst("Authorization");
        
        return headers;
    }
}
