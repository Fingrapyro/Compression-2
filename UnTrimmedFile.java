/***************
*Name: Barnabas Madai
*File Name: UnTrimedFile
*Purpose: Undoes transmutation.
***************/
public class UnTrimmedFile
{
    long unTrimmed[];
    Domain domain;
    Timer timer;

    public UnTrimmedFile(long inFile[], Domain inDomain)
    {
        timer = new Timer();
        domain = inDomain;
        unTrimmed = new long[inFile.length];
        long tmp = 0;
        int index = 0;
        for(int i = 0;i < inFile.length;i++)
        {
            tmp = inFile[i];
            while(index < domain.length() && 
            tmp > domain.getStart(index))
            {
                tmp += domain.getDifference(index)-1;
                index ++;
            }
            index = 0;
            unTrimmed[i] = tmp;
        }
        System.out.println(timer.toString());
    }

    public byte[] getBytes()
    {
        return (new ByteFile(unTrimmed)).getBytes();
    }
}
