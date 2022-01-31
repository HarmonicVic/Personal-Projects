import java.util.Scanner;

public class MainCalculator {
    public void execute(){
        System.out.println("Welcome! ANS is currently 0.");
        Calculator calc = new Calculator();
        String end = "n";
        Scanner sc = new Scanner(System.in);
        while (end.equals("n")) {
            calc.readInput();
            System.out.println("Do you want to end? y/n");
            end = sc.nextLine();
            while (!(end.equals("y") || end.equals("n"))){
                System.out.println("Please enter a valid option.\n Do you want to quit? y/n");
                end = sc.nextLine();
            }
        }
        System.out.println("Shutting down. Thank you!");
    }


    public static void main(String[] args) {
        MainCalculator mc = new MainCalculator();
        mc.execute();
    }
}
