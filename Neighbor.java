class Neighbor implements Comparable<Neighbor> {
    Instance instance;
    double distance;

    public Neighbor(Instance instance, double distance) {
        this.instance = instance;
        this.distance = distance;
    }

    @Override
    public int compareTo(Neighbor other) {
        return Double.compare(this.distance, other.distance);  // Compara las distancias
    }
}