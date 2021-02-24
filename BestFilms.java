//********************************************************************
//  BestFilms.java       
//
//  Demonstrates the use of a ArrayList object.
//********************************************************************
import java.util.*;

public class BestFilms
{
   //--------------------------------------------------------------------------
   //  Stores and modifies a list of Best Movies from the Oscars
   //--------------------------------------------------------------------------
   public static void main (String[] args)
   {
      ArrayList<String> list = new ArrayList<String>();
      list.add("Parasite");
      list.add("Green Book");
      list.add("The Shape of Water");
               
      //1. Print the list      
      System.out.println(list);
            
      //2. Print the first element of the list
      System.out.println(list.get(0));
            
      //3. Print the size of the list
      System.out.println(list.size());
      
      //4. Add an element to the list, confirm by reprinting the list
      list.add("Moonlight");
       
       System.out.println(list);
        
      //5. Delete the element at index 2, confirm by reprinting the list
       list.remove(2);
       
       System.out.println(list);
      
      //6. Replace the element at index 1, confirm by reprinting the list
       list.set(1, "Spotlight");
       
      System.out.println(list);
      
      //7. Add an element at index 0, confirm by reprinting the list
      list.add(0,"The Shape of Water");
      System.out.println(list);
           
      //8. Print the size of element at index 2
      System.out.println(list.get(2).length());
      
      ArrayList<Integer> numbers = new ArrayList<Integer>();
      numbers.add(-3);
      
      for(String x : list)
      {
         System.out.println(x);
      }
                 
   }
}   
