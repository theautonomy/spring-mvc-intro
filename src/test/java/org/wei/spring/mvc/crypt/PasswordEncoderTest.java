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
		boolean match = spe.matches("admin", "7b3ae3887a075b9cc63e0bce13aa50618859c91ec60cd772121b18ad3b59197d8b8f13732d92c360");
		Assert.assertTrue(match);
	}

}
