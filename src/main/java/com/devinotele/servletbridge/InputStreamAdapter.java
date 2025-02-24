package com.devinotele.servletbridge;

import javax.servlet.ServletInputStream;
import java.io.IOException;

public class InputStreamAdapter extends ServletInputStream {

	private final jakarta.servlet.ServletInputStream jakartaInputStream;

	public InputStreamAdapter(jakarta.servlet.ServletInputStream jakartaInputStream) {
		this.jakartaInputStream = jakartaInputStream;
	}

	@Override
	public int read() throws IOException {
		return jakartaInputStream.read();
	}

	@Override
	public boolean isFinished() {
		return jakartaInputStream.isFinished();
	}

	@Override
	public boolean isReady() {
		return jakartaInputStream.isReady();
	}

	@Override
	public void setReadListener(javax.servlet.ReadListener readListener) {
		jakartaInputStream.setReadListener(new ReadListenerAdapter(readListener));
	}
}