/*
Recursive Merge Sort

This is a top-down approach. In this approach, the array to be sorted is broken down into smaller arrays until each array contains only one element.

Time complexity of Merge Sort is θ(Nlog(N)) in all 3 cases (worst, average, and best)    

O(n (work per level) * log(n) (number of levels))

as merge sort always divides the array into two halves and takes linear time to merge two halves.
  
Auxiliary Space: O(n), In merge sort all elements are copied into an auxiliary array. 
So N auxiliary space is required for merge sort.
*/

import java.util.Arrays; 
public class Main { 
    public static void merge_Sort(int[] numArray) { 
        //return if array is empty
        if(numArray == null) { 
            return; 
        } 
          if(numArray.length > 1) { 
            int mid = numArray.length / 2; //find mid of the array
   
            // left half of the array 
            int[] left = new int[mid]; 
            for(int i = 0; i < mid; i++) { 
                left[i] = numArray[i]; 
            } 
            // right half of the array 
            int[] right = new int[numArray.length - mid]; 
            for(int i = mid; i < numArray.length; i++) { 
                right[i - mid] = numArray[i]; 
            } 
            //                                                                                        ||||||||
            //head recursive calls will keep dividing until numArray.length > 1                      //// \\\\
            //                                                                                      /\/\   /\/\
            merge_Sort(left);   //call merge_Sort routine for left half of the array           
            merge_Sort(right);   // call merge_Sort routine for right half of the array       
   
            int i = 0; 
            int j = 0; 
            int k = 0; 

            // now merge two arrays                                                                  \/\/   \/\/
            //                                                                                        \\\\ ////
            //                                                                                         |||||||
            while(i < left.length && j < right.length) { 
                if(left[i] < right[j]) { 
                    numArray[k] = left[i]; 
                    i++; 
                } 
                else { 
                    numArray[k] = right[j]; 
                    j++; 
                } 
                k++; 
            } 
          
   // remaining elements counter to prevent an infinity loop or overflow
            while(i < left.length) { 
                numArray[k] = left[i]; 
                i++; 
                k++; 
            } 
            while(j < right.length) { 
                numArray[k] = right[j]; 
                j++; 
                k++; 
            } 
        } 
    }
public static void main(String[] args) { 
        int numArray[] = {10, 23, -11, 54, 2, 9, -10, 45}; 
        //print original array       
        System.out.println("Original Array:" + Arrays.toString(numArray)); 
        //call merge_Sort routine to sort arrays recursively
        merge_Sort(numArray); 
        //print the sorted array
        System.out.println("Sorted array:" + Arrays.toString(numArray)); 
   } 
} 
