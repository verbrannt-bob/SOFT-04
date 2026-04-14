package gonzalez.roberto.bl.dao;

import gonzalez.roberto.bl.entities.Cliente;
import gonzalez.roberto.bl.entities.CuentaAhorros;
import gonzalez.roberto.bl.entities.SaldoInsuficienteException;
import gonzalez.roberto.dl.Conector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOCuentaAhorro {
    private static String statement;
    private static String query;

    public static String insertarCuentaAhorro(CuentaAhorros cuenta, Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        statement = "INSERT INTO t_cuentas_ahorro VALUES ('" + cuenta.getID() + "', " + cuenta.getSaldo() + " , " + cuenta.getInteres() + " , '" + cliente.getCedula() + "');";
        Conector.getConexion().ejecutarStatement(statement);
        return "La cuenta de ahorros se a creado con exito";
    }

    public static String actualizarRetiro(Cliente cliente, String id, double monto) throws SaldoInsuficienteException, SQLException, IOException, ClassNotFoundException {
        query = "SELECT * FROM t_cuentas_ahorro WHERE id = ? AND cedula_cliente = ?";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, id, cliente.getCedula());
        if (!resultado.next()) return "Acceso denegado";
        CuentaAhorros cuenta = new CuentaAhorros(id, resultado.getDouble("porcentaje_interes"), resultado.getDouble("saldo"));
        try {
            cuenta.retirar(monto);
        } catch (SaldoInsuficienteException e){
            return e.getMessage();
        }
        statement = "UPDATE t_cuentas_ahorro SET saldo = ? WHERE id = ? AND cedula_cliente =?;";
        Conector.getConexion().ejecutarStatement(statement, cuenta.getSaldo(), id, cliente.getCedula());
        return "El retiro se realizo adecuandamente";
    }
}
