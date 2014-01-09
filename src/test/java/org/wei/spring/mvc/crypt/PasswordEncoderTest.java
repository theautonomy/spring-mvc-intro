package org.wei.spring.mvc.crypt;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class PasswordEncoderTest {
	
	@Test
	public void testEncodePassword() {
		StandardPasswordEncoder spe = new StandardPasswordEncoder();
		String encodedPassword = spe.encode("admin");
		System.out.println(encodedPassword);
	}
	
	@Test
	public void testDecodePassword() {
		StandardPasswordEncoder spe = new StandardPasswordEncoder();
		boolean match = spe.matches("user", "dac4476217b42b410e8d85d111d08ebb1826af426f74b4dd324fea9b1da734961111faa018b14c51");
		Assert.assertTrue(match);
	}

}
