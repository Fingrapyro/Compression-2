/*****************************************************
*  StudentName: Barnabas Madai
*  FileName: UserInput.java
*  Purpose: Stores methods to get input from the user.
********************************************************/
import java.util.*;
public final class UserInput
{
   //asks for an input, will validate it to be 
   //inbetween inMin and inMax, once valid, will return it.
   public static int inputInteger(int inMin, int inMax, 
                                       String inPrompt)
   {
      int number = inMin;
      //Due to potential of a default value being within inMin
      //and inMax inclusive. The validation is done in two 
      //steps. Otherwise,if the try catch fails, but the def 
      //value sufficient to exit the while loop, the user never
      //really made a choice, but the def value was read in 
      //anyway.
      boolean isInitialised = false;
      Scanner sc = new Scanner(System.in);
      //The only way isInitialised becomes true is it we can
      //give (any) numeric value to number. Validation of 
      //that number occurs later.
      while(!(isInitialised))
      {
         try
         {
            // the message the user will see.
            System.out.println(inPrompt);
            //parseInt triggers NumberFormatException if 
            //cannot be converted to number.
            number = Integer.parseInt(sc.next());
            isInitialised = true;
         }
         catch(NumberFormatException e)
         {
            System.out.println(e.getMessage() + 
                               " is not valid.\n"+
                               "Must be numeric without a "+
                               "decimal place.\n"+
                               "Please provide an answer"+
                               " again.\n");
         }
      }
      //Now that number has been given a value by the user
      //, we are validating it being the correct range.
      //If not the same process applies as before. If input
      //is valid, this while loop never triggers.
      while(number < inMin || number > inMax)
      {
         try
         {
            System.out.println("Incorrect input.\n"+ 
                              "Must be between "+inMin+" and "+
                              inMax+".\n"+
                              "Please try again.\n");
            System.out.println(inPrompt);

            number = Integer.parseInt(sc.next());
         }
         catch(NumberFormatException e)
         {
            System.out.println(e.getMessage() + 
                               " is not valid.\n"+
                               "Must be numeric without a"+ 
                               "decimal place. \n"+
                               "Please provide an answer"+
                               " again.");
         }
      }
   return number;
   }
   
   //asks for an input, will validate it to be 
   //inbetween inMin and inMax, once valid, will return it.
   public static long inputLong(long inMin, long inMax, 
                                       String inPrompt)
   {
      long number = inMin;
      //Due to potential of a default value being within inMin
      //and inMax inclusive. The validation is done in two 
      //steps. Otherwise,if the try catch fails, but the def 
      //value sufficient to exit the while loop, the user never
      //really made a choice, but the def value was read in 
      //anyway.
      boolean isInitialised = false;
      Scanner sc = new Scanner(System.in);
      //The only way isInitialised becomes true is it we can
      //give (any) numeric value to number. Validation of 
      //that number occurs later.
      while(!(isInitialised))
      {
         try
         {
            // the message the user will see.
            System.out.println(inPrompt);
            //parseInt triggers NumberFormatException if 
            //cannot be converted to number.
            number = Long.parseLong(sc.next());
            isInitialised = true;
         }
         catch(NumberFormatException e)
         {
            System.out.println(e.getMessage() + 
                               " is not valid.\n"+
                               "Must be numeric without a "+
                               "decimal place.\n"+
                               "Please provide an answer"+
                               " again.\n");
         }
      }
      //Now that number has been given a value by the user
      //, we are validating it being the correct range.
      //If not the same process applies as before. If input
      //is valid, this while loop never triggers.
      while(number < inMin || number > inMax)
      {
         try
         {
            System.out.println("Incorrect input.\n"+ 
                              "Must be between "+inMin+" and "+
                              inMax+".\n"+
                              "Please try again.\n");
            System.out.println(inPrompt);

            number = Long.parseLong(sc.next());
         }
         catch(NumberFormatException e)
         {
            System.out.println(e.getMessage() + 
                               " is not valid.\n"+
                               "Must be numeric without a"+ 
                               "decimal place. \n"+
                               "Please provide an answer"+
                               " again.");
         }
      }
   return number;
   }
   //asks for an input, will validate it to be 
   //inbetween inMin and inMax, once valid, will return it.
   public static int inputInteger(int inMin, int inMax, 
                        boolean isInc, String inPrompt)
   {
      int number = inMin;
      //Due to potential of a default value being within inMin
      //and inMax inclusive. The validation is done in two 
      //steps. Otherwise,if the try catch fails, but the def 
      //value sufficient to exit the while loop, the user never
      //really made a choice, but the def value was read in 
      //anyway.
      boolean isInitialised = false;
      Scanner sc = new Scanner(System.in);
      //The only way isInitialised becomes true is it we can
      //give (any) numeric value to number. Validation of 
      //that number occurs later.
      while(!(isInitialised))
      {
         try
         {
            // the message the user will see.
            System.out.println(inPrompt);
            //parseInt triggers NumberFormatException if 
            //cannot be converted to number.
            number = Integer.parseInt(sc.next());
            isInitialised = true;
         }
         catch(NumberFormatException e)
         {
            System.out.println(e.getMessage() + 
                               " is not valid.\n"+
                               "Must be numeric without a "+
                               "decimal place.\n"+
                               "Please provide an answer"+
                               " again.\n");
         }
      }
      //Now that number has been given a value by the user
      //, we are validating it being the correct range.
      //If not the same process applies as before. If input
      //is valid, this while loop never triggers.
      if(isInc)
      {
         while(number < inMin || number > inMax)
         {
            try
            {
               System.out.println("Incorrect input.\n"+ 
                              "Must be between "+inMin+" and "+
                              inMax+".\n"+
                              "Please try again.\n");
               System.out.println(inPrompt);
               number = Integer.parseInt(sc.next());
            }
            catch(NumberFormatException e)
            {
               System.out.println(e.getMessage() + 
                               " is not valid.\n"+
                               "Must be numeric without a"+ 
                               "decimal place. \n"+
                               "Please provide an answer"+
                               " again.");
            }
         }
      }
      else
      {
          while(number <= inMin || number >= inMax)
         {
            try
            {
               System.out.println("Incorrect input.\n"+ 
                              "Must be between "+inMin+" and "+
                              inMax+".\n"+
                              "Please try again.\n");
               System.out.println(inPrompt);
               number = Integer.parseInt(sc.next());
            }
            catch(NumberFormatException e)
            {
               System.out.println(e.getMessage() + 
                               " is not valid.\n"+
                               "Must be numeric without a"+ 
                               "decimal place. \n"+
                               "Please provide an answer"+
                               " again.");
            }
         }
      }
      return number;
   }

   //Will not compile if number is not initialised.
   //The validation is done in two step, asking for input first.
   //To assure the initialisation is not within inMin and inMax.
   //Will return a double. After initialisation and validation 
   //is complete.
   //A valid double has to be inbetween inMin and inMax,
   //inclusive.
   public static double inputDouble(double inMin, double inMax,
                                               String inPrompt)
   {
      double number = inMin;
      //due to potential of a default value being within inMin
      //and inMax inclusive. The validation is done in two 
      //steps. Otherwise, if the try catch fails, but the def
      //value sufficient to exit the while loop, the user never
      //really made a choice, but was read in anyway.
      boolean isInitialised = false;
      Scanner sc = new Scanner(System.in);
      while(!(isInitialised))
      {
         try
         {
            // the message the user will see.
            System.out.println(inPrompt);
            //parseDouble trhows a NumberFormatException
            //if cannot convert sc.next to double
            number = Double.parseDouble(sc.next());
            isInitialised = true;
         }
         catch(NumberFormatException e)
         {
            System.out.println(e.getMessage() + 
                               " is not valid.\n"+
                               "Must be numeric.\n"+
                               "Please provide an answer"+
                               " again.");
         }
      }
      //Validation begins now that the user has given a valid 
      //value.
      while(number < inMin || number > inMax)
      {
         try
         {
            System.out.println(  "Incorrect input.\n"+
                              "Must be between " + inMin + 
                              "\n" +
                              "and " + inMax + ". \n" +
                              "Please try again.");
            System.out.println(inPrompt);

            number = Double.parseDouble(sc.next());
         }
         catch(NumberFormatException e)
         {
            System.out.println(e.getMessage() + 
                               " is not valid.\n"+
                               "Must be numeric.\n"+
                               "Please provide an answer"+
                               " again.");
         }
      }
      return number;
   }

   //Will not compile if number is not initialised.
   //The validation is done in two step, asking for input first.
   //To assure the initialisation is not within inMin and inMax.
   //Will return a double. After initialisation and validation 
   //is complete.
   //A valid double has to be inbetween inMin and inMax,
   //exclisvity or inc is decided by isInc.
   public static double inputDouble(double inMin, double inMax,
                                boolean isInc, String inPrompt)
   {
      double number = inMin;
      //due to potential of a default value being within inMin
      //and inMax inclusive. The validation is done in two 
      //steps. Otherwise, if the try catch fails, but the def
      //value sufficient to exit the while loop, the user never
      //really made a choice, but was read in anyway.
      boolean isInitialised = false;
      Scanner sc = new Scanner(System.in);
      while(!(isInitialised))
      {
         try
         {
            // the message the user will see.
            System.out.println(inPrompt);
            //parseDouble trhows a NumberFormatException
            //if cannot convert sc.next to double
            number = Double.parseDouble(sc.next());
            isInitialised = true;
         }
         catch(NumberFormatException e)
         {
            System.out.println(e.getMessage() + 
                               " is not valid.\n"+
                               "Must be numeric.\n"+
                               "Please provide an answer"+
                               " again.");
         }
      }
      //Validation begins now that the user has given a valid 
      //value.
      if(isInc)
      {
         while(number < inMin || number > inMax)
         {
            try
            {
               System.out.println(  "Incorrect input.\n"+
                              "Must be between " + inMin + 
                              "\n" +
                              "and " + inMax + ". \n" +
                              "Please try again.");
               System.out.println(inPrompt);
               number = Double.parseDouble(sc.next());
            }
            catch(NumberFormatException e)
            {
               System.out.println(e.getMessage() + 
                               " is not valid.\n"+
                               "Must be numeric.\n"+
                               "Please provide an answer"+
                               " again.");
            }
         }
      }
      else
      {
          while(number <= inMin || number >= inMax)
         {
            try
            {
               System.out.println(  "Incorrect input.\n"+
                              "Must be between " + inMin + 
                              "\n" +
                              "and " + inMax + ". \n" +
                              "Please try again.");
               System.out.println(inPrompt);
               number = Double.parseDouble(sc.next());
            }
            catch(NumberFormatException e)
            {
               System.out.println(e.getMessage() + 
                               " is not valid.\n"+
                               "Must be numeric.\n"+
                               "Please provide an answer"+
                               " again.");
            }
         }
      }
      return number;
   }


   //Will input a string then validates it to be inbetween 
   //inMin and inMax inclusive.
   //Once valid, will return it to the caller.
   public static String inputString(int inMin, int inMax, 
                                         String inPrompt)
   {
      String value;
      System.out.println(inPrompt);
      Scanner sc = new Scanner(System.in);
      value = sc.next();
      while(value.length() < inMin || value.length() > inMax)
      {
         System.out.println("Invalid length. Must be between "+
                            "\n" +
                            inMin + " and " + inMax + "\n"+ 
                            "Please try again.");
         System.out.println(inPrompt);
         value = sc.next();
      }
      return value;
   }
   
      //Will input a string then validates it to be inbetween 
   //inMin and inMax inclusive.
   //Once valid, will return it to the caller.
   public static String inputString(int inMin, int inMax, 
                          boolean isInc, String inPrompt)
   {
      String value;
      System.out.println(inPrompt);
      Scanner sc = new Scanner(System.in);
      value = sc.next();
      if (isInc)
      {
         while(value.length() < inMin || value.length() > inMax)
         {
            System.out.println("Invalid length."+
                               " Must be between\n" +
                               inMin + " and " + inMax + "\n"+
                               "Please try again.");
            System.out.println(inPrompt);
            value = sc.next();
         }
      }
      else
      {
         while(value.length() <= inMin || value.length() >= inMax)
         {
            System.out.println("Invalid length."+
                               " Must be between\n" +
                               inMin + " and " + inMax + "\n"+
                               "Please try again.");
            System.out.println(inPrompt);
            value = sc.next();
         }
      }
      return value;
   }
   
   //Will requrest a char from the user.
   //Will reutrn the first char in the string input by the user.
   public static char inputChar(String inPrompt)
   {
      char value;
      System.out.println(inPrompt);
      Scanner sc = new Scanner(System.in);
      value = sc.next().charAt(0);
      return value;
   }
}
