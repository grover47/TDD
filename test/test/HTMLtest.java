/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import HTMLProject.SaveURL;
import HTMLProject.SearchURL;
import HTMLProject.Writer;

/**
 * @author Kim
 *
 */
public class HTMLtest {
	@Test
	public void testIfInputURLOutPutWebpage() { 
		assertNotEquals(null, SaveURL.getHTMLURL("http://archive.freep.com/article/20131103/COL06/311020016/Tom-Walsh-Dan-Gilbert-JDetroit-Venture-partners"));
	}
	
	@Test
	public void testIfFindsBigotInString()
	{
		String c ="";
		try {
			c = SearchURL.searchURL("Bigot");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ss = "<font style='BACKGROUND-COLOR: yellow'>Bigot</font>";
		assertTrue(c.contains(ss));
	}
	
	@Test
	public void testIfFindsBigotAndCower()
	{
		String c ="";
		try {
			c = SearchURL.searchURL("Bigot waffles Cower");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ss = "<font style='BACKGROUND-COLOR: yellow'>Cower</font>";
		assertTrue(c.contains(ss));
	}
	
	@Test
	public void testIfFileExists() throws IOException
	{
		assertFalse(Writer.makeFile("testing.txt"));
	}
	
	
	
	
	
	
}


