
public class Timer
{
    public final static long MILISECOND = 1000000, SECOND  = 1000000000;
    private long constantTime;
    private long time;
    
    public Timer()
    {
        constantTime = System.nanoTime();
        time = System.nanoTime();
    }
    
    public boolean secondPassed()
    {
        boolean passed = false;
        if(time < System.nanoTime()-SECOND)
        {
            System.out.println(System.nanoTime());
            passed = true;
            time += SECOND;
        }
        return passed;
    }
    
    public boolean secondPassed(int inSeconds)
    {
        boolean passed = false;
        if(time < System.nanoTime()-(SECOND * inSeconds))
        {
            passed = true;
            time += SECOND * inSeconds;
        }
        return passed;
    }
    
    public boolean miliSecondPassed(int inMiliSeconds)
    {
        boolean passed = false;
        if(time < System.nanoTime()-(MILISECOND * inMiliSeconds))
        {
            passed = true;
            time += SECOND * inMiliSeconds;
        }
        return passed;
    }
    
    public void ping()
    {
        time = System.nanoTime();
        while(time > (System.nanoTime()-(MILISECOND*20)))
        {
        }
    }
    
    public void ping(int miliSeconds)
    {
        time = System.nanoTime();
        while(time > (System.nanoTime()-(MILISECOND * miliSeconds)))
        {
            
        }
    }
    
    public String toString()
    {
        return "Time elapsed: " + ((constantTime - System.nanoTime()) / SECOND) + "Seconds.";
    }
}
