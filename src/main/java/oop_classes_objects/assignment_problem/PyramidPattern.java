package main.java.oop_classes_objects.assignment_problem;
import java.util.Scanner;
class NumberPyramid{
    public static void printNumberPyramid(int n){
        for (int i=1;i<=n;i++){
            for (int j=1;j<=i;j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        printNumberPyramid(n);
        scanner.close();
    }
}