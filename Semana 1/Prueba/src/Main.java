import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

//    public static InputStreamReader lector = new InputStreamReader(System.in);
    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in)); //Construccion de objeto anonimo

    public static void main (String[] args){

        Persona estudiante1 = new Persona("Roberto", "Gonzalez Castillo", 1.9, 86, 27);

//        estudiante1.nombre = "Roberto";
//        estudiante1.apellidos = "Gonzalez Castillo";
//        estudiante1.altura = 1.9;
//        estudiante1.peso = 86;
//        estudiante1.edad = 27;

        System.out.println(estudiante1.altura);

//        System.out.println(hipotenusa(altura, altura));
    }

    public static double hipotenusa(double cateto1, double cateto2) {
        return Math.sqrt((cateto1 * cateto1) + (cateto2 * cateto2));
    }
}