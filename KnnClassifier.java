import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

class KnnClassifier {
    private DistanceMetric distanceMetric;
    private int k;
    private List<Instance> trainingData;

    public KnnClassifier(DistanceMetric distanceMetric, int k) {
        this.distanceMetric = distanceMetric;
        this.k = k;
    }

    public void train(Dataset data) {
        this.trainingData = data.data;  // Ahora se puede acceder a data
    }

    public String predict(Instance testInstance) {
        List<Neighbor> neighbors = getNeighbors(trainingData, testInstance.getFeatures(), k); // Cambia a Neighbor
        return getResponse(neighbors);
    }

    public void evaluate(List<Instance> testData) {
        int correctPredictions = 0;
        int totalPredictions = 0;
        for (Instance testInstance : testData) {
            String actualLabel = testInstance.getLabel();
            String predictedLabel = predict(testInstance);
            if (predictedLabel.equals(actualLabel)) {
                correctPredictions++;
            }
            totalPredictions++;
        }
        System.out.println("Accuracy: " + (double) correctPredictions / totalPredictions * 100 + "%");
    }

    // Método para obtener los k vecinos más cercanos y sus distancias
    public List<Neighbor> getNeighbors(List<Instance> trainingData, double[] testFeatures, int k) {
        List<Neighbor> distances = new ArrayList<>();
        for (Instance instance : trainingData) {
            double distance = distanceMetric.calculate(instance.getFeatures(), testFeatures);
            distances.add(new Neighbor(instance, distance));
        }
        Collections.sort(distances);
        return distances.subList(0, k); // Retorna solo los k vecinos más cercanos
    }

    private String getResponse(List<Neighbor> neighbors) { // Cambia el tipo a Neighbor
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (Neighbor neighbor : neighbors) {
            frequencyMap.put(neighbor.instance.getLabel(), frequencyMap.getOrDefault(neighbor.instance.getLabel(), 0) + 1);
        }
        return Collections.max(frequencyMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}