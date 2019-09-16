/***************
*Name: Barnabas Madai
*FileName: ByteFile.java
*Purpose, recieves an array of int or long 
*and transforms it to an array of byte
***************/
public class ByteFile
{
    byte file[];
    public ByteFile(long inFile[])
    {
        if(inFile.length * 8 > 0)
        {
            int index = 0;
            file = new byte[inFile.length*8];
            for(int i = 0; i < (inFile.length);i++)
            {
                byte tmp[] = longToBytes(inFile[i]);
                for(int a = 0; a < 8; a++)
                {
                    file[(i*8)+a]= tmp[a];
                }
                index +=8;
            }
        }
        else
        {
            throw new IllegalArgumentException(
            "Length of long array is too large in ByteFile.");
        }
    }

    public ByteFile(int inFile)
    {
        file = intToBytes(inFile);
    }

    public ByteFile(byte inFile[])
    {
        file = inFile;
    }

    public int length()
    {
        return file.length;
    }

    public byte get(int index)
    {
        byte result = 0;
        if(index < file.length)
        {
            result = file[index];
        }
        else
        {
            throw new IllegalArgumentException(
            "Index was too high for ByteFile.");
        }
        return result;
    }
    
    public byte[] getBytes()
    {
        return file;
    }

    public static byte[] longToBytes(long l) 
    {
        byte[] result = new byte[8];
        for (int i = 7; i >= 0; i--) 
        {
            result[i] = (byte)(l & 0xFF);
            l >>= 8;
        }
        return result;

        /*return new byte[] {
               (byte)(value >>> 56),
               (byte)(value >>> 48),
               (byte)(value >>> 40),
               (byte)(value >>> 32),
               (byte)(value >>> 24),
               (byte)(value >>> 16),
               (byte)(value >>> 8),
               (byte)(value)};*/
    }


    public static byte[] intToBytes(int value)
    {
        return new byte[] {
               (byte)(value >>> 24),
               (byte)(value >>> 16),
               (byte)(value >>> 8),
               (byte)(value)};
    }

/*  public static byte[] intToBytes(int l) 
    {
        byte[] result = new byte[4];
        for (int i = 3; i >= 0; i--) 
        {
            result[i] = (byte)(l & 0xFF);
            l >>= 4;
        }
        return result;
    }*/
}
