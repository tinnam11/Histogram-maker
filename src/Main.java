import java.util.*;
import java.io.*;

//This is a histrogram creator it takes a
//text file and organizes the data in a histogram
//and summary value of the data

public class Main {
    //the main method calls the various method
    //and asks for users input from the console
    public static void main(String[] args) throws FileNotFoundException {
        introMess();
        System.out.println();
        System.out.print("input file name? ");
        Scanner inputRead = new Scanner(System.in);
        String myFile = inputRead.next();
        Scanner console = new Scanner(new File(myFile));
        System.out.println();
        int [] dataArr = new int[0]; // assign empty array
        int [] freqArr = new int[0]; // assign empty array
        dataArr = fileRead(console); // main data array
        freqArr = occurence(dataArr); // occurence array
        printHis(freqArr);
        System.out.println();
        finalStats(dataArr, freqArr);
    }

    //method prints out the introduction
    // Parameters: there are no parameters
    // Returns: there are no return values as this method just prints a message
    public static void introMess() {
        System.out.println("The program will analyze data from a dataset of");
        System.out.println("non-negative integer values. It will produce a");
        System.out.println("histogram of the data and output some statistics.");
    }

    // method reads values from file into an array
    // Parameters:
    //    - Scanner - scans each line text file
    // Returns:
    //    - data (int[]): array containing all the data values
    public static int [] fileRead(Scanner console){
        int numData = console.nextInt();
        int [] data = new int[numData];
        for (int i = 0; i < numData; i++) {
            data[i] = console.nextInt();
        }
        return data;
    }

    // method finds the index of the maximum number
    // Parameters:
    //    - data (int[]) - contains all data to find max value
    // Returns:
    //    - maxInd (int): the index of the maximum value
    public static int maxIndex(int[] data) {
        int maxInd = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > data[maxInd]) { // compares with the max value
                // System.out.println(data[i]);
                maxInd = i;
                // System.out.println(i);
            }
        }
        return maxInd;
    }

    // counts the occurence of each value (element) in the array
    // Parameters:
    //    - data (int[]) - contains all data to loop through the array
    // Returns:
    //    - count (int[]): an array containing the frequency of
    //                     in the array
    public static int[] occurence(int[] data) {
        int[] count = new int[data[(maxIndex(data))] + 1]; //new array to store occurence for each value
        for (int j = 0; j < data.length; j++ ) {
            count[data[j]]++;
        }
        return count;
    }

    // this method calculates the mean value
    // Parameters:
    //    - data (int[]) - array of data from text file to
    //              add total value of all data points
    // Returns:
    //    - mean (double): the average value from the data
    public static double meanVal(int[] data) {
        double total = 0;
        for (int n = 0; n < data.length; n++) {
            total += data[n];
        }
        double mean = total / data.length;
        return mean;
    }

    // this method prints out the histogram to visualize
    // the data
    // Parameters:
    //    - freq (int[]) - contains the frequency of each data
    //                     data value
    // Returns: there are no return values as this method just
    //          the histrogram
    public static void printHis(int[] freq) {
        for (int k = 0; k < freq.length; k++ ) { // loops from 0 to max value
            System.out.print(k + "| "); //prints the numbers
            for (int m = 0; m < freq[k]; m++) { //loops inside the occurence
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // this method prints out the final stat values from data
    // Parameters:
    //    - data (int[])  - contains all the data values to print out
    //    -  freq (int[]) - array contains frequency of each data value
    //                      to find the highest frequenct number (mode)
    // Returns: there are no return values as this method prints
    //          the final statistics
    public static void finalStats(int[] data, int[] freq) {
        int modeInd = 0;
        System.out.println("Num. Values: " + data.length);
        System.out.println("Mean: " + meanVal(data));
        for (int p = 0; p < freq.length; p++) { //loop in frequency array for max val
            if(freq[p] > freq[modeInd]) {
                modeInd = p;
            }
        }
        System.out.println("Mode: " + modeInd);
    }
}

