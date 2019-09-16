public class DigitalFile
{
    Directory location;
    byte data[];
    int length;    
    public DigitalFile(Directory inDirectory)
    {
        location = inDirectory;
        data = FileIO.readByte(location.toString());
        length = data.length;
    }

    public int length()
    {
        return length;
    }

    public byte[] getBytes()
    {
        return data;
    }
}
