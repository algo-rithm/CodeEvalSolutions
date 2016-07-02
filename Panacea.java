package javacode;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


//change to Main
public class Panacea {

	public static void main(String... args){
		Panacea panacea = new Panacea();
		panacea.startVirusTests("C://testfiles//panacea.txt");
	}
	
	public Panacea(){
		
	}
	
	private void startVirusTests(String testFile){
		try(Stream<String> rounds = Files.lines(Paths.get(testFile))){
			printResults(rounds);
		} catch (IOException ioe){ioe.printStackTrace();}
	}
	
	private void printResults(Stream<String> elements){
		Stream<MachineRun> results = elements.map(MachineRun::new);
		results.forEach((a) -> System.out.println(a.toString()));
	}
	
	private class MachineRun{
		
		private String result;
		
		public MachineRun(String element){
			
			String hexSide, binarySide;
			Pattern splitSides = Pattern.compile("[|]");
			String[] split = splitSides.split(element);
			hexSide = split[0];
			binarySide = split[1];
			
			Pattern splitValues = Pattern.compile("[ ]");
			
			String[] hex = splitValues.split(hexSide);
			String[] bin = splitValues.split(binarySide);
			ArrayList<String> hex2 = new ArrayList<>(Arrays.asList(hex));
			ArrayList<String> bin2 = new ArrayList<>(Arrays.asList(bin));
			bin2.remove(0);
			
			Stream<Integer> hexStream = hex2.stream().map(this::getHex);
			Stream<Integer> binStream = bin2.stream().map(this::getBin);
			
			int hexResult = hexStream.reduce(1, (a,b) -> (a + b));
			int binResult = binStream.reduce(1, (a,b) -> (a + b));
			
			setResult(hexResult, binResult);
			
		}
		
		private Integer getHex(String hex){
			int num = Integer.parseInt(hex, 16);
			return num;
		}
		
		private Integer getBin(String bin){
			int num = Integer.parseInt(bin, 2);
			return num;
		}
		
		private void setResult(int h, int b){
			if(h <= b) result = "True";
			else result = "False";
			}
		
		@Override
		public String toString(){
			return result;
		
		}
	
		
	}
}
