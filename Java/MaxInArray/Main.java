package MaxInArray;
//MaxInArray;
// An example for Algorithms and Data Structures

//Identify a linear time algorithm O(1)
public class Main {
    public static void main(String[] args) {
        int[] array = new int[100];

        // **********Linear time operation 
        // create random numbers
        // looping for 100 times
        for(int i = 0;i<100;i++) {

            // generating random value for index i
            array[i] = 1 + (int) (Math.random() * (1000));
        }

        // **********Linear time operation 
        // print the array
        // looping for 100 times
        System.out.println("Content of array is");
        for(int i = 0;i<100;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();

        // **********Linear time operation 
        // setting first value and comparing largest to largest
        int largest = array[0];
        // looping from 1 to 99
        for(int i = 1;i<100;i++){

            // checking that the largest is less than array[i]
            if(largest<array[i]){

                // updating the value of largest
                largest = array[i];
            }
        }
        // printing the largest value in the array
        System.out.println("Largest value in the array is "+largest);
    }
}