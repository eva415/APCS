/**
 * Sorting algorithms
 */

import javax.swing.*;

public class Sort {
    
      ////////Selection Sort - from left to right//////////////////
      /**
      * Sort an array of integers into ascending order.
      * @param elements an array containing the items to be sorted.
      * Postcondition:  elements contains its original items and items in elements
      *                  are sorted in ascending order.
      */
          public static void selectionSort(int[] elements)
          {
              for (int j = 0; j < elements.length -1; j++)
              {
                  //let minIndex be the index that holds the current minimum
                  int minIndex = j;
                  for (int k = j + 1; k < elements.length; k++)
                  {
                      if (elements[k] < elements[minIndex])
                          minIndex = k;
                  }
                  int temp = elements[j];
                  elements[j] = elements[minIndex];
                  elements[minIndex] = temp;
              }
          }
      
       ////////Selection Sort - from right to left//////////////////
      /**
      * Sort an array of integers into ascending order.
      * @param elements an array containing the items to be sorted.
      * Postcondition:  elements contains its original items and items in elements
      *                  are sorted in ascending order.
      */
          
          public static void selectionSort2(int[] elements)
          {
              for (int j = elements.length - 1; j >= 0 ; j--)
              {
                  //let maxIndex be the index that holds the current max
                  int maxIndex = j;
                  
                  for ( int k = j - 1; k >= 0; k-- )
                  {
                      if (elements[k] > elements[maxIndex])
                          maxIndex = k;
                  }
                  int temp = elements[maxIndex];
                  elements[maxIndex] = elements[j];
                  elements[j] = temp ;
              }
          }

//sorts array from Left to Right in Descending order
          public static void selectionSort3(int[] elements)
          {
            for (int j = 0; j < elements.length - 1 ; j++)
              {
                  //let maxIndex be the index that holds the current max
                  int maxIndex = j;
                  
                  for (int k = j + 1; k < elements.length; k++)
                  {
                      if (elements[k] > elements[maxIndex])
                          maxIndex = k;
                  }
                  int temp = elements[maxIndex];
                  elements[maxIndex] = elements[j];
                  elements[j] = temp ;
              }
          }

//sorts array from Right to Left in Descending order
          public static void selectionSort4(int[] elements)
          {
            for (int j = elements.length-1; j > 0 ; j--)
              {
                  //let maxIndex be the index that holds the current max
                  int minIndex = j;
                  
                  for (int k = j - 1; k >= 0; k--)
                  {
                      if (elements[k] < elements[minIndex])
                          minIndex = k;
                  }
                  int temp = elements[minIndex];
                  elements[minIndex] = elements[j];
                  elements[j] = temp ;
              }
          }
          
          //sorts array of strings in alphabetical orger
          public static void stringSort(String[] elements)
          {
            for (int j = 0; j < elements.length - 1 ; j++)
              {
                  //let maxIndex be the index that holds the current max
                  int minIndex = j;
                  
                  for (int k = j + 1; k < elements.length; k++)
                  {
                      if (elements[k].compareTo(elements[minIndex])<0)
                          minIndex = k;
                  }
                  String temp = elements[minIndex];
                  elements[minIndex] = elements[j];
                  elements[j] = temp ;
              }
          }
          
          
         //////////Insertion Sort - starting at the beginning////////////        
         /** 
          * Sort an array of integers into ascending order. 
          * @param elements an array containing the items to be sorted. 
          * Postcondition: elements contains its original items and items in elements 
          * are sorted in ascending order. 
          */ 
          public static void insertionSort(int[] elements) 
          { 
              for (int j = 1; j < elements.length; j++) 
              { 
                  int temp = elements[j]; 
                  int possibleIndex = j; 
                  while (possibleIndex > 0 && temp < elements[possibleIndex -1])
                  { 
                      elements[possibleIndex] = elements[possibleIndex - 1];
                      System.out.println("Possible element: " + temp);
                      possibleIndex--; 
                  } 
                  elements[possibleIndex] = temp; 
              } 
          }
          
         //////////Insertion Sort - starting at the end////////////        
         /** 
          * Sort an array of integers into ascending order. 
          * @param elements an array containing the items to be sorted. 
          * Postcondition: elements contains its original items and items in elements 
          * are sorted in ascending order. 
          */ 
          
          public static void insertionSort2(int[] elements) 
          { 
              for (int j = elements.length - 2; j >= 0; j--) 
              { 
                  int temp = elements[j]; 
                  int possibleIndex = j; 
                  while (possibleIndex < elements.length - 1 && temp > elements[possibleIndex + 1])
                  { 
                      elements[possibleIndex] = elements[possibleIndex+1]; 
                      possibleIndex++; 
                  } 
                  elements[possibleIndex] = temp; 
              }     
          }

//sorts ints from the beginning in descending order
          public static void insertionSort3(int[] elements)
          {
            for(int j = 1; j < elements.length; j++)
            {
               int temp = elements[j];
               int possibleIndex = j;
               while(possibleIndex > 0 && temp > elements[possibleIndex - 1])
               {
                  elements[possibleIndex] = elements[possibleIndex - 1];
                  possibleIndex--;
               }
               elements[possibleIndex] = temp;
            }
          }

//sorts ints from the end in descending order
          public static void insertionSort4(int[] elements)
          {
            for(int j = elements.length - 2; j >= 0; j--)
            {
               int temp = elements[j];
               int possibleIndex = j;
               while(possibleIndex < elements.length - 1 && temp < elements[possibleIndex + 1])
               {
                  elements[possibleIndex] = elements[possibleIndex + 1];
                  possibleIndex--;
               }
               elements[possibleIndex] = temp;
            }
          }
          
          
 /////////Main Method/////////////////////////////////////         
          public static void main(String[] args) 
          { 
              
              int length = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of an array (multiple of 10): "));
              int[] arr = new int[length];
              
              for(int i = 0; i < arr.length;)
              {
                  int newNum = (int)(Math.random()*length) + 1;
                  boolean working = true;
                  for(int num:arr)
                  {
                     if(newNum == num)
                        working = false;
                  }
                  if(working)
                  {
                     arr[i] = newNum;
                     i++;
                  }
              }
              
              for(int j = 0; j < length/10; j++)
              {
                  for(int t = 0; t < 10; t++)
                  {
                     System.out.print(String.format("%4d", arr[10*j + t]));
                  }
                  System.out.println();
              }
              
              System.out.println();
              insertionSort3(arr);
              
               for(int k = 0; k < length/10; k++)
              {
                  for(int s = 0; s < 10; s++)
                  {
                     System.out.print(String.format("%4d", arr[10*k + s]));
                  }
                  System.out.println();
              }
               // int[] arr;
//                int n = 10000;
//                for(int i = 0; i < 10; i++)
//                {
//                   arr = new int[n];
//                   for(int num:arr)
//                   {
//                      num = (int)(Math.random()*10)+1;
//                   }
//                   long startTime = System.currentTimeMillis();
//                   insertionSort(arr);
//                   long endTime = System.currentTimeMillis();
//                   System.out.println(endTime - startTime);
//                   n += 10000;
//                }
          }
          
}
