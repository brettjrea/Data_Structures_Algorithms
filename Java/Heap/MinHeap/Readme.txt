                       Heap Data Structure

                        (12) <----Parent is the min value
                        /  \
                    (15)    (30) <-- Recursively True for all subtrees.
                    /  \    /  \
                  (40)(50)(90)(45) 

        The key value of each internal node is smaller than or equal to its child nodes.
     
        #1) Insert (): Initially, a new key is added at the end of the tree. If the key is larger than its parent node, then the heap property is maintained. Otherwise, we need to traverse the key upwards to fulfill the heap property. Insertion operation in min heap takes O (log n) time.

        #2) extractMin (): This operation removes the minimum element from the heap. Note that the heap property should be maintained after removing the root element (min element) from the heap. This entire operation takes O (Log n).

        #3) getMin (): getMin () returns the root of the heap which is also the minimum element. This operation is done in O (1) time.

                    Heap sort

        The Time Complexity of Heap sort is O (n log n) in all the cases. The space complexity is O (1).

        !! Not to be confused with heap algorithm for number of permutations. !!
        !! For N numbers, it takes O(N!) time complexity as there are N! permutations. !!

                procedure build_minheap 
                Array Arr: of size N => array of elements
                {
                    repeat for (i = N/2 ; i >= 1 ; i--)
                        call procedure min_heapify (A, i);
                }
                procedure min_heapify (var A[ ] , var i, var N)
                {
                var left  = 2*i;
                var right = 2*i+1;
                var smallest;
                if(left <= N and A[left] < A[ i ] )
                    smallest = left;
                else
                    smallest = i;
                if(right <= N and A[right] < A[smallest] )
                    smallest = right;
                if(smallest != i)
                {
                    swap A[ i ] and  A[ smallest ]);
                    call min_heapify (A, smallest,N);
                } 
                }
