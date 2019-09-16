/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
        int index = 0;
        boolean found = false;
        int tmp = 0;
        for(int i = 1;i < A.length;i++)
        {
            index = i;
            while(index > 0 && !(found))
            {
                if(A[index] < A[index-1])
                {
                    tmp = A[index-1];
                    A[index-1] = A[index];
                    A[index] = tmp;
                }
                else
                {
                    found = true;
                }
                index--;
            }
        }
    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] A)
    {
        int minIndex = 0;
        int tmp = 0;
        for(int i = 0; i < A.length; i++)
        {
            minIndex = i;
            for(int a = i+1; a < A.length;a++)
            {
                if( A[a] < A[minIndex])
                {
                    minIndex = a;
                }
            }
            tmp = A[minIndex];
            A[minIndex] = A[i];
            A[i] = tmp;
        }
    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
        int index = 0; 
        boolean found = false;
        int tmp = 0;
        for(int i = 1; i < A.length;i++)
        {
            index = i;
            while(index > 0 && A[index] < A[index-1])
            {
                tmp = A[index-1];
                A[index-1] = A[index];
                A[index] = tmp;
                index--;
            }
        }
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
        mergeSortRecurse(A,0,A.length-1);
        merge(A,0,((A.length-1)/2)+1,A.length-1);
    }//mergeSort()

    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
        int midIdx = 0;
        if(leftIdx < rightIdx)
        {
            midIdx = (leftIdx + rightIdx) / 2;
        
            mergeSortRecurse(A,leftIdx,midIdx);
            mergeSortRecurse(A,midIdx+1,rightIdx);
            merge(A,leftIdx,midIdx+1,rightIdx);
        }
    }//mergeSortRecurse()

    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
        int tmp[] = new int[rightIdx-leftIdx +1];
        int ii = leftIdx;
        int jj = midIdx+1;
        int kk = 0;
        while((ii <=midIdx) && (jj <= rightIdx))
        {
            if(A[ii] <= A[jj])
            {
                tmp[kk] = A[ii];
                ii++;
            }
            else
            {
                tmp[kk] = A[jj];
                jj++;
            }
            kk++;
        }
        for(int i = ii; i <= midIdx;i++)
        {
            tmp[kk] = A[i];
            kk++;
        }
        for(int i = jj; i <= rightIdx;i++)
        {
            tmp[kk] = A[i];
            kk ++;
        }
        for(int i = leftIdx; i <= rightIdx;i++)
        {
            A[i] = tmp[i-leftIdx];
        }
    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
        quickSortRecurse(A,0,A.length-1);
    }//quickSort()

    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
        int pivotIdx;
        int newPivotIdx;
        if(rightIdx > leftIdx)
        {
            pivotIdx = (leftIdx+rightIdx)/2;
            newPivotIdx = doPartitioning(A,leftIdx,rightIdx,pivotIdx);
            
            quickSortRecurse(A,leftIdx,newPivotIdx-1);
            quickSortRecurse(A,newPivotIdx+1,rightIdx);
        }
        
    }//quickSortRecurse()
    private static int doPartitioning(
    int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
        int pivotVal = A[pivotIdx];
        A[pivotIdx] = A[rightIdx];
        A[rightIdx] = pivotVal;
        int currIdx = leftIdx;
        int newPivotIdx = 0;
        int temp = 0;
        for(int ii = leftIdx;ii<rightIdx;ii++)
        {
            if(A[ii] < pivotVal)
            {
                temp = A[ii];
                A[ii] = A[currIdx];
                A[currIdx] = temp;
                currIdx++;
            }
        }
        newPivotIdx = currIdx;
        A[rightIdx] = A[newPivotIdx];
        A[newPivotIdx] = pivotVal;
	return newPivotIdx;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(long[] A)
    {
        quickSortRecurse(A,0,A.length-1);
    }//quickSort()

    private static void quickSortRecurse(long[] A, int leftIdx, int rightIdx)
    {
        int pivotIdx;
        int newPivotIdx;
        if(rightIdx > leftIdx)
        {
            pivotIdx = (leftIdx+rightIdx)/2;
            newPivotIdx = doPartitioning(A,leftIdx,rightIdx,pivotIdx);
            
            quickSortRecurse(A,leftIdx,newPivotIdx-1);
            quickSortRecurse(A,newPivotIdx+1,rightIdx);
        }
        
    }//quickSortRecurse()
    private static int doPartitioning(
    long[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
        long pivotVal = A[pivotIdx];
        A[pivotIdx] = A[rightIdx];
        A[rightIdx] = pivotVal;
        int currIdx = leftIdx;
        int newPivotIdx = 0;
        long temp = 0;
        for(int ii = leftIdx;ii<rightIdx;ii++)
        {
            if(A[ii] < pivotVal)
            {
                temp = A[ii];
                A[ii] = A[currIdx];
                A[currIdx] = temp;
                currIdx++;
            }
        }
        newPivotIdx = currIdx;
        A[rightIdx] = A[newPivotIdx];
        A[newPivotIdx] = pivotVal;
	return newPivotIdx;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning
}//end Sorts calss
