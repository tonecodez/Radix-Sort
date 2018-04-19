import java.util.*;

public class RadixSorter {
// uses the radix sort algorithm to sort the integer array
// into ascending order
  public void sort(int[] list){

    // instance of the CountingSorter class
    CountingSorter sorter = new CountingSorter(9);
    int[] digits = new int[list.length]; // array that will contain least significant figures
    int[] dArray = list.clone(); // dummy array
    int numOfNum = 0; // number of digits
    int leastSig = 0; // least significant figure

    // gets the max number of numbers in the list. if array is 100 12 1000, numOfNum=4
    for (int i = 0; i < list.length; i++){
      int placeHolder = String.valueOf(list[i]).length();

      // replaces the number of digits with the highest in the array
      if(placeHolder > numOfNum)
        numOfNum = placeHolder;
    }

    int keeper = numOfNum; // keeps track of the max number of digits
    while(numOfNum > 0) {

      for(int i = 0; i < list.length; i++){ // will populate digits with the least significant figure
        leastSig = dArray[i]%10;
        digits[i] = leastSig; // fills an array with the least significant figure
      }

      sorter.sort(list, digits);

      dArray = list.clone();// copies the newly sorted array

      for(int j = numOfNum; j <= keeper; j++){ // keeps track of how many digits to remove
        for(int i = 0; i <list.length; i++) // will remove the last significant figure in the copy of the array to be sorted
          dArray[i] /= 10; // will remove the last digit... if 121, gets 12
      }
      --numOfNum;
    }
  }
}
