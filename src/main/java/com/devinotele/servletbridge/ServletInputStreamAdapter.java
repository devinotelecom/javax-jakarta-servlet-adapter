package com.devinotele.servletbridge;

import javax.servlet.ServletInputStream;

public class ServletInputStreamAdapter extends ServletInputStream {
	public ServletInputStreamAdapter (jakarta.servlet.ServletInputStream jakartaInputStream) {
		super(jakartaInputStream);
	}//new
}