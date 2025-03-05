package com.devinotele.servletbridge;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import java.util.Enumeration;

public class ServletConfigAdapter implements ServletConfig {

	private final jakarta.servlet.ServletConfig jakartaServletConfig;

	public ServletConfigAdapter(jakarta.servlet.ServletConfig jakartaContext) {
		this.jakartaServletConfig = jakartaContext;
	}

	@Override
	public String getServletName() {
		return jakartaServletConfig.getServletName();
	}

	@Override
	public ServletContext getServletContext() {
		return new ServletContextAdapter(jakartaServletConfig.getServletContext());
	}

	@Override
	public String getInitParameter(String name) {
		return jakartaServletConfig.getInitParameter(name);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		return jakartaServletConfig.getInitParameterNames();
	}
}
