import java.io.*;
import java.util.*;

public class Q1a_2043155{
    
    static void MagicSquare(int i)
    {
        int[][] Square = new int[i][i];
 
        //Initialising position 1
        int p = i / 2;
        int q = i - 1;
 
        //Putting values in magic square
        for (int num = 1; num <= i * i;) {
            if (p == -1 && q == i) 
            {
                q = i - 2;
                p = 0;
            }
            else {
                if (q == i)
                    q = 0;
 
                
                if (p < 0)
                    p = i - 1;
            }
 
            if (Square[p][q] != 0) {
                q -= 2;
                p++;
                continue;
            }
            else
                Square[p][q] = num++;
 
            q++;
            p--;
        }
 
        //Printing the magic square
        System.out.println("The number you entered for magic square is " +i);
        System.out.println("Sum of each row or column is "
                           + i * (i * i + 1) / 2 + ":");
        for (p = 0; p < i; p++) {
            for (q = 0; q < i; q++)
                System.out.print(Square[p][q] + " ");
            System.out.println();
        }
    }
 
    public static void main(String[] args)
    {
        int i;
        System.out.println("Enter the odd number for magic square");
        Scanner sc = new Scanner(System.in);
        i = sc.nextInt();
        MagicSquare(i);
    }
}