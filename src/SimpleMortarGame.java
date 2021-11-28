import java.util.Scanner;

public class SimpleMortarGame {

    public static double mortarRange(double firingAngleInDegrees, double initialVelocity) {
        double range;
        double g = 9.81;
        double angleInRadians = Math.toRadians(firingAngleInDegrees);
        // calculating range of the diagonal projection
        range = (2 * Math.pow(initialVelocity, 2) * Math.sin(angleInRadians) * Math.cos(angleInRadians)) / g;
        return range;
    }

    public static boolean isObstacleHit(double distanceFromTarget, double mortarRange) {
        int margin = 10; // hit margin
        if (mortarRange > distanceFromTarget + margin) {
            System.out.println("Oops!!! The missile flew " + (mortarRange - (distanceFromTarget + margin)) + " metres too far...");
            return false;
        } else if (mortarRange < distanceFromTarget - margin) {
            System.out.println("Oops!!! The missile flew " + ((distanceFromTarget - margin) - mortarRange) + " metres too close...");
            return false;
        } else {
            System.out.println("Boooom!!! You have hit the obstacle !!! :)");
            return true;
        }
    }

    public static void startGame(int numberOfMissiles, int distanceFromTarget){

        boolean gameOver;
        double firingAngle;
        double initialVelocity;
        double range;
        Scanner sc = new Scanner(System.in);

        while (numberOfMissiles != 0){
            System.out.println("Distance from target: " + distanceFromTarget);
            System.out.println("You have " + numberOfMissiles + " missiles");

            System.out.println("Enter the initial velocity [m/s]: ");
            initialVelocity = sc.nextDouble();

            System.out.println("Enter the firing angle [\u00B0]: ");
            firingAngle = sc.nextDouble();

            range = mortarRange(firingAngle, initialVelocity);
            gameOver = isObstacleHit(distanceFromTarget, range);
            System.out.println();
            if(gameOver){
                break;
            }
            numberOfMissiles--;
        }
        System.out.println("Game over");
    }

    public static void main(String[] args) {
        startGame(5, 100);
    }
}
