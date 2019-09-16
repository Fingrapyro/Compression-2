/**
 * Name: BArnabas Madai
 * FileName: FileIO.java
 * Description: Reads and writes files.
 */
import java.io.*;
public class FileIO
{
    public static boolean isFileExist(String directory)
    {
        File f = new File(directory);
        return (f.exists() && !f.isDirectory());
    }
    
    public static boolean delete(String directory)
    {
        File f = new File(directory);
        return f.delete();
    }
    
    public static String readFile(String directory)
    {
        String text = "";
        String line = null;
        
        try
        {
            FileReader fileReader = new FileReader(directory);
            
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null)
            {
                text += line + "\n";
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Unable to open the file: " + directory);
        }
        catch(IOException e)
        {
            System.out.println("Error reading the file: " + directory);
        }
        return text;
    }

    public static void writeFile(String inFile, String inName)
    {
        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter( new FileWriter( inName));
            writer.write(inFile);
        }
        catch ( IOException e)
        {
        }
        finally
        {
            try
            {
                if ( writer != null)
                    writer.close( );
            }
            catch ( IOException e)
            { 
            }
        }
    }
    
    public static byte[] readByte(String directory)
    {
        InputStream is = null;
        byte buffer[];
        if(isFileExist(directory))
        {
        buffer = new byte[(int)fileSize(directory)];
        char c;
        try 
        {
      
            // new input stream created
            is = new FileInputStream(directory);
         
            // read stream data into buffer
            is.read(buffer);
            is.close();
         }
         catch(Exception e) 
         {
             // if any I/O error occurs
             e.printStackTrace();
         } 
         finally 
         {
         }
         }
         else
         {
             throw new IllegalArgumentException(
             "File does not exist.");
         }
         return buffer;
    }

    public static void writeByte(String directory, byte file[])
    {
        try 
        {
            FileOutputStream fos = new FileOutputStream(directory);
            fos.write(file);
            fos.close();
        }
        catch(IOException e)
        {
            System.out.println("Writing of byte array failed.");
        }
        
    }

    public static void appendByte(String directory, byte file[])
    {
        try 
        {
            FileOutputStream fos = new FileOutputStream(directory,true);
            fos.write(file);
            fos.close();
        }
        catch(IOException e)
        {
            System.out.println("Writing of byte array failed.");
        }
        
    }
 
    public static long fileSize(String directory)
    {
        File f = new File(directory);
        return f.length();
    }
    
    public static void createFile(String directory)
    {
        PrintWriter writer = null;
        try
        {
            writer = new PrintWriter(directory,"UTF-8");
            writer.write("");
            writer.close();
        }
        catch(IOException e)
        {
            writer.close();
        }
        
    }
    
    public static void cmdInput()
    {
        InputStreamReader reader = new InputStreamReader(System.in);
        boolean exit = false;
        while(!exit)
        {
            try
            {
                if(reader.ready())
                {
                    System.out.println(System.in);
                    System.out.println(reader.read()); 
                }
            }
            catch(IOException e)
            {
                
            }
        
            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException ex)
            {
                //whaaaaaaaa...
            }
        }
    }
}
