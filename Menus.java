public class Menus
{
    public static void mainMenu(Parvus inParvus)
    {
        String message = 
        "Please select what you want to do.\n"+
        "1) Compress\n"+
        "2) Decompress\n"+
        "3) Test\n"+
        "4) Misc\n"+ 
        "5) Quit";
        int choice = UserInput.inputInteger(1,5,message);
        while(choice != 5)
        {
            switch(choice)
            {
                case 1:
                    inParvus.compress(
                    new Directory(UserInput.inputString(
                    0,255,"Input the name of the file.")));
                    break;
                case 2:
                    inParvus.decompress(
                    new Directory(UserInput.inputString(
                    0,255,"Input the name of the file.")));
                    break;
                case 3:
                    testMenu();
                    break;
                case 4:
                    miscMenu();
                    break;
                default:
                    throw new IllegalArgumentException(
                    "Default triggered in mainMenu. Program terminates");
            }
            choice = UserInput.inputInteger(1,5,message);
        }
    }
    
    public static void testMenu()
    {
        String message = "What would you like to do.\n"+
                         "1) Test Structure\n"+
                         "2) Read/Write Byte\n"+
                         "10) Exit";
        int choice = UserInput.inputInteger(1,10,message);
        while(choice != 10)
        {
            switch(choice)
            {
                case 1:
                    Directory newDirectory = new Directory("test.txt");
                    ThreadManager threadManager = new ThreadManager(
                    new DigitalFile(newDirectory),
                    new CPUInfo());
                    Structure structure= new Structure(
                    Structure.DICEDFILECOUNT,
                    Structure.DICEDFILESECTIONCOUNT,
                    threadManager.getNumLogicalThreads(),
                    Structure.DICEDFILE);
                    break;
                case 2:
                    String directory = UserInput.inputString(
                    0,255,"Input the name of the file.");
                    byte file[] = FileIO.readByte(directory);
                    for(int i = 0; i < file.length;i++)
                    {
                        System.out.println(file[i]);
                    }
                    System.out.println("-");
                    FileIO.writeByte(directory,file);
                    file = FileIO.readByte(directory);
                    for(int i = 0; i < file.length;i++)
                    {
                        System.out.println(file[i]);
                    }
                    break;
                case 3:
                    break;
                default:
                    throw new IllegalArgumentException(
                    "Default triggered in testMenu. Program terminates");
            }
            choice = UserInput.inputInteger(1,10,message);
        }
        System.out.println(
        "Program Terminates.\n"+
        "Have a good day.");
    }
    
    public static void miscMenu()
    {
        String message = "What would you like to do.\n"+
                         "1)  WriteUnique long(s) (Depreciated)\n"+
                         "2)  Bubble sort (Depreciated)\n"+
                         "3)  Calculate differences(Depreciated)\n"+
                         "4)  Base statisics\n"+
                         "5)  Dedicated Ranges. (depreciated)\n"+
                         "6)  Restructure (depreciated)\n"+
                         "7)  Compare \n"+
                         "8)  Trim (depreciated)\n"+
                         "9)  Print out\n"+
                         "10) Generate Ranges\n"+
                         "11) Find Occurrences\n"+
                         "12) UnTrim(depreciated)\n"+
                         "13) Validate Transmutation\n"+
                         "14) CountBitRepeats\n"+
                         "15) CountByteRepeats\n"+
                         "16) QuickSort\n"+
                         "17) input-output range\n"+
                         "18) IntFile test\n"+
                         "19) ByteFile to IntFile\n"+
                         "20) which bit is sig\n"+
                         "30) Exit";
        int choice = UserInput.inputInteger(1,30,message);
        while(choice != 30)
        {
            switch(choice)
            {
                case 1:
                    /*
                    ByteFile byteFile = new ByteFile(
                    Statistic.removeRepeats(new DigitalFile (
                    new Directory("Files/enwik8"))));
                    FileIO.writeByte(
                    "Files/enwik8.RemoveRepetition",
                    byteFile.getBytes());*/
                    break;
                case 2:
                    /*
                    String extension1 = UserInput.inputString(
                    0,255,"Input extension of the file.");
                    long file[] = new LongFile(
                    FileIO.readByte(
                    "Files/enwik8."+extension1))
                    .getLongs();
                    Statistic.sort(file);
                    ByteFile byteFile2 = new ByteFile(file);
                    FileIO.writeByte("Files/enwik8.sort",
                    byteFile2.getBytes());*/
                    break;
                case 3:
                    /*
                    ByteFile byteFile1 = new ByteFile(
                    Statistic.calculateDifferences(new LongFile(
                    FileIO.readByte(
                    "Files/enwik8.sort"))
                    .getLongs()));
                    FileIO.writeByte("Files/enwik8.diff",
                    byteFile1.getBytes());*/
                    break;
                case 4:
                    //extension 3, the extension of the file to be read
                    String extension3 = UserInput.inputString(
                    0,255,"Extension expected to be diff.\n"+
                    "Provide extension:");
                    //stat, the current method of generating range.
                    //To provide stat with the .diff file

                    //Requests number of data to show.
                    Statistic stat = new Statistic(
                    new LongFile(FileIO.readByte(
                    "Files/enwik8." + extension3)).getLongs(),
                    UserInput.inputInteger(
                    0,9999999,"Input the number of recorded entries."));
                    //Writes the ranges file as a string to result.txt
                    FileIO.writeFile(stat.toString(),"Files/result.txt");
                    //Prints stat.toString() out on the terminal 
                    System.out.println(stat.toString());
                    break;
                case 5:
                    /*
                    Trimmer trimmer = new Trimmer(
                    FileIO.readByte("Files/enwik8"),
                    FileIO.readByte("Files/enwik8.sort"));
                    FileIO.writeFile(
                    trimmer.toString(),"Files/enwik8.shortList");*/
                    break;
                case 6:
                    /*
                    Trimmer trimmer1 = new Trimmer(
                    FileIO.readByte("Files/enwik8"),
                    FileIO.readByte("Files/enwik8.sort"));
                    System.out.println(trimmer1.toString());
                    FileIO.writeByte(
                    "Files/enwik8.Restructured",trimmer1.getBytes());*/
                    break;
                case 7:
                    System.out.println(
                    Statistic.compare(
                    FileIO.readByte(
                    UserInput.inputString(
                    0,255,"Input name of the first file.")),
                    FileIO.readByte(
                    UserInput.inputString(
                    0,255,"Input name of the second file."))));
                    break;
                case 8:
                    /*
                    Trimmer trimmer3 = new Trimmer(
                    FileIO.readByte("Files/enwik8"),
                    FileIO.readByte("Files/enwik8.sort"));
                    FileIO.writeByte("Files/enwik8.transmute",
                    trimmer3.getBytes());*/
                    break;
                case 9:
                    String name = UserInput.inputString(
                    0,255,"Input file extension");
                    LongFile longFile = new LongFile(
                    FileIO.readByte("Files/enwik8."+name));
                    for(int i = 0; i < longFile.length();i++)
                    {
                        System.out.println(longFile.get(i));
                    }
                    break;
                case 10:
                    /*
                    Trimmer trimmer4 = new Trimmer(
                    FileIO.readByte("Files/enwik8"),
                    FileIO.readByte("Files/enwik8.sort"));
                    System.out.println(trimmer4.toString());
                    FileIO.writeByte(
                    "Files/enwik8.range",trimmer4.getRange());*/
                    break;
                case 11:
                    String extension = UserInput.inputString(
                    0,255,"Input file extension.");
                    LongFile longFile2 = new LongFile(
                    FileIO.readByte("Files/enwik8."+ extension));
                    
                    System.out.println(ByteManipulator.find(
                    longFile2.getLongs(),
                    UserInput.inputLong(
                    Long.MIN_VALUE,Long.MAX_VALUE,
                    "Input number to find.")));
                    break;
                case 12:
                    //obsolete
                    /*
                    UnTrimmer unTrimmer = new UnTrimmer(
                    new LongFile(FileIO.readByte(
                    "Files/enwik8.transmute")).getLongs(),
                    new LongFile(FileIO.readByte(
                    "Files/enwik8.range")).getLongs());
                    FileIO.writeByte(
                    "Files/enwik8.UnTransmute",unTrimmer.getBytes());
                    */
                    break;
                case 13:
                    System.out.println(
                    ByteManipulator.gCompare(
                    (new LongFile(
                    FileIO.readByte("Files/enwik8"))).getLongs(),
                    (new LongFile(
                    FileIO.readByte("Files/enwik8.UnTransmute"))).getLongs()));
                    break;
                case 14:
                    int result[] = ByteManipulator.countBitRepeats(
                    (new ByteFile(FileIO.readByte("Files/enwik8.transmute"))));
                    System.out.println(ArrayManipulator.display(result));
                    break;
                case 15:
                    int result2[] = ByteManipulator.countByteRepeats(
                    (new ByteFile(FileIO.readByte("Files/enwik8.transmute"))));
                    System.out.println(ArrayManipulator.display(result2));
                    break;
                case 16:
                    Timer timer = new Timer();
                    LongFile longFile5 = new LongFile(
                    FileIO.readByte("Files/enwik8"));
                    Sorts.quickSort(longFile5.getLongs());
                    System.out.println(timer.toString());
                    break;
                case 17:
                    Domain domain = new Domain(
                    FileIO.readByte("Files/enwik8.range"));
                    FileIO.writeByte(
                    "Files/enwik8.rangeNew",domain.getBytes());
                    System.out.println(domain.toString());
                    break;
                case 18:
                    byte bytes[] = new byte[4];
                    IntFile intFile;
                    //maximum
                    bytes[0] = 127;
                    bytes[1] = -1;
                    bytes[2] = -1;
                    bytes[3] = -1;
                    intFile = new IntFile(bytes);
                    System.out.println(intFile.get(0));
                    //minimum
                    bytes[0] = -128;
                    bytes[1] = 0;
                    bytes[2] = 0;
                    bytes[3] = 0;
                    intFile = new IntFile(bytes);
                    System.out.println(intFile.get(0));
                    //largest bit on in the first byte
                    bytes[0] = 0;
                    bytes[1] = 0;
                    bytes[2] = 0;
                    bytes[3] = -128;
                    intFile = new IntFile(bytes);
                    System.out.println(intFile.get(0));
                    //smallest bit on in the largest byte 
                    bytes[0] = 1;
                    bytes[1] = 0;
                    bytes[2] = 0;
                    bytes[3] = 0;
                    intFile = new IntFile(bytes);
                    System.out.println(intFile.get(0));
                    //1
                    bytes[0] = 0;
                    bytes[1] = 0;
                    bytes[2] = 0;
                    bytes[3] = 1;
                    intFile = new IntFile(bytes);
                    System.out.println(intFile.get(0));
                    //0
                    bytes[0] = 0;
                    bytes[1] = 0;
                    bytes[2] = 0;
                    bytes[3] = 0;
                    intFile = new IntFile(bytes);
                    System.out.println(intFile.get(0));
                    System.out.println("length:");
                    int A[] = new int[4];
                    ByteFile byteFile1 = new ByteFile(A.length);
                    intFile = new IntFile(byteFile1.getBytes());
                    System.out.println(intFile.get(0));
                    int integer = 3200;
                    byteFile1 = new ByteFile(integer);
                    intFile = new IntFile(byteFile1.getBytes());
                    System.out.println(intFile.get(0));
                    break;
                case 19:
                    byte tmp5[] = new byte[4];
                    tmp5[0] = 0;
                    tmp5[1] = 0;
                    tmp5[2] = 1;
                    tmp5[3] = 1;
                    IntFile intFile2 = new IntFile(tmp5);
                    System.out.println(intFile2.get(0));
                case 20:
                    LongFile longFile6 = new LongFile(Long.MIN_VALUE);
                    ByteFile byteFile6 = new ByteFile(longFile6.getLongs());
                    for(int i = 0; i < 8;i++)
                    {
                        System.out.println(byteFile6.get(i));
                    }
                    break;
                default:
                    throw new IllegalArgumentException(
                    "Default triggered in miscMenu. Program terminates");
            }
            choice = UserInput.inputInteger(1,30,message);
        }
        System.out.println(
        "Program Terminates.\n"+
        "Have a good day.");
    }

    public void printOutMenu()
    {
        String message = "What would you like to display.\n"+
                         "1) Numbers and byte representations";
    }
}
