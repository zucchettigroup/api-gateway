package com.zucchetti.blogz.users.security;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

import com.nimbusds.jose.jwk.RSAKey;

public class KeyManager {
	
	private static String EncryptionKeyPaths = "../src/main/resources/META-INF/resources/JWK_ENCRYPTION_KEY_PAIR.txt";
	private static String SignatureKeyPaths = "../src/main/resources/META-INF/resources/JWK_SIGNATURE_KEY_PAIR.txt";
			
	public static RSAKey GetEncryptionKey() throws IOException, ParseException
	{
		return GetKey(EncryptionKeyPaths);
	}

	public static RSAKey GetSignatureKey() throws IOException, ParseException
	{
		return GetKey(SignatureKeyPaths);
	}
	
	private static RSAKey GetKey(String KeyPaths) throws IOException, ParseException
	{
		String jwkJson = new String(Files.readAllBytes(Paths.get(KeyPaths)));
		RSAKey jwk = RSAKey.parse(jwkJson);
		return jwk;
	}
}
