


import java.util.regex.*;
import java.util.Scanner;
import java.io.*;  
public class CleanJson {
	public static void main(String[] args) throws Exception{
		String content = new Scanner(new File(args[0])).useDelimiter("\\Z").next();
		System.out.println("Cleaning...");
		content = newTextFile(content);
		try(PrintWriter out = new PrintWriter("newTweets.txt")){
		    out.println(content);
		}
		System.out.println("Done!");
	}
	
	public static String newTextFile(String textFile){
		String newText = new String();
		String pattern = "(\\{\"id\":\".*\",\"body\":\")(.*)(\",\"object\":)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(textFile);
		while (m.find()) {
			newText = newText + m.group(2) + "\n";
		}
		return newText;
	}
}
