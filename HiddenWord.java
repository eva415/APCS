public class HiddenWord
{
   private String word;
   
   public HiddenWord(String w)
   {
      word = w;
   }
   
   public String getHint(String guess)
   {
      String returnWord = "";
      for(int i = 0; i < word.length(); i++)
      {
         if(guess.substring(i,i+1).equals(word.substring(i,i+1)))
         {
            returnWord += guess.substring(i,i+1);
         }
         
         else if(word.indexOf(guess.substring(i,i+1)) != -1)
            returnWord += "+";
         else
            returnWord += "*";
      }
      return returnWord;
   }
   
   public static void main(String[] args)
   {
      HiddenWord puzzle = new HiddenWord("HARPS");
      System.out.println(puzzle.getHint("AAAAA"));
      System.out.println(puzzle.getHint("HELLO"));
      System.out.println(puzzle.getHint("HEART"));
      System.out.println(puzzle.getHint("HARMS"));
      System.out.println(puzzle.getHint("HARPS"));
   }
   
}