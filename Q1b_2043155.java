import java.util.*;

class MagicSquare {
    private int[][] arr;
    private int n, moves;

    // creates a 2D sqaure matrix of size len
    public MagicSquare(int len) {
        n = len;
        moves = 0;
        arr = new int[n][n];

    }

    // helper function to create magic square
    public void createMagicSquare() {
        // initializes the matrix to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = 0;
            }
        }
        int i = n / 2;
        int j = n - 1;
        for (int num = 1; num <= n * n;) {
            if (i == -1 && j == n) {
                j = n - 2;
                i = 0;
            } else {
                if (j == n)
                    j = 0;

                if (i < 0)
                    i = n - 1;
            }
            if (arr[i][j] != 0) {
                j -= 2;
                i++;
                continue;
            } else
                arr[i][j] = num++;
            j++;
            i--;
        }
    }

    public int getMoves() {
        return moves;
    }

    // repeats n*n times to shuffle the array randomly
    public void shuffleMagicSquare() {
        Random rand = new Random();
        for (int i = 0; i < n * n; i++) {
            int a = rand.nextInt(n);
            int b = rand.nextInt(n);
            int c = rand.nextInt(n);
            int d = rand.nextInt(n);
            while (a == b || c == d) {
                a = rand.nextInt(n);
                b = rand.nextInt(n);
                c = rand.nextInt(n);
                d = rand.nextInt(n);
            }
            int temp = arr[a][b];
            arr[a][b] = arr[c][d];
            arr[c][d] = temp;
        }
    }

    // prints magic square
    public void displayMagicSquare() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // used to swap position i and j in given direction
    public void swap(int i, int j, String direction) {
        if (direction.equals("R")) {
            if (j + 1 == n) {
                System.out.println("You chose the rightmost point.");
            } else {
                int temp = arr[i][j];
                arr[i][j] = arr[i][j + 1];
                arr[i][j + 1] = temp;
                moves++;
            }
        } else if (direction.equals("U")) {
            if (i - 1 == 0) {
                System.out.println("You chose the topmost point.");
            } else {
                int temp = arr[i][j];
                arr[i][j] = arr[i - 1][j];
                arr[i - 1][j] = temp;
                moves++;
            }
        } else if (direction.equals("L")) {
            if (j - 1 == 0) {
                System.out.println("You chose the leftmost point.");
            } else {
                int temp = arr[i][j];
                arr[i][j] = arr[i][j - 1];
                arr[i][j - 1] = temp;
                moves++;
            }
        } else if (direction.equals("D")) {
            if (i + 1 == n) {
                System.out.println("You chose the bottomost point.");
            } else {
                int temp = arr[i][j];
                arr[i][j] = arr[i + 1][j];
                arr[i][j] = temp;
                moves++;
            }
        }
    }

    // main function to check the code
    public static void main(String args[]) {
        System.out.print("Enter size of Magic Square (odd number): ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        MagicSquare m = new MagicSquare(size);
        m.createMagicSquare();
        System.out.println("Magic Square of size " + size + " is created.");
        m.displayMagicSquare();

        System.out.println("Magic Square after shuffling:");
        m.shuffleMagicSquare();
        m.displayMagicSquare();
        int moves = 0;
        while (true) {
            System.out.println("Choose to continue or to exit. ");
            System.out.println("1. Enter position (i, j) in 0-index and a direction(U,R,L,D): ");
            System.out.println("2. Exit ");
            System.out.print("Choice: ");
            String choice = sc.next();
            if (choice.equals("1")) {
                int i, j;
                String direction;
                i = sc.nextInt();
                j = sc.nextInt();
                direction = sc.next();
                m.swap(i, j, direction);
            } else {
                System.out.println("\nTotal Moves = " + m.getMoves() + "\nThanks for playing!");
                break;
            }
            System.out.println("After swapping:");
            m.displayMagicSquare();
        }

    }
};