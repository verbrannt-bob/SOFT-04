package gonzalez.roberto.bl.entities;

public class CuentaDebito extends Cuenta{
    private final String ID;
    private static int contador = 0;

    //constructoes

    public CuentaDebito(double tasaInteres) {
        contador++;
        this.ID = "CD-" + contador;
        this.tasaInteres = tasaInteres;
        this.saldo = 0;
    }

    public CuentaDebito(double tasaInteres, double saldoInicial) {
        contador++;
        this.ID = "CD-" + contador;
        this.tasaInteres = tasaInteres;
        this.saldo = saldoInicial;
    }

    public CuentaDebito(String id, double tasaInteres, double saldoInicial) {
        this.ID = id;
        this.tasaInteres = tasaInteres;
        this.saldo = saldoInicial;
    }

    //toString
    public String toString() {
        return "Cuenta de Debito: " + ID;
    }

    //getter

    public String getID() {
        return ID;
    }

    public static int getContador() {
        return contador;
    }

    //metodos
    public void retirar(double montoRetiro) throws SaldoInsuficienteException{
        if(this.saldo - montoRetiro < 0){
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
