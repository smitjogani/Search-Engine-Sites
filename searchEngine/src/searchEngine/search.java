package searchEngine;


import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class search {
	public static void main(String [] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.err.println("Enter You want to search :"); 
		String keyword = sc.nextLine();
		
		String url = "https://www.google.com/search" + "?q=" + keyword;
		Document doc = Jsoup.connect(url).get();
		String html = doc.html();
		Files.write(Paths.get("S://file.txt"),html.getBytes());
		Elements links = doc.select("cite"); 
		
		for(Element link: links)
		{
			String text = link.text();
			if(text.contains(">"))
			{
				text = text.replaceAll(">","/");
			}
			System.out.println(text+" ");
		}
		sc.close();
	}
}
