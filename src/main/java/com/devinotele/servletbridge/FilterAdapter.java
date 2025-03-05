package com.devinotele.servletbridge;

import javax.servlet.FilterRegistration;

import jakarta.servlet.*;
import java.io.IOException;

public class FilterAdapter implements Filter {

	private final javax.servlet.FilterRegistration filterRegistration;

	public FilterAdapter(FilterRegistration filterRegistration) {
		this.filterRegistration = filterRegistration;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

	}
}
