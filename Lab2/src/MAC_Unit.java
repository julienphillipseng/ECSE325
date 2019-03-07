import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MAC_Unit {
	
	
	 public static void main(String[] args) {
	        //
	        // Create an instance of File for data.txt file.
	        //
	        File fileX = new File("C:\\Users\\julie\\Desktop\\EclipseWorkspaces\\ecse325\\G41_LAB2\\src\\lab2-x.txt");
	        File fileY = new File("C:\\Users\\julie\\Desktop\\EclipseWorkspaces\\ecse325\\G41_LAB2\\src\\lab2-y.txt");
	        String lineX = null;
	        String lineY = null;
	        float arrayX[] = new float[1000];
            float arrayY[] = new float[1000];
            int maxWordX = 0;
            int maxWordY = 0;
            int maxFracX = 0;
            int maxFracY = 0;
            int maxIntX = 0;
            int maxIntY = 0;
	        String twosCompX[] = new String[1000];
	        String twosCompY[] = new String[1000];
            
	        try 
	        {
	            //
	            // Create a new Scanner object which will read the data from the 
	            // file passed in. To check if there are more line to read from it
	            // we check by calling the scanner.hasNextLine() method. We then
	            // read line one by one till all line is read.
	            //
	            Scanner scannerX = new Scanner(fileX);
	            Scanner scannerY = new Scanner(fileY);
	            while (scannerX.hasNextLine()) 
	            {
	                lineX = scannerX.nextLine();
	                //System.out.println(lineX);
	            }
	            
	            while (scannerY.hasNextLine())
	            {
	            	lineY = scannerY.nextLine();
	            	//System.out.println(lineY);
	            }
	            
	            String delimiters = " "; // a space and a comma
	            StringTokenizer stringTokenizerX = new StringTokenizer(lineX, delimiters);
	            StringTokenizer stringTokenizerY = new StringTokenizer(lineY, delimiters);
	            String tokenX = null;
	            String tokenY = null;
	            int i = 0;
	            int j = 0;
	            
	            while (stringTokenizerX.hasMoreTokens()) 
	            {
	                tokenX = stringTokenizerX.nextToken();
	                float element = Float.parseFloat(tokenX);
	                arrayX[i] = element;
	                i++;
	                //System.out.println(token);
	            }
	            
	            while (stringTokenizerY.hasMoreTokens())
	            {
	            	tokenY = stringTokenizerY.nextToken();
	                float element = Float.parseFloat(tokenY);
	                arrayY[j] = element;
	                j++;
	            }
	            
	            scannerX.close();
	            scannerY.close();
	            
     
	        } 
	        catch (FileNotFoundException e) 
	        {
	            e.printStackTrace();
	        }
	        
	        //get number of bits required to represent each number.
	        for (int i=0; i<1000; i++) 
	        {
	        	//Get both numbers
	        	float numberX = arrayX[i];
	        	float numberY = arrayY[i];
	        	//String numXSign = "0";
	        	//String numYSign = "0";
	        	
	        	//if either number is negative change it to positive
	        	if(numberX < 0) {
	        		numberX = numberX * -1;
	        		///numXSign = "1";
	        	}
	        	
	        	if (numberY < 0) {
	        		numberY = numberY * -1;
	        		//numYSign = "0";
	        	}
	        	
	        	//getting integer part in decimal
	        	int intPartX = (int)numberX;
	        	int intPartY = (int)numberY;
	        	
	        	//make sure its positive
	        	if(intPartX < 0) {
	        		intPartX = intPartX * -1;
	        	}
	        	
	        	if (intPartY < 0) {
	        		intPartY = intPartY * -1;
	        	}
	        	
	        	//getting fractional part in decimal
	        	double fracPartX = numberX - (float)intPartX;
	        	double fracPartY = numberY - (float)intPartY;
	        	
	        	//make sure positive
	        	if(fracPartX < 0) {
	        		fracPartX = fracPartX * -1;
	        	}
	        	
	        	if (fracPartY < 0) {
	        		fracPartY = fracPartY * -1;
	        	}
	        	
	        	//System.out.println("Number = " + intPartY + " + " + fracPartY);
	        	
	        	int counterX = 0;
	        	int counterY = 0;
	        	int exponent = -1;
	        	
	        	//String binFracX = "";
	        	//String binFracY = "";
	        	
	        	//calculate how many bits are required to store the fraction in bits
	        	while(fracPartX != 0) 
	        	{
	        		//System.out.println("in first while loop");
	        		if(Math.pow(2, exponent) <= fracPartX) 
	        		{
	        			fracPartX = fracPartX - Math.pow(2, exponent);
	        			//binFracX = binFracX + "1";
	        		}
	        		else
	        		{
	        			//binFracX = binFracX + "0";
	        		}
	        		exponent = exponent - 1;
	        		counterX++;
	        	}
	        	
	        	//reset exponent count
	        	exponent = -1;
	        	
	        	while(fracPartY != 0) 
	        	{
	        		//System.out.println("in second while loop");
	        		if(Math.pow(2, exponent) <= fracPartY) 
	        		{
	        			fracPartY = fracPartY - Math.pow(2, exponent);
	        			//binFracY = binFracY + "1";
	        		}
	        		else 
	        		{
	        			//binFracY = binFracY + "0";
	        		}
	        		exponent = exponent - 1;
	        		counterY++;
	        	}
        		//System.out.println("out second while loop");

	        	
	        	Integer fracPartXBits = counterX;
	        	Integer fracPartYBits = counterY;
	        	
	        	//number of bits to store just the integer part
	        	Integer intPartXBits = Integer.toBinaryString(intPartX).length() + 1;
	        	Integer intPartYBits = Integer.toBinaryString(intPartY).length() + 1;
	        	
	        	//get the integer in string form
	        	//String numXString = numXSign + Integer.toBinaryString(intPartX) + "." + binFracX + "  ";
	        	//String numYString = numYSign + Integer.toBinaryString(intPartY) + "." + binFracY + "  ";
	        	
	        	//place both string into the array
	        	//twosCompX[i] = numXString;
	        	//twosCompY[i] = numYString;
      	
	        
	        	Integer totalBitsX = intPartXBits + fracPartXBits;
	        	Integer totalBitsY = intPartYBits + fracPartYBits;
	        	
	        	if (maxWordX < totalBitsX) {
	        		maxWordX = totalBitsX;
	        	}
	        	
	        	if (maxWordY < totalBitsY) {
	        		maxWordY = totalBitsY;
	        	}
	        	
	        	if (maxFracX < fracPartXBits) {
	        		maxFracX = fracPartXBits;
	        	}
	        	
	        	if (maxFracY < fracPartYBits) {
	        		maxFracY = fracPartYBits;
	        	}
	        	
	        	if (maxIntX < intPartXBits) {
	        		maxIntX = intPartXBits;
	        	}
	        	
	        	if (maxIntY < intPartYBits) {
	        		maxIntY = intPartYBits;
	        	}
	        	
	        }
	        
	        
	        System.out.println("Max Word Bits X: " + maxWordX + "     Max Int size X: " + maxIntX + "     Max Frac Size X: " + maxFracX);
	        System.out.println("Max Word Bits Y: " + maxWordY + "     Max Int size Y: " + maxIntY + "     Max Frac Size Y: " + maxFracY);
	        
	        
//	        String test = Integer.toBinaryString((int)Math.round(0.75));
//	        System.out.println(test);
	        //String properFormatX = roundedNumX.substring(22, 25) + "." + roundedNumX.substring(25, roundedNumX.length());
	        //System.out.println(properFormatX);
//	        String properFormatX = "";
//        	//String properFormatY = "";
//        	
//        	double numToRoundX = 0.75 * Math.pow(2, 7);
//        	String roundedNumX = Integer.toBinaryString((int)Math.round(numToRoundX));
//	        int numZerosToAddX = 10 - roundedNumX.length();
//        	String zeroStringX = "";
//        	for (int j=0; j<numZerosToAddX; j++) {
//        		zeroStringX += "0";
//        	}
//        	properFormatX = zeroStringX + roundedNumX;
//        	System.out.println(properFormatX);
        	
        	
	        
	        
	        //--------------------- ALTERNATE VERSION OF THE ARRAY-------------------------//
	        //put all the number in the array in the twos complement form 
 
	        for(int i=0; i<1000; i++) 
	        {
	        	String properFormatX = "";
	        	String properFormatY = "";
	        	 
	        	System.out.println("maxFracX: " + maxFracX);
	        	System.out.println("number to convert: " + arrayX[i]);
	        	
	        	double numToRoundX = arrayX[i] * Math.pow(2, maxFracX);
	        	double numToRoundY = arrayY[i] * Math.pow(2, maxFracY);
	        	
	        	System.out.println("numToRound:" + numToRoundX);
	        	
	        	if (numToRoundX < 0) 
	        	{
	        		System.out.println("In numToRoundX < 0 ");
		        	String roundedNumX = Integer.toBinaryString((int)Math.round(numToRoundX));
		        	properFormatX = roundedNumX.substring(22, 25) + "." + roundedNumX.substring(25, roundedNumX.length());
	        	}
	        	if (numToRoundY < 0) 
	        	{
	        		//System.out.println("In numToRoundY < 0 ");
		        	String roundedNumY = Integer.toBinaryString((int)Math.round(numToRoundY));
		        	properFormatY = roundedNumY.substring(22, 25) + "." + roundedNumY.substring(25, roundedNumY.length());
	        	}
	        	if (numToRoundX >= 0) //for positive numbers
	        	{ 
	        		System.out.println("In numToRoundX > 0 ");
	        		String roundedNumX = Integer.toBinaryString((int)Math.round(numToRoundX));

	        		//fix length of positive numbers X and add decimal pt
		        	int numZerosToAddX = 10 - roundedNumX.length();
		        	String zeroStringX = "";
		        	for (int j=0; j<numZerosToAddX; j++) {
		        		zeroStringX += "0";
		        	}
		        	properFormatX = zeroStringX + roundedNumX;
		        	properFormatX = properFormatX.substring(0,3) + "." + properFormatX.substring(3, properFormatX.length());

	        	}
	        	if (numToRoundY >= 0) //for positive numbers
	        	{ 
	        		//System.out.println("numToRoundY is positive");
		        	String roundedNumY = Integer.toBinaryString((int)Math.round(numToRoundY));

	        		//fix length of positive numbers X and add decimal pt
		        	int numZerosToAddY = 10 - roundedNumY.length();
		        	String zeroStringY = "";
		        	for (int j=0; j<numZerosToAddY; j++) {
		        		zeroStringY += "0";
		        	}
		        	properFormatY = zeroStringY + roundedNumY;
		        	properFormatY = properFormatY.substring(0,3) + "." + properFormatY.substring(3, properFormatY.length());
	        	}
	        	
	        	System.out.println("properFormatX: " + properFormatX);
	        	      	
	        	twosCompX[i] = properFormatX;
	        	twosCompY[i] = properFormatY;
	        }
	        
//	        for (int i=0; i<1000; i++) {
//	        	System.out.println(twosCompX[i]);
//	        }
	        
	        
	        //write the array of 2's complement numbers to txt file
	        PrintWriter writerX;
	        PrintWriter writerY;
	        PrintWriter writerZ;
			try
			{
				writerX = new PrintWriter("lab2-x-fixed-point.txt");
				writerY = new PrintWriter("lab2-y-fixed-point.txt");
				
				for(int i=0; i<1000; i++) {
					writerX.write(twosCompX[i] + "\n");
				}
				
				for(int j=0; j<1000; j++) {
					writerY.write(twosCompY[j] + "\n");
				}
		        writerX.close();
		        writerY.close();
				
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
	        

	    }

}
