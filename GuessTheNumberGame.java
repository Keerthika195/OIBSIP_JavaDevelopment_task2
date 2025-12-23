import java.util.*;
public class GuessTheNumberGame {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    int maxNumber = 100;
    int maxAttempts = 7;
    public static void main(String[] args) {
        GuessTheNumberGame game = new GuessTheNumberGame();
        game.startGame();
    }

    void startGame() {
        System.out.println("NUMBER GUESSING GAME");
        boolean playAgain = true;
        while (playAgain) {
            playOneRound();
            System.out.print("Do you want to play again? (yes/no): ");
            String ans = scanner.next().trim().toLowerCase();
            if (!ans.equals("yes")) {
                playAgain = false;
            }
        }
        System.out.println("Thanks for playing!");
    }

    void playOneRound() {
        int secretNumber = random.nextInt(maxNumber) + 1; // 1 to 100
        int attempts = 0;
        boolean guessed = false;
        System.out.println("\nI have chosen a number between 1 and " + maxNumber + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");
        while (attempts < maxAttempts && !guessed) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == secretNumber) {
                System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                int points = calculatePoints(attempts);
                System.out.println("Your score for this round: " + points + " points.");
                guessed = true;
            } else if (guess < secretNumber) {
                System.out.println("Too low! Try a higher number.");
            } else {
                System.out.println("Too high! Try a lower number.");
            }
        }
        if (!guessed) {
            System.out.println("\nYou have used all attempts.");
            System.out.println("The correct number was: " + secretNumber);
            System.out.println("Score for this round: 0 points.");
        }
    }
    int calculatePoints(int attempts) {
        if (attempts == 1) return 100;
        if (attempts <= 3) return 70;
        if (attempts <= 5) return 50;
        if (attempts <= maxAttempts) return 30;
        return 0;
    }
}
