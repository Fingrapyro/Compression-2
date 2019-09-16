public class CPUInfo
{
    private int numCores;
    public CPUInfo()
    {
        numCores = Runtime.getRuntime().availableProcessors();
        if(numCores < 1)
        {
            throw new IllegalArgumentException(
            "Incorrect number of cores. Cannot be less than 1");
        }
    }

    public int getNumCores()
    {
        return numCores;
    }
}
