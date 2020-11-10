package es.com.estudio.java.arrays;

public class IngresoDeEnteros {

private int numeros[];
private int dimension = 10;


public IngresoDeEnteros(int numeros []) {
    this.numeros = numeros;
    this.numeros = new int[dimension];
}

public void mostrarArrays() {
    int posicion = 0;
    for (int i = 0; i < numeros.length; i++) {
        posicion = i;
        System.out.println("vector : " +numeros[i] + "indice : "+ posicion);
    }
}
}