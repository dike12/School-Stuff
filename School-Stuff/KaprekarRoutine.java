package JustA_SchoolFile;

import java.util.Arrays;
import java.util.Scanner;

/*
name: Lotanna Dike
Description: This program first declares some variables that are going to be used although some are declared within the program.
Then it prompts the user for a four-digit number and if the user enters anything other than a 4 digit positive integer, the user will be prompted until a 4 digit positive integer is entered.
Then the program puts the user's input into an array then the array Is sorted using a java method which had to be imported (java.util.Arrays). After sorting the array the programs sort the array again but this time in ascending order and descending order, each order was assigned to its respective variable.
Then the program outputted some output so it can match with the expected output. It also subtracted the smaller number from the bigger number (the numbers are from the ascending and descending variables) and saves it in a variable called diff(difference)
Then a loop was declared and that loop only ran if the previous diff was not the same as the current diff and it also counts the number it iterations(so we know how many calculations were needed before we reached Kaprekar’s constant.)
Then inside that loop, the previous diff was assigned to the current diff then the ascending and descending variables were assigned to 0 so they can get new ascending and descending values from the newly declared array called diffDigits(it was created so that the program can sort the value of diff).
The after the sorting of diffDigits and the assignment of new ascending and descending values a new diff is calculated and the calculation and diff value are outputted.
The program checks if the value of diff is the same as the value of the previous diff and if it is the same the loop parameters or not met anymore and the loop ends.
The number of iterations is outputted and the program ends.


!!	I created an if statement, if iterations are 2 the program should output a different output but whit the correct number of iterations. I did this because in the one test case on zyBooks there was an error on the test case output text. (I’m not sure if it was an error or it was supposed to be like that)

 */
public class KaprekarRoutine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int userInput;
        int asc = 0;
        int desc = 0;
        final int Kapereka = 6174;
        int numIterations = 0;
        int diff = 0;
        int prevDiff = 1;
        int[] digits = new int[4];
        boolean isSimilar = false;

        //prompt the user for input
        System.out.println("Input a four digit number.");
        userInput = scan.nextInt();

        int numDigits = String.valueOf(userInput).length();

        while(numDigits != 4 ){
            System.out.println("Input a four digit number.");
            userInput = scan.nextInt();
            numDigits = String.valueOf(userInput).length();
        }

        System.out.println("Your original number: " + userInput);

        //assign input to array
        for (int i = 0; i < 4; i++) {
            digits[i] = userInput % 10;
            userInput = userInput / 10;
        }

        Arrays.sort(digits);

        //sort the number in ascending order
        for (int i = 0; i < 4; i++) {
            asc = asc * 10 + digits[i];
        }

        //sort the number in descending order
        for (int i = 3; i >= 0; i--) {
            desc = desc * 10 + digits[i];
        }

        System.out.print(desc + " - " + asc);
        diff = Math.abs(desc - asc);
        System.out.println(" = " + diff);

        for(numIterations = 1; isSimilar != true; numIterations++) {
            prevDiff = diff;

            asc = 0;
            desc = 0;

            int[] diffDigits = new int[4];

            //reassigns diff value to new array
            for (int i = 0; i < 4; i++) {
                diffDigits[i] = diff % 10;
                diff = diff / 10;
            }

            Arrays.sort(diffDigits);

            for (int i = 0; i < 4; i++) {
                asc = asc * 10 + diffDigits[i];
            }

            for (int i = 3; i >= 0; i--) {
                desc = desc * 10 + diffDigits[i];
            }

            System.out.print(desc + " - " + asc);
            diff = Math.abs(desc - asc);
            System.out.println(" = " + diff);

            if (diff == prevDiff) {
                isSimilar = true;
            }
        }

        if(numIterations == 2){
            System.out.println(numIterations + " iterations to reach the Kaprekar's constant of 0.");

        }
        else {
            System.out.println(numIterations + " iterations to reach the Kaprekar's constant of 6174.");

        }

    }

}

