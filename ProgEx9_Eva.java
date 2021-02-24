import java.util.*;
import java.text.*;

public class ProgEx9_Eva
{
   /**
   * precondition: tally.size() > 0; tally contains Integer objects
   * postcondition: returns the maximal value in tally (that is the
   * largest frequency)
   */
   private static int findMax(ArrayList<Integer> tally)
   {
      int max = 0;
      for (Integer x:tally)
      {
         if(x > max)
            max = x;
      }
      return max;
   }
   
   /**
   * precondition: tally.size() > 0; tally contains Integer objects
   * postcondition: returns an ArrayList that contains the modes(s);
   * the ArrayList's size equals the number of modes.
   */
   public static ArrayList<Integer> calculateModes(ArrayList<Integer> tally)
   {
      int max = findMax(tally);
      ArrayList<Integer> modes = new ArrayList<Integer>();
      for (int i = 0; i < tally.size(); i++)
      {
         if(tally.get(i) == max)
         {
            modes.add(i);
         }
      }
      return modes;  
   }
   
   /**
   * precondition: tally.size() > 0; tally contains Integer objects
   * 0 < k <= total number of values in data collection
   * postcondition: returns the kth value in the data collection
   * represented by tally
   */
   public static int kthDataValue(ArrayList<Integer> tally, int k)
   {
      int sum = 0, index = -1;
      for (int i = 0; i< tally.size(); i++)
      {
         sum += tally.get(i);
         if(sum >= k)
         {
            index = i;
            break;
         }
      }
      return index;
   }
   
   /**
   * precondition: tally.size() > 0; tally contains Integer objects
   * postcondition: returns the number of elements in the data set
   */
   public static int nums(ArrayList<Integer> tally)
   {
      int sum = 0;
      for(Integer x:tally)
         sum += x;
      return sum;
   }
   
   
   /**
   * precondition: tally.size() > 0; tally contains Integer objects
   * postcondition: returns the mean of the data collection
   */
   public static double mean(ArrayList<Integer> tally)
   {
      int sum = 0;
      for(int i = 0; i < tally.size(); i++)
      {
         sum += i*(tally.get(i));
      }
      return (double)sum/nums(tally);
   }
   
   /**
   * precondition: tally.size() > 0; tally contains Integer object
   * postcondition: returns the standard deviation of the data
   * collection
   */
   public static double returnSD(ArrayList<Integer> tally)
   {
      double mean = mean(tally);
      ArrayList<Double> temp = new ArrayList<Double>();
      for(Integer x:tally)
      {
         temp.add(((double)x - mean)*((double)x - mean));
      }
      double sum = 0;
      for(Double y: temp)
         sum += y;
      return Math.sqrt(sum/tally.size());
   }
   
   public static double returnMedian(ArrayList<Integer> tally)
   {
      double median;
      int nums = nums(tally);
      if(nums %2 != 0)
      {
         median = kthDataValue(tally, nums/2 +1);
      }
      else
         median = ((double)kthDataValue(tally, nums/2 +1) + kthDataValue(tally, nums/2)) / 2;
      return median;
   }
   
   
   /**
   * precondition: tally.size() > 0; tally contains Integer objects
   * postcondition: returns the first quartile of the data collection
   */
   public static double returnQ1(ArrayList<Integer> tally)
   {
      ArrayList<Integer> q1 = new ArrayList<Integer>();
      for(int i = 0; i < returnMedian(tally); i++)
      {
         q1.add(tally.get(i));
      }
      return returnMedian(q1);
   }
   
   
   /**
   * precondition: tally.size() > 0; tally contains Integer objects
   * postcondition: returns the third quartile of the data collection
   */
   public static double returnQ3(ArrayList<Integer> tally)
   {
      ArrayList<Integer> q3 = new ArrayList<Integer>();
      for(int i = (int)returnMedian(tally); i < tally.size(); i++)
      {
         q3.add(tally.get(i));
      }
      return returnMedian(tally)+returnMedian(q3);
   }
   
   
   /**
   * precondition: tally.size() > 0; tally contains Integer objects
   * postcondition: prints a histogram of the data collection
   */
   private static void histogram(ArrayList<Integer> tally)
   {
      for(int i = 0; i < tally.size(); i++)
      {
         System.out.print(i + ":");
         for (int j = 0; j < tally.get(i); j++)
            System.out.print("*");
         System.out.println();
      }
   }
   
   //helper sorting method
   private static void sort(ArrayList<Integer> elements) 
          { 
              for (int j = 1; j < elements.size(); j++) 
              { 
                  int temp = elements.get(j); 
                  int possibleIndex = j; 
                  while (possibleIndex > 0 && temp < elements.get(possibleIndex -1))
                  { 
                      elements.set(possibleIndex, elements.get(possibleIndex - 1));
                      possibleIndex--; 
                  } 
                  elements.set(possibleIndex, temp); 
              } 
          }
   
   /**
   * precondition: the ArrayList is not empty and all elements in
   * the array are in the range [0, 59]
   * postcondition: the method prints a stem plot of the data.
   */
   public static void stemPlot(ArrayList<Integer> list)
   {
      sort(list);
      for(int i = 0; i < 6; i++)
      {
         System.out.print(i + " | ");
         for(int j = 0; j < list.size(); j++)
         {
            if (list.get(j) >= 10*(i) && list.get(j) < 10*(i+1))
            {
               System.out.print(list.get(j)%(10) + " ");
            }
         }
         System.out.println();
      }
   }
   
   /**
   *  The main method
   */
   public static void main(String[] arg)
   {
      DecimalFormat df= new DecimalFormat("##.00");
      
      //list for programming exercise test
      ArrayList<Integer> tally = new ArrayList<Integer>();
      tally.add(2);
      tally.add(2);
      tally.add(1);
      tally.add(5);
      tally.add(0);
      tally.add(2);
      tally.add(5);
      tally.add(0);
      tally.add(3);
      
      histogram(tally);
      System.out.println();
      System.out.println("Mean: " + df.format(mean(tally)));
      System.out.println("SD: " + df.format(returnSD(tally)));
      System.out.println("Q1: " + df.format(returnQ1(tally)));
      System.out.println("Median: " + df.format(returnMedian(tally)));
      System.out.println("Q3: " + df.format(returnQ3(tally)));
      System.out.print("Modes: [");
      System.out.print(calculateModes(tally).get(0));
      for(int i = 1; i < calculateModes(tally).size(); i++)
      {
         System.out.print(", " + calculateModes(tally).get(i));
      }
      System.out.print("]");
      System.out.println();
      System.out.println();

      //list for extra-credit method test
      ArrayList<Integer> stemList = new ArrayList<Integer>();
      for(int j = 0; j < 50; j++)
      {
         stemList.add((int)(Math.random()*59));
      }
      stemPlot(stemList);
      
   }

}