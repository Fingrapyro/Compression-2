public class Analyzer
{
    LongFile longFile;
    SortedFile sortedFile;
    RepetitionRemovedFile repetitionRemovedFile;
    Domain domain;
    TrimmedFile trimmedFile;

    public Analyzer(DicedFile file)
    {
        longFile = new LongFile(file.getUtilised());
        System.out.println(longFile.length());
        sortedFile = new SortedFile(
        longFile.getLongs());

        repetitionRemovedFile = new RepetitionRemovedFile(
        new LongFile(sortedFile.getData()));

        domain = new Domain(
        repetitionRemovedFile);

//        trimmedFile = new TrimmedFile(
//        longFile.getLongs(),domain);
        System.out.println(domain.getScope());
    }

/*    public byte[] getTrimmed()
    {
        return trimmedFile.getByte();
    }*/

    public byte[] getDomain()
    {
        long ranges[];
        ranges = new long[domain.length()*2];
        for(int i = 0; i < ranges.length/2;i++)
        {
            ranges[i*2] = domain.getStart(i);
            ranges[(i*2)+1] = domain.getFinish(i);
        }
        System.out.println("length:" + ranges.length);
        System.out.println("Another test:" + (new ByteFile(ranges).getBytes().length));
        return (new ByteFile(ranges)).getBytes();
    }
}
