public class Cliente {
    String nombre;
    String apellidos;
    int cedula;
    char sexo;
    String ubicacion;

    public Cliente(String nombre, String apellidos, int cedula, char sexo, String ubicacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.sexo = sexo;
        this.ubicacion = ubicacion;
    }

    public Cliente(String nombre, String apellidos, int cedula, String ubicacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.ubicacion = ubicacion;
    }

    public Cliente() {
    }

    void suscribirse(Suscripcion suscripcion){
        System.out.println(this.nombre + " " + this.apellidos + " adquirió una suscripción " + suscripcion.tipo);
    }
}
