package lt.aidaspupelis.videoPoker;

import java.util.Scanner;

public class VideoPoker {


    public static void main(String[] args) {

        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        String playAgain = "Y";

        while (playAgain.equals("Y")) { //as long as the user wants to keep playing

            game.play();

            System.out.println();
            System.out.println("Would you like to play again?(Y - yes / N - no)");
            playAgain = scanner.nextLine().toUpperCase(); //string entered determines if we play or break out of loop
        }

        System.out.println("Thank you for playing!");

    }

}
