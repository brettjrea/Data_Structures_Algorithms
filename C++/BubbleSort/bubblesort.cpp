#include <iostream>
/*
function Bubble Sort(Values1, Values2){
for (i=0 to n-1)   
for (j=0 to n-1 )               //Invariant is initialized, remains false while running program.
if array[i] > array[i+1]        //Invariant is true when all the elements to the right of index 0 are greater then index 0
swap(array[i], array[i+1]) 
end
}

function print array(array, size){
for (i=0 to size)
print array[i]
end
}

function main{
print prompt "Enter size"
Take the size
Create array with size
assign random numbers to values of array
print array
send array to bubble sort function
print sorted array 
end
}
*/

using namespace std;
void BubbleSort(int values[], int numValues)
{
    int i, j;
    int temp;

    // Outer loop that begins at 0 and moves up until numValues - 1
    for (i = 0; i < numValues - 1; i++)
    {
        // Inner loop that begins at 0 and moves up until numValues -1 this carries the swap logic.
        for (j = 0; j < numValues - i - 1; j++)
            // if element at j < than j+1 than swap both
            if (values[j] > values[j + 1])
            {
                // swap logic
                temp = values[j];
                values[j] = values[j + 1];
                values[j + 1] = temp;
            }
    }
}

void printArray(int *arr, int size)
{
    for (int i = 0; i < size; i++)
        cout << arr[i] << " ";
    cout << endl;
}

int main()
{
    int size;
    int *arr;
    cout << "Enter size: ";
    cin >> size;
    arr = new int[size];
    for (int i = 0; i < size; i++)
        arr[i] = rand() % 100;
    cout << "Original Array: " << endl;
    printArray(arr, size);
    BubbleSort(arr, size);
    cout << "Sorted Array: " << endl;
    printArray(arr, size);
    return 0;
}