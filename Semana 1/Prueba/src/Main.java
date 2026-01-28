public class Main {

    public static void main (String[] args){

        String nombre = "Roberto";
        String apellidos = "Gonzalez Castillo";
        double altura = 1.9;
        int peso = 86;
        int edad = 27;

        System.out.println(hipotenusa(altura, altura));
    }

    public static double hipotenusa(double cateto1, double cateto2) {
        return Math.sqrt((cateto1 * cateto1) + (cateto2 * cateto2));
    }
}