package com.zucchetti.blogz.api.gateway.security;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;

public class StoresClientHeadersFactoryImpl implements ClientHeadersFactory {

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> inbound, MultivaluedMap<String, String> outbound) {

    	//String inboundToken = inbound.getFirst("Authorization");

    	String inboundToken = inbound.getFirst("Cookie");
    	
        MultivaluedMap<String, String> headers = new MultivaluedHashMap<>();
//        headers.add("Authorization", inboundToken);
        headers.add("Cookie", inboundToken);
        return headers;
    }
}
