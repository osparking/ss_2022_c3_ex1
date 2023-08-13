package space.bum.config.security.managers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthenManager implements AuthenticationManager {

	private AuthenticationProvider provider;
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		if (provider.supports(authentication.getClass())) {
			return provider.authenticate(authentication);
		}
		throw new BadCredentialsException("인증 공급자 부재");
	}

}
