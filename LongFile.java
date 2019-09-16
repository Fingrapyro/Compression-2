/****************
*Name: Barnabas Madai
*FileName: LongFile.java
*Purpose: Stores an array of long s from a byte array, 
*discarding leftover bytes.
****************/

public class LongFile
{
    //Stores all bytes possible in file[]
    private long file[];
    //leftover bytes are stored here, irrelevant, 
    //except when explicitly asked for
    private byte leftOver[];
    public LongFile(byte inFile[])
    {
         int maximum = inFile.length/8;
         String tmp = "" + inFile.length%4;
         leftOver = new byte[((inFile.length%8)*8)/(10*(tmp.length()))];
         for(int i = (inFile.length/8); i < 
         ((inFile.length/8) + ((inFile.length%8)*8));i++)
         {
             leftOver[i-(inFile.length/8)] = inFile[i];
         }
         file = new long[maximum];
         for(int i = 0; i < maximum;i++)
         {
             file[i] = getLong(inFile,i*8);
         }
    }

    public LongFile(long inFile[])
    {
        file = inFile;
    }

    public LongFile(long inFile)
    {
        file = new long[1];
        file[0] = inFile;
    }

    private static long getLong(byte[] array, int offset)
    {
        return
        ((long)(array[offset]   & 0xff) << 56) |
        ((long)(array[offset+1] & 0xff) << 48) |
        ((long)(array[offset+2] & 0xff) << 40) |
        ((long)(array[offset+3] & 0xff) << 32) |
        ((long)(array[offset+4] & 0xff) << 24) |
        ((long)(array[offset+5] & 0xff) << 16) |
        ((long)(array[offset+6] & 0xff) << 8) |
        ((long)(array[offset+7] & 0xff));
    }

    public long get(int index)
    {
        return file[index];
    }

    public int length()
    {
        return file.length;
    }

    public long[] getLongs()
    {
        return file;
    }

    public byte[] getLeftOver()
    {
        return leftOver;
    }

    public boolean hasLeftOver()
    {
        return (leftOver.length != 0);
    }
}
