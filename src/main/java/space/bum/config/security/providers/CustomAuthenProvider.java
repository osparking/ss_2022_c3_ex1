package space.bum.config.security.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
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
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return CustomAuthen.class.equals(authentication);
	}

}
