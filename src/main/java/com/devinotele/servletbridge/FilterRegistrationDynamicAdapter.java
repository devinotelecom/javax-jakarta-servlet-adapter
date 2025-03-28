package com.devinotele.servletbridge;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.*;

public class FilterRegistrationDynamicAdapter implements FilterRegistration.Dynamic {

	private final  jakarta.servlet.FilterRegistration.Dynamic filterRegistration;

	public FilterRegistrationDynamicAdapter(jakarta.servlet.FilterRegistration.Dynamic filterRegistration) {
		this.filterRegistration = filterRegistration;
	}

	@Override
	public void addMappingForServletNames(EnumSet<DispatcherType> dispatcherTypes, boolean isMatchAfter, String... servletNames) {

	}

	@Override
	public Collection<String> getServletNameMappings() {
		return filterRegistration.getServletNameMappings();
	}

	@Override
	public void addMappingForUrlPatterns(EnumSet<DispatcherType> dispatcherTypes, boolean isMatchAfter, String... urlPatterns) {

	}

	@Override
	public Collection<String> getUrlPatternMappings() {
		return filterRegistration.getUrlPatternMappings();
	}

	@Override
	public void setAsyncSupported(boolean isAsyncSupported) {
filterRegistration.setAsyncSupported(isAsyncSupported);
	}

	@Override
	public String getName() {
		return filterRegistration.getName();
	}

	@Override
	public String getClassName() {
		return filterRegistration.getClassName();
	}

	@Override
	public boolean setInitParameter(String name, String value) {
		return filterRegistration.setInitParameter(name, value);
	}

	@Override
	public String getInitParameter(String name) {
		return filterRegistration.getInitParameter(name);
	}

	@Override
	public Set<String> setInitParameters(Map<String, String> initParameters) {
		return filterRegistration.setInitParameters(initParameters);
	}

	@Override
	public Map<String, String> getInitParameters() {
		return filterRegistration.getInitParameters();
	}
}
