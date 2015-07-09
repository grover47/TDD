package HTMLProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Reader {
	private String link;
	private URL url;
	private BufferedReader in;
	private String html;
	public static PrintWriter p;
	private static BufferedReader b;

	public static boolean makeFile(String s) throws IOException {
		String fileString = s;
		Path filePath = Paths.get(fileString);
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
			return true;
		}
		return false;
	}
	
	public static PrintWriter getPrinter()
	{
		return p;
	}
	
	public static BufferedReader getReader()
	{
		return b;
	}

	public static void makeFileReader() throws IOException {
		while (true)
			try {
				FileReader fr = new FileReader("index.html");
				b = new BufferedReader(fr);
				break;
			} catch (FileNotFoundException e) {
				makeFile("index.html");
			}
	}

	public static void startPrinter() {
		FileWriter w = null;
		boolean ret = false;
		try {
			w = new FileWriter("index.html", ret);
		} catch (IOException e) {
			try {
				makeFile("index.html");
				ret = true;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		BufferedWriter bw = new BufferedWriter(w);
		p = new PrintWriter(bw);
	}

	public static void closeReader() throws IOException {
		b.close();
	}

	public static void closePrinter() throws IOException {
		p.close();
	}

	public void storeURL() {
		String inputLine;
		try {
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	/*public void addFile(String s, boolean close) {
		String web = link;
		web += link;
		writeHTMLFile(web, false);
	}*/

	/*public void addFiles() {
		for (String string : s) {
			addFile(string, false);
		}
		p.close();
	}*/

}