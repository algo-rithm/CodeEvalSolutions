package javacode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RemoveCharacters {
	
	public static void main(String[] args){
		RemoveCharacters removeCharacters = new RemoveCharacters();
		removeCharacters.readFile("C:\\testfiles\\removecharacters.txt");
	}
	
	private void readFile(String file){
        try(Stream<String> rounds = Files.lines(Paths.get(file))){
            printResults(rounds);
        } catch (IOException ioe){ioe.printStackTrace();}
    }
	
	private void printResults(Stream<String> elements){
		elements.map(Challenge::new).forEach((a) -> System.out.println(a.result));
    }
	
	private class Challenge{
		
		String a,b;
		String[] scrubbersRaw;
		String result;
		
		public Challenge(String challenge){
			
			String[] splittedString = challenge.split("[,]");
			a = splittedString[0];
			b = splittedString[1];
						
			scrubbersRaw = b.split("(?!^)");
			
			IntStream scrubbeeStream = a.chars();
	
			Stream<Integer>s = scrubbeeStream.filter(this::predScrub).mapToObj(Integer::new);
			result = s.map(this::doConvert).reduce("", (a,b) -> (a+b));
		}
		
		private boolean predScrub(int scrubbee){
			int flag = 0;
			for(int i = 0; i < scrubbersRaw.length; i++){
				if(Character.toString((char)scrubbee).equals(scrubbersRaw[i])){flag = 1;}}
			if(flag == 1 && scrubbee != 32) {return false;} 
			else return true;
		}
		
		private String doConvert(int code){
			String z = Character.toString((char)code);
			return z;
		}
	}
}


