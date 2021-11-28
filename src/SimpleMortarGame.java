public class SimpleMortarGame {

    public static double mortarRange(double firingAngleInDegrees, double initialVelocity) {
        double range;
        double g = 9.81;
        double angleInRadians = Math.toRadians(firingAngleInDegrees);
        // calculating range of the diagonal projection
        range = (2 * Math.pow(initialVelocity, 2) * Math.sin(angleInRadians) * Math.cos(angleInRadians)) / g;

        return range;
    }

    public static void isObstacleHit(double distanceFromObstacle, double mortarRange) {
        int margin = 10; // hit margin
        if (mortarRange > distanceFromObstacle + margin) {
            System.out.println("Oops!!! The missile flew " + (mortarRange - (distanceFromObstacle + margin)) + " metres too far...");
        } else if (mortarRange < distanceFromObstacle - margin) {
            System.out.println("Oops!!! The missile flew " + ((distanceFromObstacle - margin) - mortarRange) + " metres too close...");
        } else {
            System.out.println("Boooom!!! You have hit the obstacle !!! :)");
        }
    }

    public static void main(String[] args) {


    }
}
