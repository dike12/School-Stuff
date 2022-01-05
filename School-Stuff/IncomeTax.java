package JustA_SchoolFile;

import java.util.Scanner;

public class IncomeTax {
    public static void main (String [] args) {
        final int MAX_ELEMENTS = 10;
        Scanner scnr = new Scanner(System.in);
        int annualSalary;
        double taxRate;
        int taxToPay;
        int totalSalaries;
        int totalTaxes;
        int numSalaries;
        boolean keepLooking;
        int i;

        int []    salaryBase     = { 20000,     50000,     100000,     999999999 };
        double [] taxBase        = {   .10,       .20,        .30,           .40 };
        int []    annualSalaries = new int[MAX_ELEMENTS];
        int []    taxesToPay     = new int[MAX_ELEMENTS];

        numSalaries = 0;

        System.out.println("\nEnter annual salary (0 to exit): ");
        annualSalary = scnr.nextInt();

        while ((annualSalary > 0) && (numSalaries < MAX_ELEMENTS)) {
            i = 0;
            taxRate = 0;
            keepLooking = true;

            // Search for appropriate table row for given annualSalary
            while ((i < salaryBase.length) && keepLooking) {
                if (annualSalary <= salaryBase[i]) {
                    taxRate = taxBase[i];
                    keepLooking = false;
                }
                else {
                    ++i;
                }
            } // End inner while loop (search for appropriate table row)

            taxToPay = (int)(annualSalary * taxRate); // Truncate tax to an integer amount
            annualSalaries[numSalaries] = annualSalary;
            taxesToPay[numSalaries] = taxToPay;

            System.out.println("Annual salary: " + annualSalaries[numSalaries] +
                    "\tTax rate: " + taxRate +
                    "\tTax to pay: " + taxesToPay[numSalaries]);
            ++numSalaries;

            // Get the next annual salary
            if (numSalaries < MAX_ELEMENTS) {
                System.out.println("\nEnter annual salary  (0 to exit): ");
                annualSalary = scnr.nextInt();
            }
        } // End outer while loop (valid annualSalary entered)

        // Sum the annual salaries and taxes to pay and print the totals
        totalSalaries = 0;
        totalTaxes = 0;

        for (i = 0; i < numSalaries; ++i) {
            totalSalaries += annualSalaries[i];
            totalTaxes    += taxesToPay[i];
        }
        System.out.println("\nTotal salaries: " + totalSalaries +
                "\tTotal taxes: " + totalTaxes);
    }
    //or

    /*
    public static void main (String [] args) {
        Scanner scnr = new Scanner(System.in);
        final String PROMPT_SALARY = "\nEnter annual salary (0 to exit): ";
        final String PROMPT_DEDUCTION = "Enter a deduction (0 to end deductions): ";
        int annualSalary;
        int oneDeduction;
        int totalDeductions;
        int adjustedSalary;
        double taxRate;
        int taxToPay;

        System.out.println(PROMPT_SALARY);
        annualSalary = scnr.nextInt();

        while (annualSalary > 0) {
            totalDeductions = 0;    // Start with 0 for each annual salary
            System.out.println(PROMPT_DEDUCTION);
            oneDeduction = scnr.nextInt();

            while (oneDeduction > 0) {
                totalDeductions += oneDeduction;
                System.out.println(PROMPT_DEDUCTION);
                oneDeduction = scnr.nextInt();
            }

            // Determine the tax rate from the adjusted salary
            adjustedSalary = annualSalary - totalDeductions;
            if (adjustedSalary <= 0) {
                adjustedSalary = 0;
                taxRate = 0.0;
            }
            else if (adjustedSalary <= 20000) {
                taxRate = 0.10;   // 0.10 is 10% written as a decimal
            }
            else if (adjustedSalary <= 50000) {
                taxRate = 0.20;
            }
            else if (adjustedSalary <= 100000) {
                taxRate = 0.30;
            }
            else {
                taxRate = 0.40;
            }

            taxToPay = (int)(adjustedSalary * taxRate);  // Truncate tax to an integer amount
            System.out.println("Annual salary: " + annualSalary);
            System.out.println("\nDeductions: " + totalDeductions);
            System.out.println("Adjusted salary after deductions: " + adjustedSalary);
            System.out.println("Tax rate: " + taxRate);
            System.out.println("Tax to pay: " + taxToPay);

            // Get the next annual salary
            System.out.println(PROMPT_SALARY);
            annualSalary = scnr.nextInt();
        }
    }

     */

    //or

    /*
    public static void main (String [] args) {
        Scanner scnr = new Scanner(System.in);
        int annualSalary;
        double taxRate;
        int taxToPay;
        int startingAnnualSalary;
        int endingAnnualSalary;

        annualSalary = 0;
        startingAnnualSalary = 0;   // FIXME: Change the starting salary to 40000
        endingAnnualSalary = 0;     // FIXME: Change the ending salary to 60000

        // FIXME: Use a for loop to calculate the tax for each entry in the table.
        // Hint: the initialization clause is annualSalary = startingAnnualSalary

        // Determine the tax rate from the annual salary
        if (annualSalary <= 0) {
            taxRate = 0.0;
        }
        else if (annualSalary <= 20000) {
            taxRate = 0.10;   // 0.10 is 10% written as a decimal
        }
        else if (annualSalary <= 50000) {
            taxRate = 0.20;
        }
        else if (annualSalary <= 100000) {
            taxRate = 0.30;
        }
        else {
            taxRate = 0.40;
        }

        taxToPay = (int)(annualSalary * taxRate);   // Truncate tax to an integer amount
        System.out.println("Annual salary: " + annualSalary +
                "\tTax rate: " + taxRate +
                "\tTax to pay: " + taxToPay);
        // FIXME: Be sure to include the closing brace for the for loop
    }

     */
}
