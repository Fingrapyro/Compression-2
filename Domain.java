/*************
*Name: Barnabas Madai
*FileName: Domain.java
*Purpose: generates, stores and manipulates an array of Range Objects.
*************/
import java.math.BigInteger;
public class Domain
{
    Range range[];

    public Domain(RepetitionRemovedFile repetitionRemovedFile)
    {
        long data[] = repetitionRemovedFile.getData();
        long differences[] = calculateDifferences(data);
        Statistic stat = new Statistic(differences,200);
        range = new Range[200];
        for(int i = 0;i < range.length;i++)
        {
            range[i] = new Range(
            data[stat.getMaxIndex(i)],data[stat.getMaxIndex(i)+1]);
        }
        sort();
    }

    public Domain(byte inRanges[])
    {
        LongFile longFile = new LongFile(inRanges);
        range = new Range[longFile.length()/2];
        for(int i = 0; i < range.length;i++)
        {
            range[i] = new Range(
            longFile.get(i*2),longFile.get((i*2)+1));
        }
    }

    public long[] calculateDifferences(long trimmedFile[])
    {
        long differences[] = new long[trimmedFile.length-1];
        for(int i = 0 ; i < trimmedFile.length-1;i++)
        {
            if((trimmedFile[i] < 0 && trimmedFile[i+1] < 0) ||
            (trimmedFile[i] > 0 && trimmedFile[i+1] > 0))
            {
                differences[i] = trimmedFile[i+1]-trimmedFile[i];
            }
            else
            {
                differences[i] = Math.abs(trimmedFile[i])+
                Math.abs(trimmedFile[i+1]);
            }
        }
        return differences;
    }

    public void sort()
    {
        int index = 0;
        boolean found = false;
        Range tmp;

        for(int i = 1;i < range.length;i++)
        {
            index = i;
            while(index > 0 && !(found))
            {
                if(range[index].getStart() < range[index-1].getStart())
                {
                    tmp = range[index-1];
                    range[index-1] = range[index];
                    range[index] = tmp;
                    index--;
                }
                else
                {
                    found = true;
                }
            }
            found = false;
        }
    }


    public long getStart(int index)
    {
        return range[index].getStart();
    }

    public long getFinish(int index)
    {
        return range[index].getFinish();
    }

    public long getDifference(int index)
    {
        return range[index].getDifference();
    }

    public int length()
    {
        return range.length;
    }

    public String toString()
    {
        String result = "";
        for(int i = 0; i < range.length;i++)
        {
            result += range[i].toString() + "\n";
        }
        return result;
    }

    public byte[] getBytes()
    {
        byte result[];
        result = new byte[range.length*16];
        byte tmp[];
        int index = 0;
        for(int i = 0;i < range.length;i++)
        {
            tmp = range[i].getBytes();
            for(int a = (index*16); a < ((index*16)+16);a++)
            {
                result[a] = tmp[a-(index*16)];
            }
            index ++;
        } 
        return result;
    }

    public String getScope()
    {
        BigInteger bigInteger = BigInteger.valueOf(0);
        for(int i = 0; i < range.length; i++)
        {
            bigInteger = 
            bigInteger.add(BigInteger.valueOf(
            range[i].getDifference()));
        }
        return bigInteger.toString();
    }
}
