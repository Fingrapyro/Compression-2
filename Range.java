/************
*Name: Barnabas Madai
*File Name: Range.java
*Purpose: Stores the necessary data for one range of
*unused possibilities.
***********/

public class Range
{
    long start;
    long finish;
    
    long difference;
    public Range(long inStart, long inFinish )
    {
        start = inStart;
        finish = inFinish;
        difference = inFinish - inStart;
    }

    public long getStart()
    {
        return start;
    }

    public long getFinish()
    {
        return finish;
    }
    
    public long getDifference()
    {
        return difference;
    }
    
    public byte[] getBytes()
    {
        long tmp[] = new long[2];
        tmp[0] = start;
        tmp[1] = finish;
        ByteFile byteFile = new ByteFile(tmp);
        return byteFile.getBytes();
    }

    public String toString()
    {
        return "Start: " + start + " Finish: " + finish;
    }
}
