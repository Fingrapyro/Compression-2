public class ArrayManipulator
{
    public static String display(int A[])
    {
        String result = "";
        for(int i = 0; i < A.length;i++)
        {
            result += "Index: " + i + "Value: " + A[i] + "\n";
        }
        return result;
    }
}
