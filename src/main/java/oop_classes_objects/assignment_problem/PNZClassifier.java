package main.java.oop_classes_objects.assignment_problem;
import java.util.Scanner;
class NumberClassifier{
    public static void classifyNumber(int number){
        if (number > 0){
            System.out.println("Positive");
        }
        else if (number < 0){
            System.out.println("Negative");
        }
        else{
            System.out.println("Zero");
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer number: ");
        int number = scanner.nextInt();
        classifyNumber(number);
        scanner.close();
    }
}