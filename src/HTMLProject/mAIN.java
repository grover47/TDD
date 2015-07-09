package HTMLProject;

import java.io.IOException;

public class mAIN {

	public static void main(String[] args) throws IOException {
		
		SaveURL.readHTMLFile("http://archive.freep.com/article/20131103/COL06/311020016/Tom-Walsh-Dan-Gilbert-JDetroit-Venture-partners");
		System.out.println(SaveURL.html);
		SaveURL.getResourceList();
	}

}
