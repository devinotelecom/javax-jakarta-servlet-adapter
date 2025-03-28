package com.devinotele.servletbridge;

import javax.servlet.http.Cookie;
import java.util.Objects;

public class CookieAdapter extends Cookie {

	private final jakarta.servlet.http.Cookie jakartaCookie;

	public CookieAdapter(String name, String value, jakarta.servlet.http.Cookie jakartaCookie) {
		super(name, value);
		this.jakartaCookie = jakartaCookie;
	}

	@Override
	public void setComment(String purpose) {
		//jakartaCookie.setComment(purpose); deprecated
	}

	@Override
	public String getComment() {
		//return jakartaCookie.getComment(); deprecated
		return null;
	}

	@Override
	public void setDomain(String domain) {
		jakartaCookie.setDomain(domain);
	}

	@Override
	public String getDomain() {
		return jakartaCookie.getDomain();
	}

	@Override
	public void setMaxAge(int expiry) {
		jakartaCookie.setMaxAge(expiry);
	}

	@Override
	public int getMaxAge() {
		return jakartaCookie.getMaxAge();
	}

	@Override
	public void setPath(String uri) {
		jakartaCookie.setPath(uri);
	}

	@Override
	public String getPath() {
		return jakartaCookie.getPath();
	}

	@Override
	public void setSecure(boolean flag) {
		jakartaCookie.setSecure(flag);
	}

	@Override
	public boolean getSecure() {
		return jakartaCookie.getSecure();
	}

	@Override
	public String getName() {
		return jakartaCookie.getName();
	}

	@Override
	public void setValue(String newValue) {
		jakartaCookie.setValue(newValue);
	}

	@Override
	public String getValue() {
		return jakartaCookie.getValue();
	}

	@Override
	public int getVersion() {
		//return jakartaCookie.getVersion(); deprecated
		return 0;
	}

	@Override
	public void setVersion(int v) {
		//jakartaCookie.setVersion(v); deprecated
	}

	@Override
	public void setHttpOnly(boolean httpOnly) {
		jakartaCookie.setHttpOnly(httpOnly);
	}

	@Override
	public boolean isHttpOnly() {
		return jakartaCookie.isHttpOnly();
	}

	@Override
	public int hashCode() {
		return jakartaCookie.hashCode();
	}

	@Override
	public String toString() {
		return jakartaCookie.toString();
	}
}
