/*************
*Name: Barnabas Madai
*FileName: DecompressedFile.java
*Purpose: Generates and stores the decompressed file.
*************/
public class DecompressedFile
{
    //the decompresed file
    byte decompressedFile[];
    //the domain used to get decompressedFile
    Domain domain;

    public DecompressedFile(UnDicedFile inFile)
    {
        //getting compressed file from inFile
        byte tmp[] = inFile.getUtilised();
        //Getting leftOver.
        byte tmp1[] = inFile.getLeftOver();
        //Size of decompressed file.
        int deCompressedSize = inFile.getOriginalLength();
        //generating the ranges utilised in this compression
        domain = new Domain(inFile.getRange());

        //setting decompressedFile to the larger size
        decompressedFile = new byte[deCompressedSize];
        System.out.println(deCompressedSize + "d");
        //setting the first 63 out of 64 bytes of decompressedFile
        //effectively copying tmp
        for(int i = 0; i < tmp.length;i++)
        {
            decompressedFile[i] = tmp[i];
        }
        //iterates for each decompressedFile element, 
        //but that is not the complete story
        for(int i = 0; i < decompressedFile.length;i++)
        {
            if(i%8 == 0)
            {
                //System.out.println(decompressedFile[i]);
                decompressedFile[tmp.length+(i/64)] = seperate(
                decompressedFile,i,tmp.length);
                //System.out.println(decompressedFile[i]);
            }
        }
    }

    private byte seperate(byte set[], int index,int length)
    {
        //returned byte to the destination, 
        //done so eight times per tmp byte and decompressed byte.
        byte result = 0;
        //strange logic
        byte[] terms = new byte[8];
        //setting number to the appropriste 'length'
        terms[0] = -128;
        terms[1] = 64;
        terms[2] = 32;
        terms[3] = 16;
        terms[4] = 8;
        terms[5] = 4;
        terms[6] = 2;
        terms[7] = 1;
        //the temporary storage and manipulation of the recovered data 
        byte tmpByte;
        //getting just the last bit in the tmp section
        //System.out.println(set[index] & terms[0]);
        tmpByte = (byte)(set[index] & terms[0]);
        //setting it to the correct index within the byte

        if(index/8 <16)
        {
            System.out.println("test:"+tmpByte);
        }

        //tmpByte = (byte)(tmpByte >>> (byte)(((index /8)% 8) ));
        //adding it to the existing byte.
        //System.out.println(tmpByte);
        if(tmpByte == -128)
        {
            result =(byte) (decompressedFile[length+(index/64)] | terms[
            ((index/8)%8)]);
        }
        else
        {
            result = decompressedFile[length+(index/64)];
        }
        //System.out.println(result);
        //System.out.println(((index/8)%8));

        //number = "" + (index%8);
        //result = ((byte) set[(index)] 
        //(original &  (byte)(toBeAdded & terms[0]/(10*(number.length()-1))]));
        //this logic is not confirmed, to be verified.
        //Kind of verified
        //System.out.println(set[index]);
        set[index] = (byte)(set[index] | terms[0]);
        //System.out.println(set[index]);
        return result;
    }

    public byte[] getBytes()
    {
        return decompressedFile;
    }
}
