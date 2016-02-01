package org.tika.test;

import java.io.File;

import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;


public class TypeDetection {

   public static void main(String[] args) throws Exception {
	   System.out.println("********** START: TypeDetection ********\n");
      //assume example.mp3 is in your current directory
      File file = new File("C:/Users/New/Desktop/tika.doc");
      
      //Instantiating tika facade class 
      Tika tika = new Tika();
      
      //detecting the file type using detect method      
      System.out.println("File Type: " + tika.detect(file));
      
      /***** content extraction *****/
      String filecontent = tika.parseToString(file);
      System.out.println("Extracted Content: " + filecontent);
      
      
      System.out.println("********** END: TypeDetection ********");
   }
}