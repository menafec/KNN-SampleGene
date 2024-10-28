public class Instance {
    private double[] features; // Atributos de la instancia
    private String label;      // Etiqueta de la instancia

    // Constructor que acepta un arreglo de características y una etiqueta
    public Instance(double[] features, String label) {
        this.features = features;
        this.label = label;
    }

    // Constructor que acepta una cadena de texto (para caso de uso en consola)
    public Instance(String instanceStr) {
        String[] values = instanceStr.split(","); // Separar valores por coma
        this.features = new double[values.length - 1];
        for (int i = 0; i < values.length - 1; i++) {
            this.features[i] = Double.parseDouble(values[i]);
        }
        this.label = values[values.length - 1];
    }

    // Métodos para acceder a las características y la etiqueta
    public double[] getFeatures() {
        return features;
    }

    public String getLabel() {
        return label;
    }
}