/*************
*Name Barnabas Madai
*File Name: UnDicedFile.java
*Purpose: Seperates the utilised and leftOver part of the file, 
*         also removing the overHead of metadata.
*************/

public class UnDicedFile
{
    byte utilisedBytes[];
    byte leftOver[];

    byte range[];
    int originalSize;

    public UnDicedFile(DigitalFile inFile)
    {
        byte tmp[] = inFile.getBytes();
        byte tmpInt[] = new byte[4];
        IntFile intFile;
        //getting the range bytes.
        tmpInt[3] = tmp[tmp.length-1];
        tmpInt[2] = tmp[tmp.length-2];
        tmpInt[1] = tmp[tmp.length-3];
        tmpInt[0] = tmp[tmp.length-4];

        intFile = new IntFile(tmpInt);
        range = new byte[intFile.get(0)];
        for(int i = 0; i < range.length;i++)
        {
            range[(range.length-1)-i] = 
            tmp[((tmp.length-1)-4)-(i)];
        }
        
        //getting number of left over
        tmpInt[3] = tmp[((tmp.length-1)-4)-(range.length)];
        tmpInt[2] = tmp[((tmp.length-2)-4)-(range.length)];
        tmpInt[1] = tmp[((tmp.length-3)-4)-(range.length)];
        tmpInt[0] = tmp[((tmp.length-4)-4)-(range.length)];
        intFile = new IntFile(tmpInt);

        leftOver = new byte[intFile.get(0)];

        for(int i = 0; i < leftOver.length;i++)
        {
            leftOver[(leftOver.length-1)-i] = 
            tmp[((((tmp.length-1)-(2*4))-range.length)-(leftOver.length-i))];
        }

        //getting original size
        tmpInt[3] = tmp[((((tmp.length-1)-4)-(range.length))-4)-leftOver.length];
        tmpInt[2] = tmp[((((tmp.length-2)-4)-(range.length))-4)-leftOver.length];
        tmpInt[1] = tmp[((((tmp.length-3)-4)-(range.length))-4)-leftOver.length];
        tmpInt[0] = tmp[((((tmp.length-4)-4)-(range.length))-4)-leftOver.length];

        intFile = new IntFile(tmpInt);

        originalSize = intFile.get(0);

        utilisedBytes = new byte[((tmp.length - 12)-1)-range.length];
        for(int i = 0; i < ((tmp.length - 12)-1)-range.length;i++)
        {
            utilisedBytes[i] = tmp[i];
        }
    }

    public byte[] getUtilised()
    {
        return utilisedBytes;
    }

    public byte[] getLeftOver()
    {
        return leftOver;
    }

    public int getLengthLeftOver()
    {
        return leftOver.length;
    }

    public int getLengthUtilised()
    {
        return utilisedBytes.length;
    }

    public byte[] getRange()
    {
        return range;
    }

    public int getOriginalLength()
    {
        return originalSize;
    }
}
