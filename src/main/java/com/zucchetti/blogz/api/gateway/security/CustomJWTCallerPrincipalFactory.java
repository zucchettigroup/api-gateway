package com.zucchetti.blogz.api.gateway.security;

import io.smallrye.jwt.auth.principal.JWTAuthContextInfo;
import io.smallrye.jwt.auth.principal.JWTCallerPrincipal;

import java.io.IOException;
import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.jwt.consumer.JwtContext;

import com.nimbusds.jose.JOSEException;
import com.zucchetti.blogz.api.gateway.security.KeyManager;

import io.smallrye.jwt.auth.principal.DefaultJWTCallerPrincipal;
import io.smallrye.jwt.auth.principal.DefaultJWTTokenParser;
import io.smallrye.jwt.auth.principal.JWTCallerPrincipalFactory;
import io.smallrye.jwt.auth.principal.ParseException;

@ApplicationScoped
@Alternative
@Priority(1)
public class CustomJWTCallerPrincipalFactory extends JWTCallerPrincipalFactory {
	
	private final DefaultJWTTokenParser parser = new DefaultJWTTokenParser();

	@Override
    public JWTCallerPrincipal parse(String token, JWTAuthContextInfo authContextInfo) throws ParseException {
	try {			      	  		            
            authContextInfo.setPrivateDecryptionKey(KeyManager.getEncryptionKey().toPrivateKey());
            authContextInfo.setPublicVerificationKey(KeyManager.getSignatureKey().toPublicKey());
            JwtContext jwtContext = parser.parse(token, authContextInfo);
            String type = jwtContext.getJoseObjects().get(0).getHeader("typ");
            return new DefaultJWTCallerPrincipal(type, jwtContext.getJwtClaims());
    	}   
        catch (IOException | JOSEException | java.text.ParseException e)
        {
        	throw new ParseException(e.getMessage());
        }	
    }
}