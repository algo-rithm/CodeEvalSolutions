package javacode;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

public class StackImplementation {
	
	private int numOfLines;
	
	public StackImplementation(String file, int num){
	numOfLines = num;
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	readfile(file);
	}

    public static void main(String[] args) {
    	int linesOfInput = 0;
        StackImplementation solution = new StackImplementation("C:\\testfiles\\stackimplementation.txt", linesOfInput);
    }
    

    private void readfile(String testCase){
    	if(numOfLines == 0){
    		try(Stream<String> lines = Files.lines(Paths.get(testCase))){
    			printResults(lines);
    		} catch (IOException ioe){ioe.printStackTrace();}}
    	else {
    		try(Stream<String> line = Files.lines(Paths.get(testCase))){
    			printResults(line);            
    		} catch (IOException ioe){ioe.printStackTrace();}}
    }
            
    private void printResults(Stream<String> streamOfFileLines){ 
    	if(numOfLines == 1){
    		Optional<String> op = streamOfFileLines.findAny();
            op.ifPresent((z) -> {

            });
    	} else{
    		streamOfFileLines.map((m)->m.split("([ ])")).flatMap((a)->Stream.of(new Game(a))).forEach((a)-> a.toStringResults());

    	}
    }
    
    private class Game{
    	
    		private Stack<String> st = new Stack<>();
    	
    		public Game(String[] line){
    		int n = line.length;
        	
        	int index = 1;
        	for(int i = n; i > 0; i--){
        		if((index % 2) == 0){
        			index++;
        		} else{
        		st.push(line[i-1]);
        		index++;}
        		
        	}
    	}
    	
    	public void toStringResults(){
    		int n = st.size();
    		for(int i = 0; i < st.size() - 1; i++){
    			System.out.print(st.get(i) + " ");
    		}
    		System.out.print(st.get(n-1));
    		System.out.println();
    		
    	}
    }
    
 
    
   
}