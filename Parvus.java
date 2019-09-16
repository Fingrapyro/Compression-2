public class Parvus
{
    Compressor compressor;
    Decompressor decompressor;

    public Parvus()
    {
        Menus.mainMenu(this);
    }

    public void compress(Directory inDirectory)
    {
        compressor = new Compressor(inDirectory);
    }

    public void decompress(Directory inDirectory)
    {
        decompressor = new Decompressor(inDirectory);
    }
}
