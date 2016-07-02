package javacode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;

public class FileSize {

	  public static void main (String[] args){
	    	FileSize fileSize = new FileSize();
	        fileSize.getFileSize("C://testfiles//panacea.txt");
	    }
	  
	  private void getFileSize(String file){
		  Path path = Paths.get(file);
		  try{
			  BasicFileAttributes attribs = Files.readAttributes(path, BasicFileAttributes.class);
			  System.out.println(attribs.size());
		  } catch(IOException ioe){ioe.printStackTrace();}
	  }
	
}
