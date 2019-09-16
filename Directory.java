import java.io.File;
public class Directory
{
    File location;
    public Directory(String inLocation)
    {
        location = new File(inLocation);
        if(!(location.exists()))
        {
            throw new IllegalArgumentException(
            "File does not exists");
        }
    }

    public String toString()
    {
        return location.toString();
    }
}
