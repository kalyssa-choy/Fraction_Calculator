import org.junit.Test;
import java.util.Scanner;
import java.util.*;
// Checkpoint 1-only tests
public class FracCalcTestCheckpoint1
{
    @Test public void testCheckpoint1_1() {  FracCalcTestALL.assertForEarlyCheckpoints("6_5/8", "whole:6 numerator:5 denominator:8", "12_3/8", FracCalc.produceAnswer("5_3/4 + 6_5/8"));}
    @Test public void testCheckpoint1_2() {FracCalcTestALL.assertForEarlyCheckpoints("20", "whole:20 numerator:0 denominator:1", "-20_3/7", FracCalc.produceAnswer("-3/7 - 20"));}
    @Test public void testCheckpoint1_3() {FracCalcTestALL.assertForEarlyCheckpoints("27/21", "whole:0 numerator:27 denominator:21", "-33_2/7", FracCalc.produceAnswer("-32 - 27/21"));}
    public static void main(String[] args)
    {
        // code here!!
        System.out.println("Enter your fraction equation: ");
        Scanner in = new Scanner(System.in);
        String equation = in.nextLine();
        String myFrac2 = produceAnswer(equation);
        System.out.println(myFrac2);

    }
    public static String produceAnswer(String input)
    {
        // TODO: Implement this function to produce the solution to the input
        Scanner myScan = new Scanner(input);
        myScan.useDelimiter(" ");
        String frac1 = myScan.next();
        String opperator = myScan.next();
        String frac2 = myScan.next();
        return frac2;
    }
}
