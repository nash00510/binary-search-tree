/*Author: Nash Smith
  ID: 1277758
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class OddWords {

	public static void main (String [] args){
		
		//if no filename was entered
		if(args.length < 1){
			System.out.println("Enter filename as argument.");
		}else{
			try{
				/*Variables*/
				File file = new File(args[0]);
				BufferedReader br = new BufferedReader(new FileReader(file));
				String words;//string to read into
				BSTlex tree = new BSTlex();
				
				//For each line of the file
				while((words = br.readLine()) != null){
					//create an array of words split at non alpha-numeric characters
					String[] wordsArray = words.split("[^a-zA-Z0-9]+");
					
					//for each word on the line
					for(String s: wordsArray){
						//insert it into the tree
						//deletion is checked in the insert method
						tree.insert(s);
					}
				}
				
				//close the buffered reader stream
				br.close();
				
				//print the tree in lexicographical order
				System.out.print("LEXICON: ");
				System.out.println(tree.toString());
				
				
			}catch (IOException e){
			
				e.printStackTrace();
			
			}
		}
	}

}
