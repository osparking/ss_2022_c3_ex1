package space.bum.config.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthFilter extends OncePerRequestFilter {

	private final CustomAuthFilter customAuthFilter;
	
	@Override
	protected void doFilterInternal(
			HttpServletRequest request,
			HttpServletResponse response, 
			FilterChain filterChain) throws ServletException, IOException {
		
		// 1. 아직 인증안된 authen 객체 생성
		// 2. authen 객체를 manager 에 위임
		// 3. manager로 부터 authen 돌려받다
		// 4. 인증 성공 때, 요청을 다음 필터로 인계		
		
		filterChain.doFilter(request, response); // 인증 작동 때만
	}
}
