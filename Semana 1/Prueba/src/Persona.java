public class Persona {

    //Atriubustos
    String nombre;
    String apellidos;
    double altura;
    int peso;
    int edad;

    //Metodos
    //Constructor

//    public Persona(String pNombre, String pApellidos, double pAltura, int pPeso, int pEdad) {
//        nombre = pNombre;
//        apellidos = pApellidos;
//        altura = pAltura;
//        peso = pPeso;
//        edad = pEdad;
//    }

    public Persona(String nombre, String apellidos, double altura, int peso, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;
    }

    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Persona() {
    }
}
