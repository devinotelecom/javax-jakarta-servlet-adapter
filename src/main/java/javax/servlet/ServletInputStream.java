package javax.servlet;

import com.devinotele.servletbridge.IJakarta;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * Provides an input stream for reading binary data from a client request, including an efficient <code>readLine</code>
 * method for reading data one line at a time. With some protocols, such as HTTP POST and PUT, a
 * <code>ServletInputStream</code> object can be used to read data sent from the client.
 *
 * <p>
 * A <code>ServletInputStream</code> object is normally retrieved via the {@link ServletRequest#getInputStream} method.
 *
 *
 * <p>
 * This is an abstract class that a servlet container implements. Subclasses of this class must implement the
 * <code>java.io.InputStream.read()</code> method.
 *
 *
 * @author Various
 *
 * @see ServletRequest
 *
 */
@RequiredArgsConstructor
public class ServletInputStream extends jakarta.servlet.ServletInputStream implements IJakarta<jakarta.servlet.ServletInputStream> {
	private final jakarta.servlet.ServletInputStream jakartaInputStream;

	@Override public jakarta.servlet.ServletInputStream unwrap (){ return jakartaInputStream; }

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
	public void setReadListener (jakarta.servlet.ReadListener readListener) {
		jakartaInputStream.setReadListener(readListener);
	}
}