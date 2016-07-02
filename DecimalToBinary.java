package javacode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DecimalToBinary {

	public static void main(String[] args){
		DecimalToBinary dTB = new DecimalToBinary();
		dTB.convert("C:\\testfiles\\decimaltobinary.txt");
	}
	
	private void convert(String file){
		
		try(Stream<String> rounds = Files.lines(Paths.get(file))){
			rounds.map(Integer::parseInt).forEach((a) -> System.out.println(Integer.toBinaryString(a)));
		}catch(IOException ioe){ioe.printStackTrace();}
	}
	
}
