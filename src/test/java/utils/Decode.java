package utils;

import java.util.Base64;

public class Decode {
	public static String decrypt_data(String encrypt_data)
	{
		byte[] decodeBytes = Base64.getDecoder().decode(encrypt_data.getBytes());
		String res = new String(decodeBytes);
		return res;
	}

}
