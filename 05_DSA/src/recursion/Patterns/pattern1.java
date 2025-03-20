package Patterns;

//****
//***
//**
//*

public class pattern1 {

    public static void printPattern(int row, int col) {
//        base case
        if (row == 0) {
            return;
        }


        if (row > col) {
            System.out.print("* ");
            printPattern(row, ++col);
        } else {
            System.out.println();
            printPattern(--row, 0);
        }
    }

    public static void main(String[] args) {
        printPattern(4, 0);
    }
}
