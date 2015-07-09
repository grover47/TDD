package HTMLProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.jsoup.Jsoup;

public class SaveURL {

	private static String link;
	public static String html;
	private URL url;
	private static ArrayList<String> s;
	private static HashMap<ArrayList<String>, ArrayList<String>> findAndReplace;
	private static ArrayList<String> resourceList;
	
	static{
		s = new ArrayList<String>();
	}
	
	

	/**
	 * getHTMLURL takes a string u, which is a URL, parses the html and stores
	 * it in member field String html
	 * @param u String of URL 
	 */
	public static void getHTMLURL(String u) {
		link = u;
		try {
			html = Jsoup.connect(u).get().html();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * readHTMLFile calls getHTMLURL then prints the URL string to the index.html document
	 * @param u String of URL
	 * @param close boolean of whether to close the PrintWriter or not after operation.  True = yes, False = no
	 * @throws IOException
	 */
	public static void readHTMLFile(String u) throws IOException {
		getHTMLURL(u);
		Reader.startPrinter();
		Reader.getPrinter().print(html);
		Reader.closePrinter();
	}

	/**
	 * getOtherFiles reads HTML doc and searches for lines that begin with "<link" or "<script" It collects those lines and stores them
	 * in the member field ArrayList<String> s
	 * @throws IOException
	 */
	public static void getLinkFiles() throws IOException {
		String line = "";
		String check = "<link";
		String check2 = "<script";
		String[] strings = html.split("\n");
		System.out.println(strings);
		for (String string : strings) {
			if(s.contains(check) || s.contains(check))
			s.add(string);
		}
		System.out.println(Arrays.asList(s));
		
	}
	
	public static void getResourceList() throws IOException
	{
		getLinkFiles();
		char[] al;
		String[] parts; 
		for (String string : s) {
			if(string.contains("href"))
			{
				parts = string.split(" ");
				for (String str : parts) {
					if(str.length() > 6)
					{
					if(str.substring(str.length() - 5, str.length() - 2) == ".css")
					{
						resourceList.add(str);
					}
					}
				}
				
			}
		}
		System.out.println(resourceList);
	}
	
	
	
	
	public void getURL(String s) {
		try {
			url = new URL(s);
		} catch (MalformedURLException e) {
			System.out.println("Invalid URL");
		}
	}

	

	/*public void readURL(String s) {
		getURL(s);
		try {
			in = new BufferedReader(new InputStreamReader(url.openStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

}
