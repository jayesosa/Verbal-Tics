/**
 * This program analyzes a text uploaded by the user for the amount of "speech tics"
 * and returns to the user how many times certain tics were said as well as the density
 * of it's occurance and how many times overall it was said
 * 
 * author: Jaye Sosa
 */

/*The program must be able to analyze any text file
The user must be able to enter as many tics as they would like
The list of tics entered by the user must be stored in an array
You must use separate methods for each component of the analysis
The output must be formatted so that all output lines up nicely
*/

package edu.nyu.cs.js8321;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SosaJayeTextAnalysis {
	
	public static double totalTics = 0; // the total amount of tics calculated
	
	public static double totalWords = 0; // the total amount of the words in the whole text
	
	public static String[] userTics; // a blank array for storing the tics that the user enters
	
	public static int countedTics = 0; // a variable that the counts the number of a specific within the main method
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		//ask user which file they want to open
		System.out.println("What file would you like to open? ");
		
		// create a scanner to allow user to input any file name
		Scanner scnr = new Scanner(System.in);
		
		// user inputs file name
		String file = scnr.nextLine();
		
		// create another scanner to open file inside of user src file
		Scanner scanner =  new Scanner(new File("src/"+ file +".txt"));
	
		//ask the user which words they want to look for in the text
		System.out.println("What words would you like to search for? (separate each word with a comma)");
				
		// create scanner to accept user input of tic words they want to look for
		Scanner wordInput = new Scanner(System.in);
		
		//create a string variable for the words the user wants to look for
		String words = wordInput.next();
		
		// split the user input of tics into an array by splitting each word by the comma
		String [] wordArray = words.split(",");
			
	
		System.out.println("------------ Analyzing text ------------");
		
		// create a new array that is the length of how many different tics the user wants to count
		int [] countedTicsArray = new int[wordArray.length];

		//this while loop will look for an available line in the imported text to analyze
		while (scanner.hasNextLine()) {
			
			//create a string out of the line of the text
			String line = scanner.nextLine();
			
			// split each word into its own value in an array by looking at the space
			String[] array = line.split(" ");
			
			// add the number of words present on each line to the total word count
			totalWords += array.length;
		
		// for loop that goes through the length of the array that counts the user's selected tics
		 for (int j = 0; j <wordArray.length; j++) {
			 
			 // set the counter equal to 0
			 int counter = 0;
			
			 // nested for loop to go through each word on the line and check if the tics that the user provides
			 // matches up with the words within the text
			 for (int i = 0; i<array.length; i++){
					
				 	// if the user specified tic matches, add one to the total tic tracker and 1 to teh counter
				 	// that counts the amount of tics there are for that one line of text
					if (wordArray[j].equals(array[i])) {
						
						totalTics += 1; 
						
						counter += 1;
				                  }
					
					          }
			 // add the counter to the counted tics variable because this represents the number of tics for a speciic tic
			 countedTics += counter; 
			 
			 // add how many counts there are for one tic to the array 
			 countedTicsArray[j] += counter;
			 
			 // set counted tics back to 0 so the next tic can be counted
			 countedTics = 0;
		}
		 
		 
		}
		
		method1(totalTics, (totalTics / totalWords) ); 
		
		method2(countedTicsArray, wordArray, totalTics);
		
		scnr.close(); 
		 
		scanner.close();
		 
		wordInput.close();
		 
		
		}
	
	// this method accepts the total number of tics as the well as the density of the tics and prints them out
	public static void method1(double totalTics, double densityWords) { // create another method to print out the results to the user
		
		System.out.println("\nTotal number of tics: " + totalTics);
		
		System.out.printf("Density of tics: %.2f ", densityWords);
		
		System.out.println("\n\n------------ Tic Breakdown ------------\n");
		
		}
	
	// this method accepts the array of how many counted tics there are per tic, the array of the user selected tics, as 
	// well as the total number of tics
	public static void method2(int[] countedTicsArray, String[] wordArray, double totalTics) {
		
		int counterVariable = 0;
		
		// use a while loop to print out the results of each tic 
		while (counterVariable < countedTicsArray.length){
			
			System.out.printf("%-8s%-8s%-8s%-8s%-8.1f%%\n",wordArray[counterVariable], "/" , countedTicsArray[counterVariable], "/", ((countedTicsArray[counterVariable] / totalTics) *100));
			
			counterVariable++;
			
		}
		
		
	
	}
		
		
			
		
}
				

