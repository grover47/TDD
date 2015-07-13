package HTMLProject;

import java.io.IOException;
import java.net.SocketTimeoutException;

import org.jsoup.Jsoup;

public class SaveURL {
	private static String url;
	/**
	 * getHTMLURL takes a string u, which is a URL, parses the html and stores
	 * it and returns the html
	 * @param u String of URL 
	 */
	public static String getHTMLURL(String u) {
		String html = null;
		try {
			html = Jsoup.connect(u).get().html();
		} 
		catch(SocketTimeoutException e)
		{
			System.out.println("Oops, there was an error");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return html;
	}

	/**
	 * readHTMLFile calls getHTMLURL then prints the URL string to the index.html document
	 * @param u String of URL
	 * @throws IOException
	 */
	public static void readHTMLFile(String u) throws IOException {
		Writer.startPrinter();
		Writer.getPrinter().print(url = getHTMLURL(u));
		Writer.closePrinter();
	}
	
	public static String getHTMLAsString() throws IOException {
		return url;
	}
	
	

}
