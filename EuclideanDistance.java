public class EuclideanDistance extends DistanceMetric {
    @Override
    double calculate(double[] x1, double[] x2) {
        double distance = 0;
        for (int i = 0; i < x1.length; i++) {
            distance += Math.pow(x1[i] - x2[i], 2);
        }
        return Math.sqrt(distance);
    }
}