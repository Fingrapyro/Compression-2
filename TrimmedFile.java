/*********
*Name: Barnabas Madai
*File Name: TrimmedFile.java
*Purpose: Trims the long themselves 
*to only the required possibilities.
********/
public class TrimmedFile
{
    long trimmed[];
    Domain domain;
    public TrimmedFile(DicedFile dicedFile, Analyzer analyzer)
    {
        long inFile[] = (new LongFile(dicedFile.getUtilised())).getLongs();
        domain = new Domain(analyzer.getDomain());
        trimmed = new long[inFile.length];
        int index = 0;
        long tmp = 0;
        for(int i = 0;i < trimmed.length;i++)
        {
            tmp = inFile[i];
            while(index < domain.length() && 
            tmp > domain.getStart(index))
            {
                index ++;
            }
            index--;
            for(int a = index; a > -1;a--)
            {
                tmp -= domain.getDifference(a)-1;
            }
            index = 0;
            trimmed[i] = tmp;
        }
    }

    public byte[] getByte()
    {
        return (new ByteFile(trimmed).getBytes());
    }
}
