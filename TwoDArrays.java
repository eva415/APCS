/**
 * Practice 2D Arrays
 */
public class TwoDArrays {
    
    public static void main(String[] args) { 
       
        //1. Declare and then fill a 2D array of ints call sums that will hold the following addition table.
        // Use an initializer list.
        //
        //  0 1 2 3
        //  1 2 3 4 
        //  2 3 4 5
        int[][] sums = {{0,1,2}, {1,2,3}, {2,3,4}};
        
        
        //2. Print the array defined above (in a rectangular format). Use for-each nested loops.
        for(int[] col:sums)
        {
            for(int num:col)
            {
               System.out.print(num + " ");
            }
            System.out.println();
        }
        
      
        
        System.out.println(maxSum(sums));
        
        //3.What does each of the following print?  Write your answer first , then test it. If an error is produced, write error.   
        //a.  S.o.p(sums.length); 
         //3
        
        //b.  S.o.p(sums[0].length);
         //4
        
        //c.  S.o.p(sums[0][1].length);
         //error
        
        //d.  S.o.p(sums[2][1]);  
         //3
        
        //e.  S.o.p(sums[1][0]);  
         //1
        
        //f.  S.o.p(sums[3][0]);    
         //error
       
    }
    /*
     * Write the following (static) methods. Test them using the array sums in the main method, and appropiate print calls
     */
    
    //4. A method that will take a 2D array of ints and will return the sum of the elements in the first row.
    //   Try a for-each loop. Call it method1
   public static int method1(int[][] arr)
   {
      int sum = 0;
      for(int num:arr[0])
         sum += num;
      return sum;
   }
    
    
    //5. A method that will take a 2D array of ints and will return the sum of the elements in the first column.
    //   Call it method2
    public static int method2(int[][] arr)
    {
      int sum = 0;
      for(int[] row:arr)
         sum += row[0];
      return sum;
    }
    
         
    //6. A method that will take a 2D array of ints and an integer n and will return true if any of the rows has a sum of n.
    //   Call it method3 
   public static boolean method3(int[][] arr, int n)
   {
      for(int[] row:arr)
      {
         int sum = 0;
         for(int num:row)
         {
            sum += num;
         }
         if(sum == n)
            return true;
      }
      return false;
   }
    
    
    //7. A method that will take a 2D array of ints and an integer n and will return true if any of the columns have a sum of n.  
    //   Call it method4 
   public static boolean method4(int[][] arr, int n)
   {
      for(int col = 0; col < arr[0].length; col++)
      {
         int sum = 0;
         for(int row = 0; row < arr.length; row++)
         {
            sum += arr[row][col];
         }
         if(sum == n)
            return true;
      }
      return false;
   }
    
    
    //8. A method that will take a 2D array of ints and an integer n and will return true if the main diagonal 
    //   has a sum of n.  Assume that the 2D array has the same number of rows and columns. You will need a 'square' 
    //   array to test this method.
    //   Call it method5
   public static boolean method5(int[][] arr, int n)
   {
      int sum = 0;
      for(int i = 0; i < arr.length; i++)
      {
         sum += arr[i][i];
      }
      if(sum == n)
         return true;
      return false;
   }
   
   public static String maxSum(int[][] mat)
   {
      String str = "R";
      int sum = 0;
      int row = 0, col = 0;
      
      for(int e = 0; e < mat.length; e++)
         sum += mat[0][e];
      
      for(int i = 1; i < mat.length; i++)
      {
         int newSum = 0;
         for(int j = 0; j < mat[i].length; j++)
         {
            newSum += mat[i][j];
         }
         if(newSum > sum)
         {
            sum = newSum;
            str = "R";
            row = i;
         }
      }
      
      for(int k = 0; k < mat[0].length; k++)
      {
         int colSum = 0;
         for(int m = 0; m < mat.length; m++)
         {
            colSum += mat[m][k];
         }
         if(colSum > sum)
         {
            sum = colSum;
            str = "C";
            col = k;
         }
      }
      
      if(str.equals("R"))
         return str + row;
      else
         return str + col;
      
   }


      
}
