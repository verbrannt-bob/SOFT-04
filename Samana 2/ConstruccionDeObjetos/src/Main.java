import javax.security.auth.Subject;

public class Main {

    public static void main (String[] args){
        //clientes
        Cliente cliente1 = new Cliente("Roberto", "Gonzalez Castillo", 117260520, 'm', "Heredia");
        Cliente cliente2 = new Cliente("Marta", "Chubata", 123456789, "Gdansk");
        Cliente cliente3 = new Cliente();

        //suscripciones
        Suscripcion suscripcion1 = new Suscripcion(TipoSuscripcion.BASICA, 9.99, Periodicidad.MENSUAL);
        Suscripcion suscripcion2 = new Suscripcion(TipoSuscripcion.GOLD, 34.99, Periodicidad.TRIMESTRAL);
        Suscripcion suscripcion3 = new Suscripcion(TipoSuscripcion.PLATINUM, 199.99, Periodicidad.ANUAL);

        //prueba de funcionalidad
        cliente1.suscribirse(new Suscripcion(TipoSuscripcion.PLATINUM, 199.99, Periodicidad.ANUAL));
        cliente2.suscribirse(suscripcion2);
    }
}
