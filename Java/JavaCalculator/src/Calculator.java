import java.util.Scanner;

class Calculator {
    private double number1;
    private double number2;
    private char c;

    /*Saves the result from a calculation. Initially has a value of 0.*/
    private double ANS;

    /* readInput reads the input from terminal. It keeps the numbers as strings, so it knows when the user
    * wants to use ANS instead of a number. The function then transforms the strings to doubles.*/
    public void readInput(){
        Scanner sc = new Scanner(System.in);
        int maxAttempts = 3;
        System.out.print("Insert 1st number: ");
        String input = sc.nextLine();

        /*If the string is not ANS, we parse the string to double, else we use the saved value. */
        if (!input.equals("ANS"))
            for (int i = 0; i < maxAttempts; ++i) {
                try {
                    number1 = Double.parseDouble(input);
                    break;
                } catch (NumberFormatException nfe1) {
                    System.out.println("ERROR: Only numbers or \"ANS\".");
                    System.out.print("Insert 1st number again: ");
                    input = sc.nextLine();
                    if (input.equals("ANS")) {
                        number1 = ANS;
                        break;
                    }
                }
            }
        else number1 = ANS;

        /*TODO Improve detection of bad characters in operation read.*/
        System.out.print("Insert operation: ");
        c = sc.next().charAt(0);

        /*next().charAt(0) does not read the \n character when entered by the user, which is
         * then read by "input = sc.nextLine();" below.
         * This is a workaround to in, consuming that \n leftover char. */
        /*TODO Change workaround to using nextLine everywhere and parsing results accordingly.*/
        sc.nextLine();

        /*'v' (placeholder) represents square root, which doesn't need a second variable.
        Currently, every other function needs 2 variables, so only 'v' skips the 2nd variable. */
        if (c != 'v') {
            System.out.print("Insert 2nd number: ");
            input = sc.nextLine();

            if (!input.equals("ANS"))
                for (int i = 0; i < maxAttempts; ++i) {
                    try {
                        number2 = Double.parseDouble(input);
                        break;
                    } catch (NumberFormatException nfe2) {
                        System.out.println("ERROR: Only numbers or \"ANS\".");
                        System.out.print("Insert 2nd number again: ");
                        input = sc.nextLine();
                        if (input.equals("ANS")) {
                            number2 = ANS;
                            break;
                        }
                    }
                }
            else
                number2 = ANS;
            System.out.printf("%f %c %f = ",number1, c, number2);
        }
        else System.out.printf("\u221A%f = ", number1);
        calculate();
    }

    /*TODO Research how to deal with calculations between infinities*/
    /*Basic calculation switch to manage the character input from the user. */
    public void calculate(){
        BasicCalculations bs = new BasicCalculations();
        switch (c){
            case '+':
                ANS = bs.sumDoubles(number1, number2);
                break;
            case '-':
                ANS = bs.subtractDoubles(number1, number2);
                break;
            case '*':
                ANS = bs.multiplyDoubles(number1, number2);
                break;
            case '/':
                if (number2 == 0)
                    System.out.print("WARNING: Should not divide by 0.\n Answer is ");
                ANS = bs.divideDoubles(number1, number2);
                break;
            case '^':
                ANS = bs.powerDoubles(number1, number2);
                break;
            case 'v':
                ANS = bs.squareRootDouble(number1);
                break;
        }
        printResult();
    }

    /*Prints result. */
    public void printResult(){
        System.out.println(ANS);
    }
}
