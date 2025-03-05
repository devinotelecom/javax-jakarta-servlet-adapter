package com.devinotele.servletbridge;

import javax.servlet.SessionCookieConfig;

public class SessionCookieConfigAdapter implements SessionCookieConfig {

	private final jakarta.servlet.SessionCookieConfig sessionCookieConfig;

	public SessionCookieConfigAdapter(jakarta.servlet.SessionCookieConfig sessionCookieConfig) {
		this.sessionCookieConfig = sessionCookieConfig;
	}


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
	public void setComment(String comment) {
//sessionCookieConfig.setComment(comment);deprecated
	}

	@Override
	public String getComment() {
		return null;// sessionCookieConfig.getComment();deprecated
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
}
