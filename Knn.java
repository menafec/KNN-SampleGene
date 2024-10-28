import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Knn {
    public static void main(String[] args) throws IOException {
        // Obtener entrada del usuario para la ruta del archivo de entrenamiento y el valor de k
        Scanner scanner = new Scanner(System.in);
        
        // Especifica la ruta completa del archivo de datos
        String trainingFile = "/Users/ximenafernandez/Desktop/Machine Learning/KNN Sample Gene/SampleGene.csv";
        System.out.print("Enter the value of k: ");
        int k = Integer.parseInt(scanner.nextLine());

        // Cargar los datos de entrenamiento
        Dataset dataset = new Dataset(trainingFile); // Cambiar a constructor que recibe el nombre del archivo

        // Objeto KnnClassifier para predicción y evaluación
        KnnClassifier classifier = new KnnClassifier(new EuclideanDistance(), k);
        classifier.train(dataset);  // Entrenar el clasificador con los datos cargados

        // Menú interactivo para opciones de predicción
        label:
        while (true) {
            System.out.println("Opciones:");
            System.out.println("a) Todas las observaciones de test set");
            System.out.println("b) Clasificar puntos desde un archivo CSV");
            System.out.println("c) Salir");
            System.out.print("Opción: ");
            String option = scanner.nextLine();

            switch (option) {
                case "a":
                    System.out.print("Ingresa el path: ");
                    String testFile = scanner.nextLine();
                    List<Instance> testData = new Dataset(testFile).data; // Cargar los datos de prueba
                    classifier.evaluate(testData);
                    break;

                case "b":
                    // Leer puntos de un archivo CSV para clasificación
                    System.out.print("Ingresa la ruta del archivo de prueba: ");
                    String testFilePath = scanner.nextLine();
                    List<Instance> testInstances = new Dataset(testFilePath).data; // Cargar los datos de prueba

                    // Determinar cuántas instancias aleatorias imprimir
                    System.out.print("¿Cuántas instancias aleatorias deseas imprimir? ");
                    int numInstances = Integer.parseInt(scanner.nextLine());

                    // Crear un generador de números aleatorios
                    Random random = new Random();
                    for (int i = 0; i < numInstances; i++) {
                        // Seleccionar un índice aleatorio
                        int randomIndex = random.nextInt(testInstances.size());
                        Instance testInstance = testInstances.get(randomIndex);
                        String predictedLabel = classifier.predict(testInstance);
                        System.out.println("Predicted Label for instance with features " + 
                                           java.util.Arrays.toString(testInstance.getFeatures()) + ": " + predictedLabel);
                    }
                    break;

                case "c":
                    break label;
                    
                default:
                    System.out.println("Opción inválida");
            }
        }
        scanner.close();
    }
}