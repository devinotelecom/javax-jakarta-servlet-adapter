package com.devinotele.servletbridge;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import java.util.Enumeration;

/**
 We are inside Spring 3/jakarta environment (only jakarta is real): there is NO real javax.
 @see javax.servlet.ServletConfig
 @see jakarta.servlet.ServletConfig
 */
@RequiredArgsConstructor
public class ServletConfigAdapter implements ServletConfig {
	@Getter private final jakarta.servlet.ServletConfig jakartaServletConfig;

	public static javax.servlet.ServletConfig javax (jakarta.servlet.ServletConfig jakartaServletConfig) {
		return jakartaServletConfig instanceof javax.servlet.ServletConfig javax ? javax
				: new ServletConfigAdapter(jakartaServletConfig);
	}

	public jakarta.servlet.ServletConfig jakarta (javax.servlet.ServletConfig javaxServletConfig) {
		return javaxServletConfig instanceof jakarta.servlet.ServletConfig jakarta ? jakarta
				: ((ServletConfigAdapter) javaxServletConfig).getJakartaServletConfig();
	}

	@Override public String getServletName (){ return jakartaServletConfig.getServletName(); }

	@Override
	public ServletContext getServletContext () {
		return new ServletContextAdapter(jakartaServletConfig.getServletContext());
	}

	@Override public String getInitParameter (String name){ return jakartaServletConfig.getInitParameter(name); }

	@Override public Enumeration<String> getInitParameterNames (){ return jakartaServletConfig.getInitParameterNames(); }
}