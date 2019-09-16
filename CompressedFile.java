/****************
*Name: Barnabas Madai
*FileName: CompressedFile.java
*Purpose: COmpresses a transmuted file.
***************/
public class CompressedFile
{
    byte compressedFile[];
    public CompressedFile(TrimmedFile trimmedFile)
    {
        byte originalFile[] = trimmedFile.getByte();
        int sectionSize = originalFile.length/64;
        int compressedSize = originalFile.length-sectionSize;
        compressedFile = new byte[compressedSize];
        if((sectionSize*64)
        == originalFile.length)
        {
            for(int i = 0; i < compressedFile.length;i++)
            {
                if(i%8 != 0)
                {
                    compressedFile[i] = originalFile[i];
                }
                else
                {
                  //  System.out.println(compressedFile[i]);
                    compressedFile[i] = merge(
                    originalFile[i],originalFile[compressedSize+(i/64)],i);
                    //System.out.println(compressedFile[i]);
                   // System.out.println(originalFile[i] + " " +
                   // originalFile[compressedSize+(i/64)] + " " + i);
                }
            }
        }
        else
        {
            throw new IllegalArgumentException(
            "DicedFile failed.");
        }
    }

    private byte merge(byte original,byte toBeAdded,int index)
    {
        byte result = 0;
        byte temp[] = new byte[8];
        temp[0] = -128;
        temp[1] = 64;
        temp[2] = 32;
        temp[3] = 16;
        temp[4] = 8;
        temp[5] = 4;
        temp[6] = 2;
        temp[7] = 1;
        byte tmp = (byte)(toBeAdded & temp[((index/8)%8)]);
        if(index/8 < 16)
        {
            System.out.println("test:" + tmp);
        }        
        

        //System.out.println(toBeAdded);
        //toBeAdded =(byte)( toBeAdded << (byte)((tmp%8)));
        //toBeAdded = (byte)(toBeAdded >>> 7);
        //System.out.println(toBeAdded);
        //toBeAdded = (byte)(toBeAdded >>> ((byte)))

        //if(toBeAdded == -1)
        //{
        //    toBeAdded = -128;
        //}
        //System.out.println(original);
        //original  = (byte)(original << 1);
       // System.out.println(original);
        //original = (byte)(original >>> 1);
        if(tmp != 0)
        {
            result = (byte) (original | -128 );
        }
        else 
        {
            result = (byte) (original & 127);
            if(index/8 < 16)
            {
                System.out.println(result);
            }
        }
       // System.out.println(original + " " + toBeAdded + " " +  (byte) (original | toBeAdded));
        return result;
    }

    public byte[] getBytes()
    {
        return compressedFile;
    }
}
