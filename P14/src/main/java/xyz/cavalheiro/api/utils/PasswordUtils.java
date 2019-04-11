package xyz.cavalheiro.api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

	public static String generateBCrypt(String pass) {
		if (pass == null) {
			return pass;
		}
		BCryptPasswordEncoder bCryptEnconder = new BCryptPasswordEncoder();
		return bCryptEnconder.encode(pass);
	}

	public static boolean validPass(String pass, String passEncoded) {
		BCryptPasswordEncoder bCryptEnconder = new BCryptPasswordEncoder();
		return bCryptEnconder.matches(pass, passEncoded);
	}

}
