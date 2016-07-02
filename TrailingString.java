package javacode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TrailingString {
	
	public static void main(String[] args){
		TrailingString trailingString = new TrailingString();
		trailingString.readFile("C:\\testfiles\\trailingstring.txt");
	}
	
	private void readFile(String file){
        try(Stream<String> rounds = Files.lines(Paths.get(file))){
            printResults(rounds);
        } catch (IOException ioe){ioe.printStackTrace();}
    }
	
	private void printResults(Stream<String> elements){
		elements.map(Challenge::new).forEach(this::doCompare);;
    }
	
	private void doCompare(Challenge c){
			if(c.a.endsWith(c.b)){
				System.out.println("1");
			} else System.out.println("0");
		}
	
	private class Challenge{
		
		String a,b;
		
		public Challenge(String challenge){
			Pattern splitString = Pattern.compile("[,]");
			String[] splittedString = splitString.split(challenge);
			
			a = splittedString[0];
			System.out.println(a);
			b = splittedString[1];
			System.out.println(b);
		}
		
		
		
	}

}
