import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dataset {
    public List<Instance> data;

    // Constructor que carga datos desde el archivo
    public Dataset(String filename) {
        data = new ArrayList<>();
        loadData(filename);
    }

    // Método para cargar datos desde el archivo
    private void loadData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            // Saltar la primera línea (encabezado)
            String line = br.readLine(); // Lee y descarta el encabezado
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");  // Asumiendo que los valores están separados por comas
                // Procesar los valores para crear una instancia y añadirla a la lista
                double[] features = new double[values.length - 1];
                for (int i = 0; i < values.length - 1; i++) {
                    features[i] = Double.parseDouble(values[i]);
                }
                String label = values[values.length - 1]; // Último valor como etiqueta
                data.add(new Instance(features, label));  // Crea una nueva instancia
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}