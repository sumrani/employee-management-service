/**
 * 
 */
package com.publicissapient.employee.interceptor;

import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author sumrani
 *
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor{
	
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
	
	/*
	 * Enumeration<String>enumeration =request.getHeaderNames(); while
	 * (enumeration.hasMoreElements()) { String key = (String)
	 * enumeration.nextElement();
	 */
	//String value =  request.getHeader("allowAccess");
	if(request.getHeader("allowAccess")!=null && request.getHeader("allowAccess").equals("true")) {
		 System.out.println("outside if allowacess");
			return true;
	   
	}else {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		 System.out.println("allowacess");
	    return false; 
	}
	
	
}

}
