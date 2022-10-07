package Java.HeapSort;

import java.util.*;
class HeapSort{
      public void heap_sort(int heap_Array[]) {
      int heap_len = heap_Array.length;
      // construct max heap
      for (int i = heap_len / 2 - 1; i >= 0; i--) {
        heapify(heap_Array, heap_len, i);
      }
      // Heap sort
      for (int i = heap_len - 1; i >= 0; i--) {
        int temp = heap_Array[0];
        heap_Array[0] = heap_Array[i];
        heap_Array[i] = temp;
        // Heapify root element
        heapify(heap_Array, i, 0);
      }
    }
   
    void heapify(int heap_Array[], int n, int i) {
      // find largest value
      int largest = i;
      int left = 2 * i + 1;
      int right = 2 * i + 2;
      if (left < n && heap_Array[left] > heap_Array[largest])
     largest = left;
      if (right < n && heap_Array[right] > heap_Array[largest])
        largest = right;
      // recursively heapify and swap if root is not the largest
      if (largest != i) {
        int swap = heap_Array[i];
        heap_Array[i] = heap_Array[largest];
        heap_Array[largest] = swap;
 
        heapify(heap_Array, n, largest);
      }
    }
}
class Main{
 public static void main(String args[]) {
        //define input array and print it
        int heap_Array[] = {6,2,9,4,10,15,1,13};
        System.out.println("Input Array:" + Arrays.toString(heap_Array));
        //call HeapSort method for given array
        HeapSort hs = new HeapSort();
        hs.heap_sort(heap_Array);
        //print the sorted array  
        System.out.println("Sorted Array:" + Arrays.toString(heap_Array));
    }
}