public class ThreadManager
{
    WorkHorseThread workThread[];
    ScannerThread scanThread[];
    public ThreadManager(DigitalFile file,CPUInfo info)
    {
        if (file.length() < info.getNumCores())
        {
            workThread = new WorkHorseThread[file.length()];
            scanThread = new ScannerThread[file.length()];
        }
        else
        {
            workThread = new WorkHorseThread[info.getNumCores()];
            scanThread = new ScannerThread[file.length()];
        }
    }

    public int getNumLogicalThreads()
    {
        return workThread.length;
    }
}
