# KNN Classifier

Este proyecto implementa un clasificador K-Nearest Neighbors (KNN) en Java. 
Permite cargar conjuntos de datos desde archivos CSV, entrenar el modelo y hacer predicciones sobre nuevas instancias. 
También incluye la capacidad de clasificar puntos aleatorios y evaluar el modelo en un conjunto de prueba.

## Autor

Ximena Carolina Fernandez Cardenas
para Machine Learning Octubre 2024

## Estructura

KNN Sample Gene

Knn.java               // Clase principal para ejecutar el clasificador KNN

Dataset.java           // Clase para cargar y almacenar instancias desde archivos CSV

Instance.java          // Clase que representa una instancia con características y etiqueta

DistanceMetric.java    // Interfaz para definir métricas de distancia

EuclideanDistance.java  // Implementación de la distancia euclidiana

KnnClassifier.java     // Clase que implementa el clasificador KNN

Neighbor.java          // Clase que representa un vecino con su distancia
