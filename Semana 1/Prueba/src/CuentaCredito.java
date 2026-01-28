public class CuentaCredito {
    int numeroCuenta;
    String titular;
    double maxCredito;
    double intereses;
    int diaDePago;
    double montoActual;

    public CuentaCredito(int numeroCuenta, String titular, double maxCredito, int diaDePago, double intereses, double montoActual) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.maxCredito = maxCredito;
        this.diaDePago = diaDePago;
        this.intereses = intereses;
        this.montoActual = montoActual;
    }
}