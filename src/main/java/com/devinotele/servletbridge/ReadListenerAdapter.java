package com.devinotele.servletbridge;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.servlet.ReadListener;
import java.io.IOException;

@RequiredArgsConstructor
public class ReadListenerAdapter implements jakarta.servlet.ReadListener, javax.servlet.ReadListener {
	@Getter private final ReadListener readListener;

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

	@Override
	public String toString () {
		return readListener.toString();
	}
}