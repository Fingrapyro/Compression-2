/***************
*Name: barnabas madai
*Class Name: SortedFile.java
*Purpose: Will sort and store the array provided to it.
***************/


public class SortedFile
{
    long sorted[];
    public SortedFile(long inData[])
    {
        sorted = new long[inData.length];
        for(int i = 0; i < sorted.length;i++)
        {
            sorted[i] = inData[i];
        }
        Sorts.quickSort(sorted);
    }

    public long[] getData()
    {
        return sorted;
    }
}
