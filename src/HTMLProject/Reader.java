package HTMLProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Reader extends FileMaker {
	private static BufferedReader b;

	public static BufferedReader getReader()
	{
		return b;
	}

	public static void makeFileReader(String url) throws IOException {
		while (true)
			try {
				FileReader fr = new FileReader(url);
				b = new BufferedReader(fr);
				break;
			} catch (FileNotFoundException e) {
				makeFile(url);
			}
	}

	public static void closeReader() throws IOException {
		b.close();
	}
}