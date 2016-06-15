package designPatterns_Decorator.io;

import java.io.*;

public class InputTest {

	public static void main(String[] args) throws IOException {
		int c;
		try {
			// Da bi se file citao treba ga staviti u root folder projekta odnosno u ovom slucaju u folder "C:\Java workspace\testsFor1Z0-808".
			InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
			while ((c = in.read()) >= 0) {
				System.out.print((char) c);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
