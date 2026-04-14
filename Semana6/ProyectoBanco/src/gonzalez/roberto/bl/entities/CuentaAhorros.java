package gonzalez.roberto.bl.entities;

public class CuentaAhorros extends Cuenta{

    private final String ID;
    private static int contador = 0;

    //constructoes

    public CuentaAhorros(double tasaInteres) {
        contador++;
        this.ID = "CA-" + contador;
        this.tasaInteres = tasaInteres;
        this.saldo = 100;
    }

    public CuentaAhorros(double tasaInteres, double saldoInicial) {
        contador++;
        this.ID = "CA-" + contador;
        this.tasaInteres = tasaInteres;
        this.saldo = saldoInicial;
    }

    public CuentaAhorros(String ID, double tasaInteres, double saldo) {
        this.ID = ID;
        this.tasaInteres = tasaInteres;
        this.saldo = saldo;
    }

    //toString
    public String toString() {
        return "Cuenta de Ahorros: " + ID;
    }

    //getter

    public String getID() {
        return ID;
    }

    public static int getContador() {
        return contador;
    }

    //metodos

    public void retirar(double montoRetiro) throws SaldoInsuficienteException {
        if(this.saldo - montoRetiro < 100){
            throw new SaldoInsuficienteException("Saldo insuficiente");
        } else {
            saldo -= montoRetiro;
        }
    }

    public void depositar(double montoDeposito){
        saldo += montoDeposito;
    }

    public void generarIntereses(){
        saldo += tasaInteres*saldo;
    }
}
