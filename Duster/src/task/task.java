package task;
import java.util.Scanner;
import java.util.Random;
public class task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the start of the range: ");
        int start = scanner.nextInt();

        System.out.print("Enter the end of the range: ");
        int end = scanner.nextInt();

        int randomNumber = random.nextInt(end - start + 1) + start;

        System.out.print("Guess the number: ");
        int guess = scanner.nextInt();

        if (guess == randomNumber) {
            System.out.println("Correct guess!");
        } else {
            System.out.println("Guessed wrong! The correct number was: " + randomNumber);
        }

        scanner.close();
    }
}


