package tech.wec.Math;

public class GenerateRandomPointInACircle_478 {
    protected double radius;
    protected double x_center;
    protected double y_center;

    /**
     * x = x_center + radius * cos θ * rand(1)
     * y = y_center + radius * sin θ * rand(1)
     * rand θ and rand 1 to get the result
     *
     * @param radius
     * @param x_center
     * @param y_center
     */
    public GenerateRandomPointInACircle_478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double r = Math.sqrt(Math.random()) * radius;
        double theta = Math.PI * 2 * Math.random();
        double[] res = new double[2];
        res[0] = Math.cos(theta) * r + x_center;
        res[1] = Math.sin(theta) * r + y_center;
        return res;
    }
}
