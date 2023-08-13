package space.bum.config.security.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import space.bum.config.security.authen.CustomAuthen;

@Component
public class CustomAuthenProvider implements AuthenticationProvider {

	@Value("${our.very.secret.key}")
	private String key;
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		CustomAuthen ca = (CustomAuthen) authentication;
		String headerKey = ca.getKey();
		
		if (key.equals(headerKey)) {
			return new CustomAuthen(true, null);
		}
		
		throw new BadCredentialsException("키값 오류!");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return CustomAuthen.class.equals(authentication);
	}

}
