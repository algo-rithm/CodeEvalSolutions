package javacode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class DeltaTime {

	public static void main(String[] args){
		DeltaTime dTB = new DeltaTime();
		dTB.convert("C:\\testfiles\\deltatime.txt");
	}
	
	private void convert(String file){
		
		try(Stream<String> rounds = Files.lines(Paths.get(file))){
			rounds.forEach(TimeChallenge::new);
		}catch(IOException ioe){ioe.printStackTrace();}
	
	}
	
	private class TimeChallenge{
	
		public TimeChallenge(String challenge){
			Pattern pattern = Pattern.compile("[ ]");
			String[] timeSplit = pattern.split(challenge);
			String time1raw = timeSplit[0];
			String time2raw = timeSplit[1];
			Pattern microSplit = Pattern.compile("[:]");
			String[] time1s = microSplit.split(time1raw);
			String[] time2s = microSplit.split(time2raw);
			Stream<Integer> timeOne = Arrays.stream(time1s).map(Integer::parseInt);
			Stream<Integer> timeTwo = Arrays.stream(time2s).map(Integer::parseInt);
		
			getTime( timeOne.toArray(Integer[]::new), timeTwo.toArray(Integer[]::new));
		}
	}
	
	private void getTime(Integer[] timeOne, Integer[] timeTwo){
		LocalTime lt = LocalTime.of(timeOne[0], timeOne[1], timeOne[2]);
		LocalTime lt2 = LocalTime.of(timeTwo[0], timeTwo[1], timeTwo[2]);
		Duration ns = Duration.between(lt, lt2).abs();
		long millis = ns.toMillis();
		int hour = (int) ((millis / (1000*60*60)) % 24);
		int min = (int) ((millis / (1000*60)) % 60);
		int sec = (int) (millis / 1000) % 60;
		System.out.printf("%02d:%02d:%02d\n", hour, min, sec);
	}
	
}