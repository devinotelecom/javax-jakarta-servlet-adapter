package com.devinotele.servletbridge;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletSecurityElement;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ServletRegistrationDynamicAdapter implements ServletRegistration.Dynamic {
	private final jakarta.servlet.ServletRegistration.Dynamic servletRegistration;

	public ServletRegistrationDynamicAdapter(jakarta.servlet.ServletRegistration.Dynamic servletRegistration) {
		this.servletRegistration = servletRegistration;
	}

	@Override
	public void setLoadOnStartup(int loadOnStartup) {

	}

	@Override
	public Set<String> setServletSecurity(ServletSecurityElement constraint) {
		return Set.of();
	}

	@Override
	public void setMultipartConfig(MultipartConfigElement multipartConfig) {

	}

	@Override
	public void setRunAsRole(String roleName) {

	}

	@Override
	public void setAsyncSupported(boolean isAsyncSupported) {

	}

	@Override
	public Set<String> addMapping(String... urlPatterns) {
		return Set.of();
	}

	@Override
	public Collection<String> getMappings() {
		return List.of();
	}

	@Override
	public String getRunAsRole() {
		return "";
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public String getClassName() {
		return "";
	}

	@Override
	public boolean setInitParameter(String name, String value) {
		return false;
	}

	@Override
	public String getInitParameter(String name) {
		return "";
	}

	@Override
	public Set<String> setInitParameters(Map<String, String> initParameters) {
		return Set.of();
	}

	@Override
	public Map<String, String> getInitParameters() {
		return Map.of();
	}
}
