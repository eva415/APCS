public class APLine
{
   private int a, b, c;
   
   public APLine(int aa, int bb, int cc)
   {
      a = aa;
      b = bb;
      c = cc;
   }
   
   public double getSlope()
   {
      return ((-1)*(double)a)/b;
   }
   
   public boolean inOnLine(int x, int y)
   {
      return (a*x + b*y + c == 0);
   }
   
}