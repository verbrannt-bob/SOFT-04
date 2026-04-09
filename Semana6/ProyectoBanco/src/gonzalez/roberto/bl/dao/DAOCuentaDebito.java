package gonzalez.roberto.bl.dao;

import gonzalez.roberto.bl.entities.Cliente;
import gonzalez.roberto.bl.entities.CuentaAhorros;
import gonzalez.roberto.dl.Conector;

import java.io.IOException;
import java.sql.SQLException;

public class DAOCuentaDebito {
    private static String statement;
    private static String query;

    public static String insertarCuentaDebito(CuentaAhorros cuenta, Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        statement = "INSERT INTO t_cuentas_debito VALUES ('" + cuenta.getID() + "', " + cuenta.getSaldo() + " , " + cuenta.getInteres() + " , '" + cliente.getCedula() + "');";
        Conector.getConexion().ejecutarStatement(statement);
        return "La cuenta de debito se a creado con exito";
    }
}
