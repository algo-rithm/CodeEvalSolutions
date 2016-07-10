package javacode;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

public class MersennePrime {
	
	private int numOfLines;
	
	public MersennePrime(String file, int num){
	numOfLines = num;
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	readfile(file);
	}

    public static void main(String[] args) {
    	int lines = 0;
        MersennePrime solution = new MersennePrime("C:\\testfiles\\mersenneprime.txt", lines);
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
            	//
            });
    	} else{
    		streamOfFileLines.map(Integer::parseInt).flatMap((z)->Stream.of(new Game(z))).forEach((z)->z.getAnswer());
    	}
    }
    
    private class Game{
    	Stack<Integer> st = new Stack<>();
    	public Game(int num){
    		
    		for(int n = 1; n <= num; n++){
    			if(isPrime(n))
    				
    				if((Math.pow(2,n)-1) <= num){
    				
    				if(isMersennePrime(n)){
    					int j = (int) getMersennePrime(n);
    					st.push(j);
    				}
    		
    				}
    	}}
    	
    	private void getAnswer(){
    		int n = st.size();
    		if(n != 0){
	    		for(int i = 0; i < st.size() - 1; i++){
	    			System.out.print(st.get(i) + ", ");
	    		}
	    		System.out.print(st.get(n-1));
	    		System.out.println();
    		}
    	}
    	
    	private boolean isPrime(double n){
    		if(n <= 1) return false;
    		else if(n <= 3) return true;
    		else if(n % 2 == 0 || n % 3 == 0) return false;
    		int i = 5;
    		while(i*i <= n){
    			if( n % i == 0 || n % (i + 2) == 0) return false;
    			i = i + 6;
    		}
    		
    		return true;
    	}
    	
    	private boolean isMersennePrime(double n){
    		if(isPrime(Math.pow(2, n) - 1 )) return true;
    		else return false;
    		
    		}
    	}
    
    	private double getMersennePrime(int n){
    		return ((Math.pow(2,n)) - 1);
    	}
  }

