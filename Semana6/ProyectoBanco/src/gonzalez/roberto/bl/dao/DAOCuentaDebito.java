package gonzalez.roberto.bl.dao;

import gonzalez.roberto.bl.entities.Cliente;
import gonzalez.roberto.bl.entities.CuentaCredito;
import gonzalez.roberto.bl.entities.CuentaDebito;
import gonzalez.roberto.bl.entities.SaldoInsuficienteException;
import gonzalez.roberto.dl.Conector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOCuentaDebito {
    private static String statement;
    private static String query;

    public static String insertarCuentaDebito(CuentaDebito cuenta, Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        statement = "INSERT INTO t_cuentas_debito VALUES ('" + cuenta.getID() + "', " + cuenta.getSaldo() + " , " + cuenta.getInteres() + " , '" + cliente.getCedula() + "');";
        Conector.getConexion().ejecutarStatement(statement);
        return "La cuenta de debito se a creado con exito";
    }

    public static String actualizarRetiro(Cliente cliente, String id, double monto) throws SQLException, IOException, ClassNotFoundException {
        query = "SELECT * FROM t_cuentas_debito WHERE id + ? AND cedula_cliente = ?";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, id, cliente.getCedula());
        if (!resultado.next()) return "Acceo denegado";
        CuentaDebito cuenta = new CuentaDebito(id, resultado.getDouble("porcentaje-interes"), resultado.getDouble("saldo"));
        try {
            cuenta.retirar(monto);
        } catch (SaldoInsuficienteException e) {
            return e.getMessage();
        }
        statement = "UPDATE t_cuenta_debito SET saldo = ? WHERE id + ? AND cedula_cliente = ?;";
        Conector.getConexion().ejecutarStatement(statement, cuenta.getSaldo(), id, cliente.getCedula());
        return "EL retiro se realizo adecuandamente";
    }

}
