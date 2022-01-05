package JustA_SchoolFile;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        /* Type your code here. */
        Scanner scnr = new Scanner(System.in);

        String forward, backward, moddedForward;

        //scan for input
        forward = scnr.nextLine();

        moddedForward = forward.replace(" ", "");

        // turn input backwards
        backward = "";

        for(int i=  moddedForward.length()-1;i>=0;i--) {
            backward = backward + moddedForward.charAt(i);
        }

        //compare backwards and forwards
        if(moddedForward.equals(backward) == true){
            System.out.println("palindrome: " + forward);
        }
        else{
            System.out.println("not a palindrome: " + forward);
        }

    }
}
