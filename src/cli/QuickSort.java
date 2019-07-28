package cli;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
	/* java.util.Arrays use quick sort and merge sort, but only when the data type is primitive, it will use quicksort for performance:
 	 * https://cafe.elharo.com/programming/java-programming/why-java-util-arrays-uses-two-sorting-algorithms/
	 * therefore we write the algorithm to use Float[].   
	 */
	
	public Key[] getIntialArray(ArrayList<Key> array) {
		Key[] arr = new Key[array.size()];
		for(int i=0; i< array.size(); i++) {
			arr[i] = array.get(i);
		}
		return arr;
	}

	
	public Key[] getTopResults(Key[] array, int num) {
		Key[] arr = new Key[num - 1];
		int lastIndex = array.length;
		arr = Arrays.copyOfRange(array, lastIndex - num, lastIndex);
		return arr;
	}
	
	public void sort(Key[] arr, int start, int end) {
		
        if (start < end) 
        { 
        	// pivot is index used for partition.
            int pivot = partition(arr, start, end); 
  
            // sort both partitions.
            sort(arr, start, pivot-1); 
            sort(arr, pivot+1, end); 
        }
		
    } 

		
		
	public static int partition(Key[] arr, int start, int end) 
	    { 
	        float pivot = arr[end].getValue();  
	     // index of smaller element
	        int i = (start-1);  
	        for (int j=start; j<end; j++) 
	        { 
	            // If current element is smaller than or equal to pivot
	            if (arr[j].getValue() <= pivot) 
	            { 
	                i++; 
	  
	                // swap arr[i] and arr[j] 
	                Key temp = arr[i]; 
	                arr[i] = arr[j]; 
	                arr[j] = temp; 
	            } 
	        } 
	  
	        // swap arr[i+1] and arr[end] (or pivot) 
	        Key temp = arr[i+1]; 
	        arr[i+1] = arr[end]; 
	        arr[end] = temp; 
	  
	        return i+1; 
	    } 
	  
	  

}
