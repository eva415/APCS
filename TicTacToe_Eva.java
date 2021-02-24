/**
 * Name: Eva Krueger
 * 
 * This game will allow two people to play tic tac toe
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class TicTacToe_Eva extends JPanel implements ActionListener
{ 
    private int turn=1;//will switch between even and odd to determine turn
    private String[][] pieces; //array that will hold the values, Red or Blue, of each button
    private JButton[][] buttons;
    private int blueWins = 0;
    private int redWins = 0;
    
    //Constructor
    public TicTacToe_Eva()
    {
        setPreferredSize(new Dimension(500,500));
        setLayout(new GridLayout(3,3));
        pieces= new String[3][3];
        buttons = new JButton[3][3];
        for(int i =0; i<3; i++)
        {
            for(int j =0; j<3; j++)
            {
                buttons[i][j] = new JButton(pieces[i][j]);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }
    }
    
    //Clicked method
    public void clicked(int row, int column)
    {
        if(pieces[row][column]!=null)
        {
               JOptionPane.showMessageDialog(null, "that spot is occupied, try again");
        }
        else
        {
               //depending upon whose turn it is, set the color and update any needed counter 
            if(turn%2 == 0)
            {
               pieces[row][column] = "Blue";
               turn++;
            }
            else
            {
               pieces[row][column] = "Red";
               turn++;
            }
            
            
            if(winCheck(row,column)) //is there a winner?
            {
                printWinner();//prints winner
            }
            
            else if(turn==10)  //game over and no winner: it's a tie print out corresponding message
                                //using JOptionPane
            {
               JOptionPane.showMessageDialog(null, "It's a tie");
               JOptionPane.showMessageDialog(null, "Red has won "+ redWins + " times and blue has won " + blueWins + " times.");
               String answer = JOptionPane.showInputDialog("Would you like to play again? (y/n)");
               if(answer.equals("y"))
               {
                  turn = 1;
                  pieces = new String[3][3];
                  repaint();
               }
            }     
        }
    }
    
    /**
     * This method will check to see if anyone has won and return true or false.
     */
    public boolean winCheck(int i, int j)
    {
        for(String[] row:pieces) //checks horizontals
        {
            if (row[0]!= null && row[0].equals(row[1]) && row[0].equals(row[2]))
            {
               return true;
            }
        }
        if(pieces[0][0] != null && pieces[0][0].equals(pieces[1][1]) && pieces[0][0].equals(pieces[2][2]))//check diagonal #1
            return true;
        
        if(pieces[2][0] != null && pieces[2][0].equals(pieces[1][1]) && pieces[2][0].equals(pieces[0][2]))//check diagonal #2
            return true;
        
        for(int vert = 0; vert<3; vert++)//checks verticals
        {
            if(pieces[0][vert] != null && pieces[0][vert].equals(pieces[1][vert]) && pieces[0][vert].equals(pieces[2][vert]))
               return true;
        } 
        return false; 
    }


    /**
     * This method will print out the appropriate message when someone has won. Use JOptionPane      
     */
    public void printWinner()
    {
       if(turn%2 == 0)
       {
         JOptionPane.showMessageDialog(null, "Red wins!");
         redWins++;
       }
       else
       {
         JOptionPane.showMessageDialog(null, "Blue wins!");
         blueWins++;
       }
       JOptionPane.showMessageDialog(null, "Red has won "+ redWins + " times and blue has won " + blueWins + " times.");
       String answer = JOptionPane.showInputDialog("Would you like to play again? (y/n)");
       if(answer.equals("y"))
       {
         turn = 1;
         pieces = new String[3][3];
         repaint();
       }
       
    }
    
/////////////////DO NOT EDIT ANYTHING BELOW HERE///////////////////////////    
    /*
     *This method fires an event when a square (button) is clicked
     */
    public void actionPerformed(ActionEvent event)
    {
        for(int i = 0; i< 3; i++)
        {
           for(int j=0; j<3; j++)
           {
                if(event.getSource() == buttons[i][j])
                {                              
                    clicked(i,j);
                    resetButtons();
                }
           }
        }
    }
    
/*
 * this method restes all the buttons with the correct texts. 
 */    
    public void resetButtons()
    {       
        for(int a =0; a<3; a++)
        {
            for(int b =0; b<3; b++)   
            {
                buttons[a][b].setText(pieces[a][b]);                
                if(pieces[a][b]!=null)
                    if(pieces[a][b].equals("Red"))  
                        buttons[a][b].setForeground(Color.red);
                    else
                        buttons[a][b].setForeground(Color.blue);
                          
            }
        }
        repaint();
    }
    
    public static void main(String[] arg)
    {
      JFrame frame = new JFrame ("TicTacToe");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      
      frame.add(new TicTacToe_Eva());
      frame.pack();
      frame.setVisible(true);
    }
}

