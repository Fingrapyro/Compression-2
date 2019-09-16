/*************
*Name:Barnabas Madai
*File Name: IntFile.java
*Purpose: Stores an int array, 
*representing the byte/long array thgat has been input.
*************/

public class IntFile
{
    private int file[];
    private byte leftOver[];
    public IntFile(byte inFile[])
    {
        int maximum = inFile.length/4;
        String tmp = ""+inFile.length%4;
        leftOver = new byte[((inFile.length%4)*4)/(10*(tmp.length()))];
        for(int i = (inFile.length/4); i < 
        ((inFile.length/4) + ((inFile.length%4)*4));i++)
        {
            leftOver[i-(inFile.length/4)] = inFile[i];
        }
        file = new int[maximum];
        for(int i = 0; i < maximum;i++)
        {
             file[i] = getInt(inFile,i*4);
        }
    }

    private static int getInt(byte[] array,int offset)
    {
        return
        ((int)(array[offset]   & 0xff) << 24) |
        ((int)(array[offset+1] & 0xff) << 16) |
        ((int)(array[offset+2] & 0xff) << 8) |
        ((int)(array[offset+3] & 0xff));
    }

    public int get(int index)
    {
        int result = 0;
        if(index < file.length)
        {
            result = file[index];
        }
        else
        {
            throw new IllegalArgumentException(
            "Error in IntFile.\n"+
            "get recieved an index above what is available.");
        }
        return result;
    }
}
