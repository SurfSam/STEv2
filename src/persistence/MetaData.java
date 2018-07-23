package persistence;

import Enums.Operation;
import Enums.EncryptionType;

import java.io.UnsupportedEncodingException;

import Enums.EncryptionMode;
import Enums.PaddingType;
import Enums.KeyLength;
import Enums.HashFunction;

/**
 * Class to provide a transfer object to the STE.
 * 
 * Used to save all the information necessary to encrypt, persist data and be able to
 * read and use for decryption again.
 * 
 * @author sam
 */
public final class MetaData {

	private Operation		operation;
	private EncryptionType 	encryption;
	private EncryptionMode 	mode;
	private PaddingType		padding;
	private KeyLength		keyLength;
	private HashFunction	hashFunction;
	String			hashValue = "";
	private byte[]			IV = new byte[] {};
	
	// Symmetric | Private key | Password generated key
	private byte[]			key = new byte[] {};

	
	// PBE
	String			password = "";
	private byte[]			salt = new byte[] {};
	
	private byte[]			text = new byte[] {};

	/** Empty constructor */
	MetaData() {}
	
	/**
	 * Singleton pattern to increase security?
	 */
	public static MetaData getInstance() {
		return new MetaData();
	}
	
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
	
	public byte[] getSalt() {
		return salt;
	}
	
	public void setText(byte[] text) {
		this.text = text;
	}
	
	public byte[] getText() {
		return text;
	}
	
	public void setKey(byte[] key) {
		this.key = key;
	}
	
	public byte[] getKey() {
		return this.key;
	}
	
	public Operation getOperation() {
		return operation;
	}
	
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setHashValue(String value) {
		this.hashValue = value;
	}
	
	public String getHashValue() {
		return this.hashValue;
	}
	
	public void setHashFunction(HashFunction function) {
		this.hashFunction = function;
	}
	
	public HashFunction getHashFunction() {
		return this.hashFunction;
	}
	
	public void setIV(byte[] value) {
		this.IV = value;
	}
	
	public byte[] getIV() {
		return this.IV;
	}
	
	public void setEncryptionType(EncryptionType encryption) {
		this.encryption = encryption;
	}
	
	public EncryptionType getEncryptionType() {
		return this.encryption;
	}
	
	public void setEncryptionMode(EncryptionMode mode) {
		this.mode = mode;
	}
	
	public EncryptionMode getEncryptionMode() {
		return this.mode;
	}
	
	public void setPaddingType(PaddingType padding) {
		this.padding = padding;
	}
	
	public PaddingType getPaddingType() {
		return this.padding;
	}
	
	public void setKeyLength(KeyLength keyLength) {
		this.keyLength = keyLength;
	}
	
	public KeyLength getKeyLength() {
		return this.keyLength;
	}
	
	public String toString() {
		
		String temp = "";
		
		if(this.operation != null)
			temp += "Operation: " + this.operation + "\n";
		if(this.encryption != null)
			temp += "Encryption Method: " + this.encryption + "\n";
		if(this.mode != null)
			temp += "Encryption Mode: " + this.mode + "\n";
		if(this.padding != null)
			temp += "Padding: " + this.padding + "\n";
		if(this.keyLength != null)
			temp += "Key length: " + this.keyLength + "\n";
		if(this.hashFunction != null)
			temp += "Hash function: " + this.hashFunction;
		
		
		return temp;
	}
}
