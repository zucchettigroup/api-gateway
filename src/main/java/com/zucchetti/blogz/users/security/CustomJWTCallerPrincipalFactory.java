package com.zucchetti.blogz.users.security;

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
import com.nimbusds.jose.JOSEException;
import io.smallrye.jwt.auth.principal.DefaultJWTCallerPrincipal;
import io.smallrye.jwt.auth.principal.JWTCallerPrincipalFactory;
import io.smallrye.jwt.auth.principal.ParseException;

@ApplicationScoped
@Alternative
@Priority(1)
public class CustomJWTCallerPrincipalFactory extends JWTCallerPrincipalFactory {

    @Override
    public JWTCallerPrincipal parse(String token, JWTAuthContextInfo authContextInfo) throws ParseException {
	try {			      	
            JwtConsumer jwtConsumer = new JwtConsumerBuilder()
            		.setExpectedIssuer("https://quarkus.io/using-jwt-rbac")
                    .setRequireExpirationTime() // the JWT must have an expiration time
                    //.setMaxFutureValidityInMinutes(300) // but the  expiration time can't be too crazy
//	                    .setRequireSubject() // the JWT must have a subject claim
//	                    .setExpectedAudience("receiver") // to whom the JWT is intended for
                    .setDecryptionKey(KeyManager.GetEncryptionKey().toPrivateKey()) // decrypt with the receiver's private key
                    .setVerificationKey(KeyManager.GetSignatureKey().toPublicKey()) // verify the signature with the sender's public key
//	                    .setJwsAlgorithmConstraints(jwsAlgConstraints) // limits the acceptable signature algorithm(s)
//	                    .setJweAlgorithmConstraints(jweAlgConstraints) // limits acceptable encryption key establishment algorithm(s)
//	                    .setJweContentEncryptionAlgorithmConstraints(jweEncConstraints) // limits acceptable content encryption algorithm(s)
                    .build();    		            
      
                //  Validate the JWT and process it to the Claims
                JwtClaims jwtClaims = jwtConsumer.processToClaims(token);
                return new DefaultJWTCallerPrincipal(jwtClaims);
    	}   
        catch (InvalidJwtException | IOException | JOSEException | java.text.ParseException e)
        {
        	throw new ParseException(e.getMessage());
        }	
    }
}