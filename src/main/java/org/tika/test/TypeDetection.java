package org.tika.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Handler;

import org.apache.tika.Tika;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;


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
//      System.out.println("Extracted Content: " + filecontent);


      /******* AutoDetectParser *******/
      
      //parse method parameters
      Parser parser = new AutoDetectParser();
      BodyContentHandler handler = new BodyContentHandler();
      Metadata metadata = new Metadata();
      FileInputStream inputstream = new FileInputStream(file);
//      InputStream stream = TikaInputStream.get(file); //instead of FileinputStreamer you can use InputStream of Tika library
      ParseContext context = new ParseContext();
      
      //parsing the file
      parser.parse(inputstream, handler, metadata, context);
      System.out.println("File content : " + handler.toString());
 
      
      /******* Metadata *******/
      System.out.println("MetaData********");
      Parser picParser = new AutoDetectParser();
      BodyContentHandler picHandler = new BodyContentHandler();
      Metadata picMetadata = new Metadata();
      File picFile = new File("C:/Users/New/Desktop/AlphaDev.png");

      //Parser method parameters
      FileInputStream picInputstream = new FileInputStream(picFile);
      ParseContext picContext = new ParseContext();
      
      parser.parse(picInputstream, picHandler, picMetadata, picContext);
      System.out.println(parser.toString());

      //getting the list of all meta data elements 
      String[] picMetadataNames = picMetadata.names();

      for(String name : picMetadataNames) {		        
         System.out.println(name + ": " + picMetadata.get(name));
      }
          
//      System.out.println(picMetadata.get("IHDR"));
      
      //list of meta data elements before adding new elements
//      System.out.println( " metadata elements :"  +Arrays.toString(picMetadata.names()));

      //adding new meta data name value pair
      picMetadata.add("newKey","Value Of newKey");
//      System.out.println(" metadata name value pair is successfully added");
      
      //printing all the meta data elements after adding new elements
//      System.out.println("Here is the list of all the metadata elements  after adding new elements ");
//      System.out.println( Arrays.toString(picMetadata.names()));
      
     
      
      
      System.out.println("********** END: TypeDetection ********");
   }
}