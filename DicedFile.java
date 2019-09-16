/*****************
*Name: Barnabqas Madai
*FileName: DicedFile
*Purpose: Recieves a DigitalFile Object,
*         
*****************/
public class DicedFile
{
    byte utilisedBytes[];
    byte leftOver[];
    public DicedFile(DigitalFile inFile)
    {
        byte tmp[] = inFile.getBytes();
        int numUtilised = ((tmp.length/64)*64);
        int numLeftOver = (tmp.length-numUtilised); 
        utilisedBytes = new byte[numUtilised];
        for(int i =0; i < utilisedBytes.length;i++)
        {
            utilisedBytes[i] = tmp[i];
        }
        leftOver = new byte[numLeftOver];
        for(int i = utilisedBytes.length;i < tmp.length; i++)
        {
            leftOver[i-utilisedBytes.length] = tmp[i];
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
}
