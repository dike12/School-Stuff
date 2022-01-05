package JustA_SchoolFile;

import java.util.Scanner;

public class ElementsInRange {
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);

        int maxNums = scnr.nextInt();                   // maximum number of elements in an array
        int[] nums = new int[maxNums];
        boolean inRange = false;


        //loop for list of nums
        for (int  i = 0;  i < nums.length;  i++) {
            nums[i] = scnr.nextInt();
        }


        // scan for lower and upper bounds of range
        int lowerBounds = scnr.nextInt();
        int upperBounds = scnr.nextInt();

        // loop through nums array and check for nums in range
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] >= lowerBounds) && (nums[i] <= upperBounds)){
                System.out.print(nums[i] +",");
            }
        }
        System.out.println();

    }
}
