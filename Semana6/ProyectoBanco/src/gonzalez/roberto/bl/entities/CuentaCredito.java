package gonzalez.roberto.bl.entities;

public class CuentaCredito extends Cuenta{
    private final String ID;
    private static int contador = 0;
    private double limite;

    //constructoes

    public CuentaCredito(double tasaInteres, double limite) {
        contador++;
        this.ID = "CC-" + contador;
        this.tasaInteres = tasaInteres;
        this.limite = limite;
    }

    //getters

    public String getID() {
        return ID;
    }

    public static int getContador() {
        return contador;
    }

    public double getLimite() {
        return limite;
    }

    //toString
    public String toString(){
        return "Cuenta de Credito: " + ID;
    }

    //métodos
    public void retirar(double montoRetiro){
        if (saldo - montoRetiro < limite){
            System.out.println("No es posible hacer este retiro ya que excedería el limite de crédito");
        } else {
            saldo -= montoRetiro;
        }
    }

    public void abonar(double montoAbono){
        if (saldo + montoAbono > 0){
            System.out.println("El abono no se puede realizar, ya que el monto abonado supera al monto debido.");
        } else {
            saldo += montoAbono;
        }
    }

    public void generarIntereses() {
        saldo -= tasaInteres * saldo;
    }
}
