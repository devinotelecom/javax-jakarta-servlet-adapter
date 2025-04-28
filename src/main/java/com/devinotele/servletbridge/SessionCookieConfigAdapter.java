package com.devinotele.servletbridge;

import lombok.RequiredArgsConstructor;

import javax.servlet.SessionCookieConfig;
import java.util.Map;

@RequiredArgsConstructor
public class SessionCookieConfigAdapter implements SessionCookieConfig, IJakarta<jakarta.servlet.SessionCookieConfig> {
	private final jakarta.servlet.SessionCookieConfig sessionCookieConfig;

	@Override public jakarta.servlet.SessionCookieConfig unwrap (){ return sessionCookieConfig; }

	@Override
	public void setName(String name) {
		sessionCookieConfig.setName(name);
	}

	@Override
	public String getName() {
		return sessionCookieConfig.getName();
	}

	@Override
	public void setDomain(String domain) {
		sessionCookieConfig.setDomain(domain);
	}

	@Override
	public String getDomain() {
		return sessionCookieConfig.getDomain();
	}

	@Override
	public void setPath(String path) {
		sessionCookieConfig.setPath(path);
	}

	@Override
	public String getPath() {
		return sessionCookieConfig.getPath();
	}

	@Override
	public void setHttpOnly(boolean httpOnly) {
		sessionCookieConfig.setHttpOnly(httpOnly);
	}

	@Override
	public boolean isHttpOnly() {
		return sessionCookieConfig.isHttpOnly();
	}

	@Override
	public void setSecure(boolean secure) {
		sessionCookieConfig.setSecure(secure);
	}

	@Override
	public boolean isSecure() {
		return sessionCookieConfig.isSecure();
	}

	@Override
	public void setMaxAge(int maxAge) {
		sessionCookieConfig.setMaxAge(maxAge);
	}

	@Override
	public int getMaxAge() {
		return sessionCookieConfig.getMaxAge();
	}

	@Override
	public void setAttribute (String name, String value) {
		sessionCookieConfig.setAttribute(name, value);
	}

	@Override
	public String getAttribute (String name) {
		return sessionCookieConfig.getAttribute(name);
	}

	@Override
	public Map<String,String> getAttributes () {
		return sessionCookieConfig.getAttributes();
	}

	@Override  @Deprecated(since = "Servlet 6.0", forRemoval = true)
	public void setComment (String comment) {
	}

	@Override  @Deprecated(since = "Servlet 6.0", forRemoval = true)
	public String getComment (){ return ""; }
}