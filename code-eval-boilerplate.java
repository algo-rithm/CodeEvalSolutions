
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

public class Solution {
	
	private int numOfLines;
	
	public Solution(String file, int num){
	numOfLines = num;
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	readfile(file);
	}

    public static void main(String[] args) {
        Solution solution = new Solution("C:\\testfiles\\commonchild.txt",1);
    }
    

    private void readfile(String testCase){
    	if(numOfLines == 0){
    		try(Stream<String> lines = Files.lines(Paths.get(testCase))){
    			printResults(lines);
    		}}
    	else {
    		try(Stream<String> line = Files.lines(Paths.get(testCase))){
    			printResults(line);            
    		}}
    }
            
    private void printResults(Stream<String> streamOfFileLines){ 
    	if(numOfLines == 1){
    		Optional<String> op = streamOfFileLines.findAny();
            op.ifPresent((z) -> {
            	//int i = 0;
            	//int n = Integer.parseInt(z);
            	//while( i < 10) System.out.println(n +" x "+ (++i) +" = "+ n*i);
            });
    	} else{
    		
    		//streamOfFileLines.skip(1).map((m)->m.split("(?!^)")).flatMap(this::getAnswer).forEach(System.out::println);
    	}
    }
    
    private Stream<?> getAnswer(String line){
    	Stream<String> answer = Stream.of(line);
    	return answer;
    	
 /*   	StringBuilder even = new StringBuilder();
    	StringBuilder odd = new StringBuilder();
    	for(int i=0; i<wordArray.length; i++){
    		if(i % 2 == 0) even.append(wordArray[i]);
    		else odd.append(wordArray[i]);
    	}
    	
    	String finalWord = even.toString() + " " + odd.toString();
    	
    	Stream<String> wordStream = Stream.of(finalWord);
    	return wordStream;
*/    	
    }
}
