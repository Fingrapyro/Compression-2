/****************
*Name: Barnabas Madai
*File Name: Compressor.java
*Purpose: Perorms all compression related tasks, 
          including the actual compression.
****************/

public class Compressor
{
    //Stores a Directory Object, 
    //also stores the file in that location as a byte array.
    DigitalFile file;
    //Cuts off and seperately stores any byte needed to be seperated
    //for the file to be divisible by 64, a requirement.
    DicedFile dicedFile;
    //Performs all prerequisites prior to trimming
    Analyzer analyzer;
    //Trimms the file.
    TrimmedFile trimmedFile;
    //Compressed the file (to 63/64) of its current size.
    CompressedFile compressedFile;
    public Compressor(Directory inDirectory)
    {
        file = new DigitalFile(inDirectory);
        dicedFile = new DicedFile(file);
        analyzer = new Analyzer(dicedFile);
        trimmedFile = new TrimmedFile(dicedFile,analyzer);
        compressedFile = new CompressedFile(trimmedFile);
        FileIO.writeByte("Files/enwik8.compressed",compressedFile.getBytes());
        FileIO.appendByte(
        "Files/enwik8.compressed",(new ByteFile(
        file.length)).getBytes());
        FileIO.appendByte("Files/enwik8.compressed",
        dicedFile.getLeftOver());
        FileIO.appendByte("Files/enwik8.compressed",
        (new ByteFile(dicedFile.getLengthLeftOver()).getBytes()));

//        System.out.println(new Domain(analyzer.getDomain()).toString());

        FileIO.appendByte("Files/enwik8.compressed",
        analyzer.getDomain());
        FileIO.appendByte("Files/enwik8.compressed",
        (new ByteFile( (((analyzer.getDomain()).length)) ).getBytes()));
        /*for(int i = 0; i < 1000; i++)
        {
            file = new DigitalFile(new Directory("Files/enwik8.compressed"));
            dicedFile = new DicedFile(file);
            analyzer = new Analyzer(dicedFile);
            compressedFile = new CompressedFile(dicedFile,analyzer);
            FileIO.writeByte("Files/enwik8.compressed",compressedFile.getBytes());
            FileIO.appendByte("Files/enwik8.compressed",dicedFile.getLeftOver());
            FileIO.appendByte("Files/enwik8.compressed",
            (new ByteFile(dicedFile.getLengthLeftOver()).getBytes()));
        }*/
    }
}

//Removed TransmutedFile completely as it is not needed
//CPUInfo may be needed in future, currently not relevant
//ThreadManager may be needed in the futue, currently not relevant.
//Consequently ScannerThread and WorkHorseThread are obsolete.
