import java.util.*;

public class CountingSorter {
// uses counting sort algorithm to sort the given array using the least
// significant figure from the RadixSorter
  int biggest;
  public CountingSorter(int biggest){
    //int counter[] = new int[biggest];
    this.biggest = biggest;

  }
  public void sort(int[] value, int digits[]){

    int[] counter = new int[this.biggest+1]; // counts each instance of each element
    for(int i = 0; i < value.length; i++)
      counter[digits[i]]++;

    for(int i = 1; i < counter.length; i++) // cumulative count
      counter[i] += counter[i-1];

    int sorted[] = new int[value.length];
    for(int i = value.length-1; i >= 0; i--)
      sorted[--counter[digits[i]]] = value[i];

    for(int i = 0; i < value.length; i++)
      value[i] = sorted[i];
  }
}
