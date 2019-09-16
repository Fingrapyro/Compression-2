public class Metadata
{
    //stores the different sections and their lengths 
    //of the metadata
    private Structure structure;

    public Metadata(byte file[], ThreadManager manager)
    {
        structure = new Structure(
        Structure.DICEDFILECOUNT,
        Structure.DICEDFILESECTIONCOUNT,
        manager.getNumLogicalThreads(),
        Structure.DICEDFILE);
    }
}
