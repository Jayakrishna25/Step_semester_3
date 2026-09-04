package main.java.oop_classes_objects.assignment_problem;
import java.util.Scanner;
class PrimeChecker {
    public static void checkPrime(int number){
        boolean isPrime = true;
        if (number <= 1) {
            isPrime = false;
        }
        for (int i=2;i<=number/2;i++){
            if(number % i == 0){
                isPrime = false;
                break;
            }
        }
        if(isPrime){
            System.out.println("Prime");
        }
        else{
            System.out.println("Not Prime");
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer greater than 1: ");
        int number = scanner.nextInt();
        checkPrime(number);
        scanner.close();
    }
}
