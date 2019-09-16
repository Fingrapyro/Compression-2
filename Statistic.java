/*************
*Name: Barnabas Madai
*File Name: Statistic.java
*Purpose: Stores unnrelated methods, 
*including range prerequisites.
*************/


import java.math.BigInteger;
public class Statistic
{
    long set[];
    
    long max[];
    int maxIndex[];
    
    long min[];
    int minIndex[];
    
    public Statistic(long data[], int numRecord)
    {
        set = data;
        
        max = new long[numRecord];
        maxIndex = new int[numRecord];
       
        min = new long[numRecord];
        minIndex = new int[numRecord];

        if(set.length > 0)
        {
            
            for(int i = 0; i < max.length;i++)
            {
                max[i] = Long.MIN_VALUE;
                maxIndex[i] = 0;
                min[i] = Long.MAX_VALUE;
                minIndex[i] = 0;
            }
            
            long tmp1;
            int tmp2;

            for(int i = 1; i < set.length;i++)
            {
                if(max[max.length-1] < data[i])
                {
                    max[max.length-1] = data[i];
                    maxIndex[max.length-1] = i;
                    for(int a = max.length-1; a > 0;a--)
                    {
                        if(max[a] > max[a-1])
                        {
                            tmp1 = max[a-1];
                            tmp2 = maxIndex[a-1];
                            max[a-1] = max[a];
                            maxIndex[a-1] = maxIndex[a];
                            max[a] =tmp1;
                            maxIndex[a] = tmp2;
                        }
                    }
                }
                if(min[min.length-1] > data[i])
                {
                    min[min.length-1] = data[i];
                    minIndex[min.length-1] = i;
                    for(int a = min.length-1; a > 0;a--)
                    {
                    //    System.out.println("boom");
                        if(min[a] < min[a-1])
                        {
                  //          System.out.println("boom2");
                            tmp1 = min[a-1];
                            tmp2 = minIndex[a-1];
                            min[a-1] = min[a];
                            minIndex[a-1] = minIndex[a];
                            min[a] = tmp1;
                            minIndex[a] = tmp2;
                        }
                    }
                }
                //System.out.println(min[min.length-1] + " " + data[i]);
            }
        }
        else
        {
            throw new IllegalArgumentException(
            "Size of input array must be at least 1.");
        }
    }

    public static void sort(long data[])
    {
        int index = 0;
        long tmp = 0;
        for(int i = 1; i < data.length; i++)
        {
            index = i;
            System.out.println(
            "Sorting index: " + i + " Value: " + data[i]);
            while(index > 0 && data[index] < data[index-1])
            {
                tmp = data[index-1];
                data[index-1] = data[index];
                data[index] = tmp;
                index --;
            }
        }
    }

    public String toString()
    {
        String result = "";
        result += "Largest numbers:";
        for(int i = 0; i < max.length;i++)
        {
            result += "\n      " + max[i] + " Index: "+ maxIndex[i];
        }
        
        result += "\nSmallest numbers:";
        for(int i = 0; i < min.length;i++)
        {
            result += "\n      " + min[i] + " Index: "+ minIndex[i];
        }
        
        result += "\nSum: addition: "+ sum(max).toString();
        result += "\nSum: Take away:"+ sum(min).toString();
        result += "Smallest Max: "+ max[max.length-1];
        return result;
    }

    public long getMax(int index)
    {
        long result = 0;
        if(index < max.length)
        {
            result = max[index];
        }
        else
        {
            throw new IllegalArgumentException(
            "The index provided in Statistic is too large.");
        }
        return result;
    }

    public int getMaxIndex(int index)
    {
        int result = 0;
        if(index < maxIndex.length)
        {
            result = maxIndex[index];
        }
        else
        {
            throw new IllegalArgumentException(
            "The index provided in Statistic is too large.");
        }
        return result;
    }

    public static BigInteger sum(long inSet[])
    {
        BigInteger result = BigInteger.valueOf(0);
        for(int i = 0; i < inSet.length;i++)
        {
            result = result.add(BigInteger.valueOf(inSet[i]));
        }
        return result;
    }

    public static boolean compare(byte A[], byte B[])
    {
        boolean result = true;
        if(A.length == B.length)
        {
            for(int i = 0; i < A.length;i++)
            {
                if(A[i] != B[i])
                {
                    result = false;
                }
            }
        }
        else
        {
            result = false;
        }
        return result;
    }
}
