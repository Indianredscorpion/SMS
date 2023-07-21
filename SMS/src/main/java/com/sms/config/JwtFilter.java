package com.sms.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException {
				
		final String authHeader = request.getHeader("Authorization");
		
		if("OPTIONS".equals(request.getMethod()))
		{
			response.setStatus(response.SC_OK);
			filterChain.doFilter(request, response);
		}
		else
		{
			if(authHeader==null || !authHeader.startsWith("Bearer "))
			{
				throw new ServletException("Invalid or Missing Authorization Header");
			}
			
			final String token = authHeader.substring(7);
			
			try
			{
				Claims claims = Jwts.parser().setSigningKey("secretkey")
						.parseClaimsJws(token).getBody();
				request.setAttribute("claims", claims);
			}
			catch(SignatureException e)
			{
				throw new ServletException("Invalid token");
			}
			
			filterChain.doFilter(request, response);
		}
		
	}

	

}
