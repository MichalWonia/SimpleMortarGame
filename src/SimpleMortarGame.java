public class SimpleMortarGame {

    public static double mortarRange(double firingAngleInDegrees, double initialVelocity){
        double range;
        double g = 9.81;
        double angleInRadians = Math.toRadians(firingAngleInDegrees);
        range = (2*Math.pow(initialVelocity, 2)*Math.sin(angleInRadians)*Math.cos(angleInRadians))/g;



    return range;
    }



    public static void main(String[] args) {
        System.out.println(mortarRange(45, 100));
    }
}
