package main.java.oop_classes_objects.assignment_problem;
import java.util.Scanner;
class VotingEligibility {
    public static void checkVotingEligibility(int age) {
        boolean isEligible = age >= 18;
        if (isEligible) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        checkVotingEligibility(age);
        scanner.close();
    }
}