package HTMLProject;

import java.io.IOException;
import java.util.ArrayList;

public abstract class SearchURL {
	private static ArrayList<String> wordList;
	static {
		wordList = new ArrayList<String>();
		try {
			Reader.makeFile("wordlist.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Reader.makeFileReader("wordlist.txt");
			String s;
			while((s = Reader.getReader().readLine()) != null)
			{
				if(!s.trim().equals(""))
				wordList.add(s);
			}
			System.out.println(wordList);
			System.out.println();
			Reader.closeReader();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String finalHTML;


	public static String searchURL(String s) throws IOException {
		String placeholder = s;
		for (String string : wordList) {
			if(placeholder.contains(string))
				placeholder = replaceString(placeholder, string);
		}
		finalHTML = placeholder;
		return placeholder;
	}

	private static String replaceString(String placeholder, String strToReplace) {
		String replacedHTML = placeholder;
		String substring = placeholder;
		String replaced = "<font style='BACKGROUND-COLOR: yellow'>" + strToReplace + "</font>";
		while (substring.contains(strToReplace)) {
			replacedHTML = replacedHTML.replace(strToReplace, replaced);
			substring = replacedHTML.replace(replaced, " ");
		}
		return replacedHTML;
	}
	
	public static String getHTML()
	{
		return finalHTML;
	}
	

}
