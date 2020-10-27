package com.zucchetti.blogz.api.gateway.security;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

import com.nimbusds.jose.jwk.RSAKey;

public class KeyManager {
	
	private static final String ENCRYPTION_KEY_PATHS = "../src/main/resources/META-INF/key/JWK_ENCRYPTION_KEY_PAIR.txt";
	private static final String SIGNATURE_KEY_PATHS = "../src/main/resources/META-INF/key/JWK_SIGNATURE_KEY_PAIR.txt";
	
	public static RSAKey getEncryptionKey() throws IOException, ParseException
	{
		return getKey(ENCRYPTION_KEY_PATHS);
	}

	public static RSAKey getSignatureKey() throws IOException, ParseException
	{
		return getKey(SIGNATURE_KEY_PATHS);
	}
	
	private static RSAKey getKey(String KeyPaths) throws IOException, ParseException
	{
		String jwkJson = new String(Files.readAllBytes(Paths.get(KeyPaths)));
		RSAKey jwk = RSAKey.parse(jwkJson);
		return jwk;
	}
}
