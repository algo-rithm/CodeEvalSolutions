package javacode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FizzBizz {
    
    public static void main (String[] args){
    	FizzBizz fizzbizz = new FizzBizz();
        fizzbizz.playFizzBuzz("C://testfiles//fizzbizz.txt");
    }
    
    private void playFizzBuzz(String file){
        try(Stream<String> rounds = Files.lines(Paths.get(file))){
            printResults(rounds);
        } catch (IOException ioe){ioe.printStackTrace();}
    }
    
    private void printResults(Stream<String> elements){
        Stream<FizzBuzzGame> games = elements.map(FizzBuzzGame::new);
        games.forEach((a) -> System.out.println(a.toString()));
    }
    
    private class FizzBuzzGame {
        private int fizz, buzz, count;
        private String finalGame;
        
        public FizzBuzzGame(String rawGame){
            Pattern pattern = Pattern.compile("[ ,.!]");
            String[] gameParts = pattern.split(rawGame);
            fizz = Integer.parseInt(gameParts[0]);
            buzz = Integer.parseInt(gameParts[1]);
            count = Integer.parseInt(gameParts[2]);
            
            play(fizz, buzz, count);
        }
        
        private void play(int fizz, int buzz, int count){
            List<Integer> counter = new ArrayList<>();
            for(int i = 1; i <= count; i++) counter.add(i);
            Stream<String> playGames = counter.stream().map(this::fizzBuzzPass);
            finalGame = playGames.reduce("a", (a,b) -> a + " " + b);
        }
        
        private String fizzBuzzPass(Integer num){
            if (num % fizz == 0 && num % buzz == 0){
                  return "FB";
            } else if
               (num % fizz == 0){
                  return "F"; 
            } else if
               (num % buzz == 0){
                  return "B"; 
            } else return num.toString();
        }
        
        @Override
	    public String toString(){
		    return finalGame;
	    }
    }
}
