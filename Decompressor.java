/***************
*Name: Barnabas Madai
*FileName: Decompressor.java
*Purpose: Decompresses a file.
***************/
public class Decompressor
{
    //Stores a Directory Object, 
    //also stores the file in that location as a byte array.
    DigitalFile file;
    //Differentiates the compressed section and the leftOver
    UnDicedFile unDicedFile;
    //decompresses the data.
    DecompressedFile decompressedFile;
    //removes trimming
    UnTrimmedFile untrimmedFile;

    public Decompressor(Directory inDirectory)
    {
        file = new DigitalFile(inDirectory);
        unDicedFile = new UnDicedFile(file);
        decompressedFile = new DecompressedFile(unDicedFile);
        
        untrimmedFile = new UnTrimmedFile(
        new LongFile(decompressedFile.getBytes()).getLongs(),
        new Domain(unDicedFile.getRange()));

//        System.out.println(
//        new Domain(unDicedFile.getRange()).toString());

        FileIO.writeByte(
        "Files/enwik8.DeCompressed",untrimmedFile.getBytes());
    }
}
