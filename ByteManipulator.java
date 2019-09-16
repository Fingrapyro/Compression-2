public class ByteManipulator
{

    public static String find(long data[],long inFind)
    {
        String result = "";
        int count = 0;
        if(data[0] == inFind)
        {
            result += "Found on first index. Following index value:"+
            data[1] + "\n";
            count ++;
        }
        for(int i = 1;i < data.length-1;i++)
        {
            if(data[i] == inFind)
            {
                result += "Found at index: " + i + 
                          "previous value: " + data[i-1] +
                          "next value: " + (data[i+1]);
                count++;
            }
        }
        if(data.length > 1)
        {
            if(data[data.length-1] == inFind)
            {
                result += "Found last index. After index value:"+
                data[data.length-2] + "\n";
                count++;
            }
        }
        return result;
    }

    public static String gCompare(long data1[],long data2[])
    {
        String result = "";
        int count = 0;
        if(data1.length == data2.length)
        {
            for(int i = 1;i < data1.length-1;i++)
            {
                if(data1[i] != data2[i])
                {
                    result += "Found at index: " + i + 
                              "First set: " + data1[i] +
                              "Second set: " + (data2[i] + "\n");
                    count++;
                }
            }
            result += "Total differences: " + count;
        }
        else
        {
            throw new IllegalArgumentException(
            "Error, long arrays input are not of the same length.");
        }
        return result;
    }

    public static int[] countBitRepeats(ByteFile inFile)
    {
        byte validate;
        byte temp;
        int[] result = new int[8];
        byte[] terms = new byte[8];
        terms[0] = -128;
        terms[1] = 1;
        terms[2] = 2;
        terms[3] = 4;
        terms[4] = 8;
        terms[5] = 16;
        terms[6] = 32;
        terms[7] = 64;
        for(int i = 0; i < inFile.length(); i++ )
        {
            for(int a = 0; a < 8; a++)
            {
                temp = inFile.get(i);
                temp = (byte)  (temp & terms[a]);
                if (temp == 0)
                {
                    result[a] ++;
                }
            }
        }
        return result;
    }

    public static int[] countByteRepeats(ByteFile inFile)
    {
        int result[] = new int[256];
        for(int i = 0;i < inFile.length();i++)
        {
            result[(inFile.get(i))+128] ++;
        }
        return result;

        
    }
}
