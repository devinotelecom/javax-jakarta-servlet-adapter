package com.devinotele.servletbridge;

import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;

/**
 @see HttpServletAdapter */
class HttpServletAdapterTest {
	@Test
	void _getLastModified () {
		HttpServlet javax = new HttpServlet() {
			@Override
			protected long getLastModified (HttpServletRequest req) {
				return 42;
			}
		};

		HttpServletAdapter jakarta = new HttpServletAdapter(javax);

		assertEquals(42, jakarta.getLastModified(null));
	}
}