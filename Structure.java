public class Structure
{
                           //Number of bytes seperated 
                           //and number of bytes per core
    public static final int DICEDFILECOUNT = 2;
                            //Number of bytes in each section
    public static final int DICEDFILESECTIONCOUNT[] = 
    {4,8};
                            //A multiplier for the number of "loc=gical"
                            //cores utilised.
    public static final int COREMULTIPLIER = 8;
                            //Constant for type of Structure.
    public static final String DICEDFILE = "DicedFile";

    //All byte sections are stored here.
    private byte sections[][];
    //Total byte length
    private int length;
    //Type of Structure
    private String type;

    public Structure(int numSections,
    int lengthPerSection[],int numCores,String inType)
    {
        length = 0;
        if(numSections == lengthPerSection.length)
        {
            sections = new byte[numSections+numCores][];
            for(int i = 0; i < lengthPerSection.length;i++)
            {
                if(lengthPerSection[i] >= 0)
                {
                    sections[i] = 
                    new byte[lengthPerSection[i]];
                    length += lengthPerSection[i];
                }
                else
                {
                    throw new IllegalArgumentException(
                    "Length of a section was less than zero.");
                }
            }
            for(int i = lengthPerSection.length;
            i < sections.length;i++)
            {
                sections[i] = new byte[COREMULTIPLIER];
            }
            length += (COREMULTIPLIER *numCores);
        }
        else
        {
            throw new IllegalArgumentException(
            "The number of sections and"+
            " the number of section lengths do not match.");
        }
        type = inType;
    }

    public int getLength()
    {
        return length;
    }
}
