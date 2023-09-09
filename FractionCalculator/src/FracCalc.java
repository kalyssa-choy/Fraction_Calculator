import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

/**
 * A class that has the produceAnswer method
 * @author ckalyssa
 */
public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation

        Scanner in = new Scanner(System.in);

        //prompts the user to input a fraction equation and prints the answer
        while (true)
        {
            System.out.println("Enter your fraction equation (Ex. 1_1/2 + 2_1/2) or type quit to exit the program: ");
            String equation = in.nextLine();
            String myFrac2 = produceAnswer(equation);
            System.out.println(myFrac2);
            if (equation.equals("quit"))
            {
                break;
            }
        }

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"


    /**
     * @param input the fraction equation
     * @return resultF the final answer
     * method returns the final answer of the fraction equation given by the user
     */
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
        Scanner myScan = new Scanner(input);
        myScan.useDelimiter(" ");
        String frac1 = myScan.next();
        String opperator = myScan.next();
        String frac2 = myScan.next();
        //validating opperator 
        String validOpperators = "+-/*";
        /**
         * checks to see if the operand is a +, -, /, or *
         * @throws InputMismatchException if the operator is not +, -, /, or *
         */
        if (!validOpperators.contains(opperator))
        {
            throw new InputMismatchException("This is not a valid operator. Please use +, -, /, or *.");
        }

        // for scanning fraction 1
        Scanner frac1Scan = new Scanner(frac1);

        int whole1 = 0;
        int numerator1 = 1;
        int denominator1 = 1;

        /**
         * checks to see if the fraction has a whole
         * checks to see if the denominator is valid and not 0
         * @throws InputMismatchException if the denominator is equal to 0
         */
        if (frac1.contains("_"))
        {
            frac1Scan.useDelimiter("_");
            whole1 = frac1Scan.nextInt();
            String fFrac = frac1Scan.next();
            Scanner secScan = new Scanner(fFrac);
            secScan.useDelimiter("/");
            numerator1 = secScan.nextInt();
            denominator1 = secScan.nextInt();
            if (denominator1 == 0)
            {
                throw new InputMismatchException("There is an invalid fraction. The denominator cannot equal 0.");
            }
        }

        //checks to see if the input is just a whole number
        else if (!frac1.contains("/"))
        {
            whole1 = Integer.parseInt(frac1);
            numerator1 = 0;
            denominator1 = 1;
        }
        /**
         * Scans fractions without wholes
         * checks to see if the denominator is valid and not 0
         * @throws InputMismatchException if the denominator is equal to 0
         */
        else
        {
            Scanner secScan = new Scanner(frac1);
            secScan.useDelimiter("/");
            numerator1 = secScan.nextInt();
            denominator1 = secScan.nextInt();
            whole1 = 0;
            if (denominator1 == 0)
            {
                throw new InputMismatchException("There is an invalid fraction. The denominator cannot equal 0.");
            }
        }

        // for scanning fraction 2
        Scanner frac2Scan = new Scanner(frac2);
        int whole2 = 0;
        int numerator2 = 1;
        int denominator2 = 1;

        /**
         * for a fraction with a whole number
         * checks to see if the denominator is valid and not 0
         * @throws InputMismatchException if the denominator is equal to 0
         */
        if (frac2.contains("_"))
        {
            frac2Scan.useDelimiter("_");
            whole2 = frac2Scan.nextInt();
            String fFrac = frac2Scan.next();
            Scanner secScan = new Scanner(fFrac);
            secScan.useDelimiter("/");
            numerator2 = secScan.nextInt();
            denominator2 = secScan.nextInt();
            if (denominator2 == 0)
            {
                throw new InputMismatchException("There is an invalid fraction. The denominator cannot equal 0.");
            }
        }

        //for a whole number
        else if (!frac2.contains("/"))
        {
            whole2 = Integer.parseInt(frac2);
            numerator2 = 0;
            denominator2 = 1;
        }

        //for a fraction without a whole
        /**
         * checks to see if the denominator is valid and not 0
         * @throws InputMismatchException if the denominator is equal to 0
         */
        else
        {
            Scanner secScan = new Scanner(frac2);
            secScan.useDelimiter("/");
            numerator2 = secScan.nextInt();
            denominator2 = secScan.nextInt();
            whole2 = 0;
            if (denominator2 == 0)
            {
                throw new InputMismatchException("There is an invalid fraction. The denominator cannot equal 0.");
            }
        }

        //making the fractions mixed fractions

        //making fraction 1 a mixed fraction
        if (whole1 > 0)
        {
            whole1 = whole1*denominator1;
            numerator1 = whole1 + numerator1;
        }
        else if (whole1<0)
        {
            whole1 *= -1;
            whole1 = whole1*denominator1;
            numerator1 = whole1 + numerator1;
            numerator1 *= -1;
        }


        //making fraction 2 a mixed fraction
        if (whole2 > 0)
        {
            whole2 = whole2*denominator2;
            numerator2 = whole2 + numerator2;
        }
        else if (whole2<0)
        {
            whole2 *= -1;
            whole2 = whole2*denominator2;
            numerator2 = whole2 + numerator2;
            numerator2 *= -1;
        }

        // variables for my final answer's numerator, denominator, and whole
        int numeratorF = 1;
        int denominatorF = 1;
        int wholeF = 0;
        String resultF = "";

        // for addition
        if (opperator.equals("+"))
        {
            //calculating the final fraction
            numeratorF = (numerator1*denominator2) + (numerator2*denominator1);
            denominatorF = denominator1*denominator2;

            //reducing the final fraction
            if (numeratorF == 0)
            {
                resultF = "0";
            }
            else if (numeratorF % denominatorF == 0)
            {
                wholeF = numeratorF/denominatorF;
                resultF = wholeF + "";
            }
            else if (Math.abs(numeratorF) > Math.abs(denominatorF))
            {
                wholeF = numeratorF / denominatorF;
                numeratorF = numeratorF - (wholeF * denominatorF);
                int counter = 2;
                for (counter = 2; counter < Math.abs(denominatorF); counter++)
                {
                    while (numeratorF % counter == 0 && denominatorF % counter == 0)
                    {
                        numeratorF = numeratorF / counter;
                        denominatorF = denominatorF / counter;
                    }
                }
                resultF = wholeF + "_" + Math.abs(numeratorF) + "/" + Math.abs(denominatorF);
            }

            else if (Math.abs(numeratorF) < Math.abs(denominatorF))
            {
                int counter = 2;
                for (counter = 2; counter < Math.abs(denominatorF); counter++)
                {
                    while (numeratorF % counter == 0 && denominatorF % counter == 0)
                    {
                        numeratorF = numeratorF / counter;
                        denominatorF = denominatorF / counter;
                    }

                }
                if (denominatorF < 0 && numeratorF > 0)
                {
                    denominatorF *= -1;
                    numeratorF *= -1;
                }
                resultF = numeratorF + "/" + denominatorF;
            }

        }

        //for subtraction
        else if (opperator.equals("-"))
        {
            //calculating the final fraction
            numeratorF =  (numerator1*denominator2) - (numerator2*denominator1);
            denominatorF = denominator1*denominator2;

            //reducing the final fraction
            if (numeratorF == 0)
            {
                resultF = "0";
            }
            else if (numeratorF % denominatorF == 0)
            {
                wholeF = numeratorF/denominatorF;
                resultF = wholeF + "";
            }
            else if (Math.abs(numeratorF) > Math.abs(denominatorF))
            {
                wholeF = numeratorF / denominatorF;
                numeratorF = numeratorF - (wholeF * denominatorF);
                int counter = 2;
                for (counter = 2; counter < Math.abs(denominatorF); counter++)
                {
                    while (numeratorF % counter == 0 && denominatorF % counter == 0)
                    {
                        numeratorF = numeratorF / counter;
                        denominatorF = denominatorF / counter;
                    }
                }
                resultF = wholeF + "_" + Math.abs(numeratorF) + "/" + Math.abs(denominatorF);
            }

            else if (Math.abs(numeratorF) < Math.abs(denominatorF))
            {
                int counter = 2;
                for (counter = 2; counter < Math.abs(denominatorF); counter++)
                {
                    while (numeratorF % counter == 0 && denominatorF % counter == 0)
                    {
                        numeratorF = numeratorF / counter;
                        denominatorF = denominatorF / counter;
                    }

                }
                if (denominatorF < 0 && numeratorF > 0)
                {
                    denominatorF *= -1;
                    numeratorF *= -1;
                }
                resultF = numeratorF + "/" + denominatorF;
            }
        }

        //for multiplication
        else if (opperator.equals("*"))
        {
            //calculating the final fraction
            numeratorF = numerator1*numerator2;
            denominatorF = denominator1*denominator2;

            //reducing the final fraction
            if (numeratorF == 0)
            {
                resultF = "0";
            }
            else if (numeratorF % denominatorF == 0)
            {
                wholeF = numeratorF/denominatorF;
                resultF = wholeF + "";
            }
            else if (Math.abs(numeratorF) > Math.abs(denominatorF))
            {
                wholeF = numeratorF / denominatorF;
                numeratorF = numeratorF - (wholeF * denominatorF);
                int counter = 2;
                for (counter = 2; counter < Math.abs(denominatorF); counter++)
                {
                    while (numeratorF % counter == 0 && denominatorF % counter == 0)
                    {
                        numeratorF = numeratorF / counter;
                        denominatorF = denominatorF / counter;
                    }
                }
                resultF = wholeF + "_" + Math.abs(numeratorF) + "/" + Math.abs(denominatorF);
            }

            else if (Math.abs(numeratorF) < Math.abs(denominatorF))
            {
                int counter = 2;
                for (counter = 2; counter < Math.abs(denominatorF); counter++)
                {
                    while (numeratorF % counter == 0 && denominatorF % counter == 0)
                    {
                        numeratorF = numeratorF / counter;
                        denominatorF = denominatorF / counter;
                    }

                }
                if (denominatorF < 0 && numeratorF > 0)
                {
                    denominatorF *= -1;
                    numeratorF *= -1;
                }
                resultF = numeratorF + "/" + denominatorF;
            }
        }

        //for division
        else if (opperator.equals("/"))
        {
            // calculating the final fraction
            numeratorF = numerator1*denominator2;
            denominatorF = numerator2 * denominator1;

            //reducing the final fraction
            if (numeratorF == 0)
            {
                resultF = "0";
            }
            else if (numeratorF % denominatorF == 0)
            {
                wholeF = numeratorF/denominatorF;
                resultF = wholeF + "";
            }
            else if (Math.abs(numeratorF) > Math.abs(denominatorF))
            {
                wholeF = numeratorF / denominatorF;
                numeratorF = numeratorF - (wholeF * denominatorF);
                int counter = 2;
                for (counter = 2; counter < Math.abs(denominatorF); counter++)
                {
                    while (numeratorF % counter == 0 && denominatorF % counter == 0)
                    {
                        numeratorF = numeratorF / counter;
                        denominatorF = denominatorF / counter;
                    }
                }
                resultF = wholeF + "_" + Math.abs(numeratorF) + "/" + Math.abs(denominatorF);
            }

            else if (Math.abs(numeratorF) < Math.abs(denominatorF))
            {
                int counter = 2;
                for (counter = 2; counter < Math.abs(denominatorF); counter++)
                {
                    while (numeratorF % counter == 0 && denominatorF % counter == 0)
                    {
                        numeratorF = numeratorF / counter;
                        denominatorF = denominatorF / counter;
                    }

                }
                if (denominatorF < 0 && numeratorF > 0)
                {
                    denominatorF *= -1;
                    numeratorF *= -1;
                }
                resultF = numeratorF + "/" + denominatorF;
            }
        }
        return resultF;
    }

}
