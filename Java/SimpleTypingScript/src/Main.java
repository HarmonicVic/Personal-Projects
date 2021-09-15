import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();

        int i = 0;
        while(i != 300){
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            Random randNum = new Random();
            int mils = (1800 + randNum.nextInt(400)) % 2400;

            System.out.println(mils);
            try {
                Thread.sleep(mils);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
        /*
            rpg refine armor
            rpg refine armor
            rpg refine armor

        */
    }
}

