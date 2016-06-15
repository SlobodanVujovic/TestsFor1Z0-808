package refactoring_Chapter4;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileReaderTester {
	private FileReader _input;
	private FileReader _empty;

	private FileReader newEmptyFile() throws IOException {
		File empty = new File("empty.txt");
		FileOutputStream out = new FileOutputStream(empty);
		out.close();
		return new FileReader(empty);
	}

	@Before
	public void setUp() {
		try {
			_input = new FileReader("data.txt");
			_empty = newEmptyFile();
		} catch (IOException e) {
			throw new RuntimeException(e.toString());
		}
	}

	@After
	public void tearDown() {
		try {
			_input.close();
		} catch (IOException e) {
			throw new RuntimeException("Error on closing test file.");
		}
	}

	@Test
	public void testRead() throws IOException {
		char ch = '&';

		for (int i = 0; i < 4; i++)
			ch = (char) _input.read();

		assertEquals('d', ch);
	}

	@Test
	public void testReadAtEnd() throws IOException {
		int ch = -1234;

		for (int i = 0; i < 142; i++)
			ch = _input.read();

		assertEquals(-1, ch);
	}

	@Test
	public void testReadBoundaries() throws IOException {
		assertEquals("read first char", 'B', _input.read());

		int ch;

		for (int i = 1; i < 140; i++)
			ch = _input.read();

		assertEquals("read last char", '6', _input.read());
		assertEquals("read at end", -1, _input.read());
		assertEquals("readpast end", -1, _input.read());
	}

	@Test
	public void testEmptyRead() throws IOException {
		assertEquals(-1, _empty.read());
	}

	@Test
	public void testReadAfterClose() throws IOException {
		_input.close();
		try {
			_input.read();
			fail("no exception for read past end");
		} catch (IOException io) {
		}
	}
}
