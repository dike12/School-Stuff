package JustA_SchoolFile;


import java.util.Scanner;

public class SoccerTeamRoster {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] players = new int[5][2];
        boolean keepRunning = true;
        char userInput;

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter player " + (i + 1) + "'s jersey number:");
            players[i][0] = scan.nextInt();
            System.out.println("Enter player " + (i + 1) + "'s rating:");
            players[i][1] = scan.nextInt();
            System.out.println();
        }

        //Outputs roster
        outputRoster(players, 0);

        //checks for menu input
        while (keepRunning) {
            menu();
            userInput = scan.next().charAt(0);

            if (userInput == 'q') {                                  // stops the program if user inputs q (Quit)
                keepRunning = false;
                break;
            }
            else if (userInput == 'o') {                            // outputs roster if user entered o (Output)
                outputRoster(players, 0);
            }
                        else if (userInput == 'u') {                // updates player rating if user entered u (update)
                System.out.println("Enter Jersey number: ");
                int JerseyNum = scan.nextInt();                     // enter player jersey number
                System.out.println("Enter a new rating for the player:  ");
                int newRating = scan.nextInt();                    //enter new rating for the player

                for (int i = 0; i < 5; i++) {                       // loops to check for user enter jersey number
                    if(players[i][0] == JerseyNum){                 // only executes if the jersey number is matched
                        players[i][1] = newRating;                  // assigns new rating to player
                    }
                }
            }
            else if(userInput == 'a'){                              // outputs players with a rating above a certain level
                System.out.println("Enter a rating: ");
                int wantedRatings = scan.nextInt();                    // get wanted rating from user

                outputRoster(players, wantedRatings);               // tells the output roster method to give it player with a certain rating an above
            }
            else if(userInput == 'r'){                              // replaces a certain player if user enters r (replace)
                System.out.println("Enter jersey number of the player to replace: ");
                int replacingPlayer = scan.nextInt();                  //gets jersey number of player that is to be replaced

                for (int i = 0; i < 5; i++) {
                    if(players[i][0] == replacingPlayer){
                        System.out.println("Enter new jersery number: ");
                        players[i][0] = scan.nextInt();                     //gets new player jersey number
                        System.out.println("Enter new player rating: ");
                        players[i][1] = scan.nextInt();                        // gets new player rating
                    }
                }
            }
        }
    }

    //the output method
    private static void outputRoster(int[][] players, int userNumInput) {
        if(userNumInput > 0){
            System.out.println("ABOVE " + userNumInput);
        }
        else{
            System.out.println("ROSTER");
        }

        int playerNum = 1;
        for(int[] player : players){
            if(player[1] > userNumInput){
                System.out.println("Player " + playerNum + " -- Jersey number: " + player[0] + ", Rating: " + player[1]);
            }
            playerNum++;
        }
        System.out.println();
    }

    //outputs menu options
    private static void menu(){
        System.out.println("MENU");
        System.out.println("u - Update player rating");
        System.out.println("a - Output players above a rating");
        System.out.println("r - Replace player");
        System.out.println("o - Output roster");
        System.out.println("q - Quit");
        System.out.println();
        System.out.println("Choose an option:");


    }
}
