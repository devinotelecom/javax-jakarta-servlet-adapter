package com.devinotele.servletbridge;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 Wrap legacy javax.servlet.http.HttpServlet as new jakarta.servlet.http.HttpServlet
 We are inside boot3/jakarta environment and have to look outside like jakarta
*/
@RequiredArgsConstructor
public class HttpServletAdapter extends jakarta.servlet.http.HttpServlet implements IJakarta<javax.servlet.http.HttpServlet> {
	private final javax.servlet.http.HttpServlet legacyServlet;

	@Override public HttpServlet unwrap () { return legacyServlet; }

	@Override
	protected void service (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			var javaxRequest = new HttpServletRequestAdapter(req);
			var javaxResponse = new HttpServletResponseAdapter(resp);
			legacyServlet.service(javaxRequest, javaxResponse);
		} catch (javax.servlet.ServletException e){
			throw new jakarta.servlet.ServletException(e);
		}
	}

	@Override
	public void init (jakarta.servlet.ServletConfig config) throws ServletException {
		try {
			var javaxConfig = ServletConfigAdapter.javax(config);
			legacyServlet.init(javaxConfig);
			//should be called after legacy servlet config initialized
			super.init(config);
		} catch (javax.servlet.ServletException e){
			throw new jakarta.servlet.ServletException(e);
		}
	}

	@Override public String toString (){ return legacyServlet.toString(); }

	@Override
	public void destroy () {
		super.destroy();
		legacyServlet.destroy();
	}

	@Override
	public void init () throws ServletException {
		super.init();
		// legacyServlet.init() must be called by its init(ServletConfig)
	}

	@Override
	protected long getLastModified (HttpServletRequest req) {
		//return legacyServlet.getLastModified(new JakartaToJavaxRequestAdapter(req));
		try {
			return (Long) GET_LAST_MODIFIED.invoke(legacyServlet, new HttpServletRequestAdapter(req));
		} catch (Throwable e){
			return super.getLastModified(req);
		}
	}

	static final Method GET_LAST_MODIFIED;
	static {
		Method m = null;
		try {
			m = javax.servlet.http.HttpServlet.class.getDeclaredMethod("getLastModified", javax.servlet.http.HttpServletRequest.class);
			m.setAccessible(true);
		} catch (Throwable e){// NoSuchMethodException
			e.printStackTrace();
		}
		GET_LAST_MODIFIED = m;
	}
}