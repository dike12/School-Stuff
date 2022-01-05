package JustA_SchoolFile;

import java.util.Scanner;

public class OutputNumbersInReverse {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int numElements = scnr.nextInt();   // Input begins with number of integers that follow

        int[] userList = new int[numElements];   // List of numElement integers specified by the user

        // Add more variables as needed
        int tempVal;


        /* Type your code here. */
        for (int i = 0; i < numElements; i++) {    // scans the integers into array
            userList[i] = scnr.nextInt();
        }

        for (int i = 0; i < (numElements / 2); i++) {            // reversing loop
            tempVal = userList[i];                               // store first value
            userList [i] =  userList[userList.length - 1 - i];   // assign first value to last
            userList[userList.length - 1 - i] = tempVal;         // assign last value to first value
        }

        for (int i = 0; i < numElements; i++) {
            System.out.print(userList[i] + ",");
        }
        System.out.println();
    }
}
