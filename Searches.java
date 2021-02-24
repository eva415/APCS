public class Searches
{
   public static int sequentialSearch(int[] array, int value)
   {
      for (int i=0; i<array.length; i++)
      {
         if (array[i] == value)
            return i;
      }
      
      return -1;
   }
   
   public static int sequentialSearch(String[] array, String str)
   {
      for (int i=0; i<array.length; i++)
      {
         if (array[i].equals(str))
            return i;
      }
      
      return -1;
   }
   
   // precondition: array must be sorted in ascending order
   public static int binarySearch(int[] array, int value)
   {
      int low = 0;
      int high = array.length - 1;
      int middle = (low+high)/2;
      
      while (low < high && array[middle] != value)
      {
         if (value > array[middle])
            low = middle + 1;
         else
            high = middle - 1;
         
         middle = (low+high)/2;   
      }
      
      if (array[middle] == value)
         return middle;
      else
         return -1;
   }
   
   // precondition: array is sorted in descending order
   public static int binarySearch2(int[] array, int value)
   {
      int low = 0;
      int high = array.length - 1;
      int middle = (low+high)/2;
      
      while (low < high && array[middle] != value)
      {
         if (value > array[middle])
            high = middle-1;
         else
            low = middle+1;
            
         middle = (low+high)/2;
      }
      
      if (array[middle]==value)
         return middle;
      else
         return -1;
   }
   
   // precondition: array must be sorted in ascending order
   public static int binarySearch3(int[] array, int value)
   {
      int low = 0;
      int high = array.length - 1;
      int middle = (low+high)/2;
      
      while (low < high && array[middle] !=value)
      {
         if (value > array[middle])
            low = middle + 1;
         else
            high = middle - 1;
         
         middle = (low+high)/2;   
      }
      
      if (array[middle]==value)
         return middle;
      else
      {
         int i=0;
         
         if (value > array[array.length-1] || value < array[0])
            return -1 * array.length;
         else
         {
            while (array[i] <= value)
            {
               i++;
            }
            
            return -1*i;
         }
      }
   }
   
   // precondition: array is sorted in alphabetical order
   public static int binarySearchString(String[] array, String key)
   {
      int low = 0;
      int high = array.length - 1;
      int middle = (low+high)/2;
      
      while ( low < high && !(array[middle].equals(key)) )
      {
         if (key.compareTo(array[middle]) > 0)
            low = middle + 1;
         else
            high = middle - 1;
         
         middle = (low+high)/2;   
      }
      
      if (array[middle].equals(key))
         return middle;
      else
         return -1;
   }
   
   public static void main(String[] args)
   {
      int[] nums = {2, 6, 7, 8, 9, 10, 23};
      System.out.println(sequentialSearch(nums, 23));
      System.out.println(binarySearch(nums, 23));
      System.out.println(sequentialSearch(nums, 30));
      System.out.println(binarySearch(nums, 30));
      
      String[] words = {"egg","toast","plate"};
      System.out.println(sequentialSearch(words, "toast"));
      System.out.println(sequentialSearch(words, "bean"));
      
      int[] nums2 = {23, 10, 9, 8, 7, 6, 2};
      System.out.println(binarySearch2(nums, 8));
      System.out.println(binarySearch2(nums, 3));
      
      System.out.println();
      String[] letters = {"a","b","c","d","e","f","g"};
      System.out.println(binarySearchString(letters, "e"));
      System.out.println(binarySearchString(letters, "h"));
      
      System.out.println();
      int[] nums3 = {-2,3,4,10,13};
      System.out.println(binarySearch3(nums3,5));
      System.out.println(binarySearch3(nums3,4));
      System.out.println(binarySearch3(nums3,14));
      System.out.println(binarySearch3(nums3,-4));
   }
}