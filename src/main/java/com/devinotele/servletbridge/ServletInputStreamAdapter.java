package com.devinotele.servletbridge;

import lombok.RequiredArgsConstructor;

import javax.servlet.ServletInputStream;
import java.io.IOException;
import java.io.OutputStream;

@RequiredArgsConstructor
public class ServletInputStreamAdapter extends ServletInputStream implements IJakarta<jakarta.servlet.ServletInputStream> {
	private final jakarta.servlet.ServletInputStream jakartaInputStream;

	@Override
	public jakarta.servlet.ServletInputStream unwrap () {
		return jakartaInputStream;
	}

	@Override
	public int readLine (byte[] b, int off, int len) throws IOException {
		return jakartaInputStream.readLine(b, off, len);
	}

	@Override public int read () throws IOException { return jakartaInputStream.read(); }

	@Override public boolean isFinished () { return jakartaInputStream.isFinished(); }

	@Override public boolean isReady () { return jakartaInputStream.isReady(); }

	@Override public byte[] readAllBytes () throws IOException { return jakartaInputStream.readAllBytes(); }

	@Override public byte[] readNBytes (int len) throws IOException { return jakartaInputStream.readNBytes(len); }

	@Override
	public int readNBytes (byte[] b, int off, int len) throws IOException {
		return jakartaInputStream.readNBytes(b, off, len);
	}

	@Override public int read (byte[] b) throws IOException { return jakartaInputStream.read(b); }

	@Override
	public int read (byte[] b, int off, int len) throws IOException {
		return jakartaInputStream.read(b, off, len);
	}

	@Override public long skip (long n) throws IOException { return jakartaInputStream.skip(n); }

	@Override public void skipNBytes (long n) throws IOException { jakartaInputStream.skipNBytes(n); }

	@Override public int available () throws IOException { return jakartaInputStream.available(); }

	@Override public void close () throws IOException { jakartaInputStream.close(); }

	@Override public void mark (int readlimit) { jakartaInputStream.mark(readlimit); }

	@Override public void reset () throws IOException { jakartaInputStream.reset(); }

	@Override public boolean markSupported () { return jakartaInputStream.markSupported(); }

	@Override public long transferTo (OutputStream out) throws IOException { return jakartaInputStream.transferTo(out); }

	@Override
	public void setReadListener(javax.servlet.ReadListener readListener) {
		jakartaInputStream.setReadListener(new ReadListenerAdapter(readListener));
	}
}