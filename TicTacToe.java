
/*
# Tic-Tac-Toe Game By Bishal- How to Play:

1. **Setup**:
   - Enter Player 1 and Player 2 names.
   - Player 1 uses `0` (O), and Player 2 uses `1` (X).

2. **Input**:
   - Enter a 3-digit number: `VRC` (Value, Row, Column).
     - `V`: `0` (Player 1) or `1` (Player 2).
     - `R`: Row (0-2).
     - `C`: Column (0-2).
   - Example: `001` places a `0` in row 0, column 1.

3. **Win Conditions**:
   - Get three markers in a row, column, or diagonal to win.
   - If the board is full and no one wins, it's a draw.

4. **Restart**:
   - After a game ends, type `yes` to play again or `no` to exit.

5. **Invalid Input**:
   - Ensure valid input (e.g., empty spots, correct format). Errors prompt a retry.

Enjoy the game!
*/
import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("To Play this game.You need to type 3 digit number.1st digit will be 0 or 1 ");
        String[] username = {"user1","user2"};
        System.out.println("Enter Player 1 name:");
        username[0]=sc.nextLine();
        System.out.println("Enter Player 2 name:");
        username[1]=sc.nextLine();
        boolean playAgain = false;
        while(!playAgain)
        {
            int[][] array = {{9,9,9},{9,9,9},{9,9,9}};
            boolean flag = false,user = false,win=false;
            int val=0,row=0,col=0;
            printArray(array);
            while(!flag)
            {
                if(!win)
                {
                    while(!user)
                    {
                    System.out.print(username[0] + ": ");
                    String input = sc.nextLine();
                    if (input.length() == 3 && input.matches("\\d+")) 
                    {
                        val = Character.getNumericValue(input.charAt(0));
                        row = Character.getNumericValue(input.charAt(1));
                        col = Character.getNumericValue(input.charAt(2));
                    }
                    else if(input.length()>3)
                    {
                        System.out.println("Enter 3 digit numbers that include only 0,1,2");
                        printArray(array);
                        continue;
                    }
                    else
                    {
                        System.out.println("Enter 3 digit numbers that include only 0,1,2");
                        printArray(array);
                        continue;
                    }
                    if(val == 0 && row >= 0 && row < 3 && col >= 0 && col < 3)
                    {
                        if(array[row][col]==9)
                        {
                            array[row][col]=val;
                            user = true;
                        }
                        else
                        {
                            System.out.println("Position Already Taken!Try Again...");
                            continue;
                        }
                    }
                    else
                    {
                        if(val==1)
                        {
                            System.out.println("You can use only 0 for your turn");
                            printArray(array);
                        }
                        System.out.println("Invalid Input!Try Again");
                        continue;
                    }
                    printArray(array);
                    if (checkWin(array)) 
                    {
                        System.out.println("Congratulations! " + username[0] + " won the game.");
                        flag = true;
                        win = true;
                        break;
                    }
                    else
                    {
                        if(!checkArray(array))
                        {
                            System.out.println("It,s a Draw.Wanna Play Again...?");
                            flag = true;
                            win = true;
                        }
                    }
                    }
                }
                if(!win)
                {
                    while(user)
                    {
                        System.out.print(username[1] + ": ");
                        String input = sc.nextLine();
                        if (input.length() == 3 && input.matches("\\d+")) 
                        {
                            val = Character.getNumericValue(input.charAt(0));
                            row = Character.getNumericValue(input.charAt(1));
                            col = Character.getNumericValue(input.charAt(2));
                        }
                        else if(input.length()>3)
                        {
                            System.out.println("Enter 3 digit numbers that include only 0,1,2");
                            printArray(array);
                            continue;
                        }
                        else
                        {
                            System.out.println("Enter 3 digit numbers that include only 0,1,2");
                            printArray(array);
                            continue;
                        }
                        if(val == 1 && row >= 0 && row < 3 && col >= 0 && col < 3)
                        {
                            if(array[row][col]==9)
                            {
                                array[row][col]=val;
                                user = false;
                            }
                            else
                            {
                                System.out.println("Position Already Taken!Try Again...");
                            }
                        }
                        else
                        {
                            if(val==0)
                            {
                                System.out.println("You can use only 1 for your turn");
                                printArray(array);
                            }
                            System.out.println("Invalid Input!Try Again");
                            continue;
                        }
                        printArray(array);
                        if (checkWin(array)) 
                        {
                            System.out.println("Congratulations! " + username[1] + " won the game.");
                            flag = true;
                            win=true;
                            break;
                        }
                        else
                        {
                            if(!checkArray(array))
                            {
                                System.out.println("Opps...It,s a Draw");
                                flag = true;
                                win = true;
                            }
                        }
                    }
                }
            }
            System.out.println("Do you want to play again? (yes/no): ");
            String check = sc.nextLine();
            if(check.toLowerCase().equals("yes"))
            {
                continue;
            }
            else if(check.toLowerCase().equals("no"))
            {
                playAgain = true;
            }
        }
        sc.close();
    }
    public static boolean checkWin(int[][] array) {
        for (int i = 0; i < 3; i++) {
            if (array[i][0] == array[i][1] && array[i][1] == array[i][2] && array[i][0] != 9) {
                return true;
            }
            if (array[0][i] == array[1][i] && array[1][i] == array[2][i] && array[0][i] != 9) {
                return true;
            }
        }
        if ((array[0][0] == array[1][1] && array[1][1] == array[2][2] && array[0][0] != 9) ||
            (array[0][2] == array[1][1] && array[1][1] == array[2][0] && array[0][2] != 9)) {
            return true;
        }
        return false;
    }
    public static boolean checkArray(int[][] array)
    {
        boolean check=false;
        for(int[] row:array)
        {
            for(int element:row)
            {
                if(element==9)
                {
                    check=true;
                }
            }
        }
        return check;
    }
    
    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                if (element == 9) {
                    System.out.print("|   ");
                } else if (element == 0) {
                    System.out.print("| O ");
                } else {
                    System.out.print("| X ");
                }
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

}
