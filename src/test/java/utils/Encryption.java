package utils;

import java.util.Base64;

public class Encryption {
	public static void encrypt(String data)
	{
		byte[] encodeBytes = Base64.getEncoder().encode(data.getBytes());
		System.out.println(new String(encodeBytes));
		
	}
	public static String decrypt_data(String encrypt_data)
	{
		byte[] decodeBytes = Base64.getDecoder().decode(encrypt_data.getBytes());
		String res = new String(decodeBytes);
		return res;
	}
public static void main(String[] args) {
	//encrypt("Online_User");
String data=decrypt_data("T25saW5lX1VzZXI=");
System.out.println("the decryptes data is "+data);
	
	
}
}

