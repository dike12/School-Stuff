package JustA_SchoolFile;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String userString;                                                           // the string that is to be shifted
        int userShift;                                                             //number of times user wanted letters to be shifted
        boolean outOfRange = true;

        System.out.println("Input a string which contains letters, digits and special characters");
        userString = scan.next();



        System.out.println("Input an integer cipher shift between 1 and 4");
        userShift = scan.nextInt();

        while(outOfRange){
            if(userShift < 1){
                System.out.println("Input an integer cipher shift between 1 and 4");
                userShift = scan.nextInt();
            }
            else if(userShift > 4){
                System.out.println("Input an integer cipher shift between 1 and 4");
                userShift = scan.nextInt();
            }
            else {
                break;
            }
        }



        String cipher = encryption(userString, userShift);


        System.out.print("The original string was: ");
        System.out.println(userString + " and your cipher shift was " + userShift);

        System.out.print("The encrypted string is: ");
        System.out.println(cipher);


    }

    private static String encryption(String userString, int userShift) {
        if (userShift > 26) {                                                        //takes userShift and if it is bigger than 26 it will take it and put it between 0 - 26
            userShift = userShift % 26;
        }
        else if (userShift < 0) {                                                   //takes userShift and if it is smaller than 0 it will take it and put it between 0 - 26
            userShift = (userShift % 26) + 26;
        }

        String cipherText = "";                                                   //final text that is ciphered
        int length = userString.length();                                        // length of the user input text

        for (int i = 0; i < length; i++) {                                      // loop through userString and shift text
            char ch = userString.charAt(i);
            if (Character.isLetter(ch)) {                                         //checks if character is letter because we only want to shift letters
                if (Character.isLowerCase(ch)) {
                    char newChar = (char) (ch + userShift);                         //character or letter is shifted

                    if (newChar >= 'z') {                                            //checks if character is out of bound (goes beyond letter z)
                        cipherText += 26 - userShift;
                    }
                    else {
                        cipherText += newChar;                                      //character is as is if not shifted
                    }
                } else if (Character.isUpperCase(ch)) {
                    char newChar = (char) (ch + userShift);                         //character or letter is shifted

                    if (newChar >= 'Z') {                                            //checks if character is out of bound (goes beyond letter z)
                        cipherText += ch - (26 - userShift);
                    }
                    else {
                        cipherText += newChar;                                      //character is as is if not shifted
                    }
                }
            }
            else {                                                               //if character isn't letter, it is added to the cipherText as it is.
                cipherText += ch;
            }



        }
        return cipherText;
    }
}
