package gonzalez.roberto.bl.dao;

import gonzalez.roberto.bl.entities.Cliente;
import gonzalez.roberto.bl.entities.CuentaAhorros;
import gonzalez.roberto.bl.entities.CuentaCredito;
import gonzalez.roberto.dl.Conector;

import java.io.IOException;
import java.sql.SQLException;

public class DAOCuentaCredito {
    private static String statement;
    private static String query;

    public static String insertarCuentaCredito(CuentaCredito cuenta, Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        statement = "INSERT INTO t_cuentas_credito VALUES ('" + cuenta.getID() + "', " + cuenta.getSaldo() + " , " + cuenta.getLimite() + " , " + cuenta.getInteres() + " , '" + cliente.getCedula() + "');";
        Conector.getConexion().ejecutarStatement(statement);
        return "La cuenta de crédito se a creado con éxito";
    }
}
