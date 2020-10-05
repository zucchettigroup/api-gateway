package com.zucchetti.blogz.api.gateway.models;

public class Keys {
	private String signatureKey;
	private String encryptionKey;
	
	public Keys()	{}
	
	public Keys(String SignatureKey, String EncryptionKey)
	{
		this.setSignatureKey(SignatureKey);
		this.setEncryptionKey(EncryptionKey);
	}

	public String getSignatureKey() {
		return signatureKey;
	}

	public void setSignatureKey(String signatureKey) {
		this.signatureKey = signatureKey;
	}

	public String getEncryptionKey() {
		return encryptionKey;
	}

	public void setEncryptionKey(String encryptionKey) {
		this.encryptionKey = encryptionKey;
	}
	
	
}
