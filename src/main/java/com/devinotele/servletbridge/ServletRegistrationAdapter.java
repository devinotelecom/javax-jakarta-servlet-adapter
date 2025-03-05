package com.devinotele.servletbridge;

import javax.servlet.ServletRegistration;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ServletRegistrationAdapter implements ServletRegistration {

	private final jakarta.servlet.ServletRegistration servletRegistration;

	public ServletRegistrationAdapter(jakarta.servlet.ServletRegistration servletRegistration) {
		this.servletRegistration = servletRegistration;
	}

	@Override
	public Set<String> addMapping(String... urlPatterns) {
		return servletRegistration.addMapping(urlPatterns);
	}

	@Override
	public Collection<String> getMappings() {
		return servletRegistration.getMappings();
	}

	@Override
	public String getRunAsRole() {
		return servletRegistration.getRunAsRole();
	}

	@Override
	public String getName() {
		return servletRegistration.getName();
	}

	@Override
	public String getClassName() {
		return servletRegistration.getClassName();
	}

	@Override
	public boolean setInitParameter(String name, String value) {
		return servletRegistration.setInitParameter(name, value);
	}

	@Override
	public String getInitParameter(String name) {
		return servletRegistration.getInitParameter(name);
	}

	@Override
	public Set<String> setInitParameters(Map<String, String> initParameters) {
		return servletRegistration.setInitParameters(initParameters);
	}

	@Override
	public Map<String, String> getInitParameters() {
		return servletRegistration.getInitParameters();
	}
}
