package com.devinotele.servletbridge;

import javax.servlet.ReadListener;
import java.io.IOException;

public class ReadListenerAdapter implements jakarta.servlet.ReadListener {

	private final ReadListener readListener;

	public ReadListenerAdapter(ReadListener readListener) {
		this.readListener = readListener;
	}

	@Override
	public void onDataAvailable() throws IOException {
		readListener.onDataAvailable();
	}

	@Override
	public void onAllDataRead() throws IOException {
		readListener.onAllDataRead();
	}

	@Override
	public void onError(Throwable t) {
		readListener.onError(t);
	}
}