/***************
*Name: Barnabas Madai
*FileName: RepetitionRemovedFile.java
*Purpose: generates a version of the file which 
          does not poses repeats. Measured one long at a time!
***************/


public class RepetitionRemovedFile
{
    long data[];

    public RepetitionRemovedFile(LongFile inLongFile)
    {
        //Total used indexes
        int totalUsedSpace = 0;
        //actual occurrences, 
        //copy of the file with the exception of repeat
        long occurrences[];
        occurrences = new long[inLongFile.length()];
        //index for the while loop
        int index = 0;
        //Utilised as early exit from the while loop
        boolean found = false;
        int repeats = 0;
        occurrences[0] = inLongFile.get(0);
        totalUsedSpace++;
        //Going through
        for(int i = 1; i < inLongFile.length();i++)
        {
            if(inLongFile.get(i) == inLongFile.get(i-1))
            {
                repeats++;
            }
            else
            {
                occurrences[totalUsedSpace] = inLongFile.get(i);
                totalUsedSpace++;
            }
        }
        System.out.println("Used:" + totalUsedSpace);
        System.out.println("Repeats:" + repeats);
        inLongFile = null;
        data = new long[totalUsedSpace];
        for(int i = 0; i < data.length; i++)
        {
            data[i] = occurrences[i];
        }
    }

    public long[] getData()
    {
        return data;
    }
}
