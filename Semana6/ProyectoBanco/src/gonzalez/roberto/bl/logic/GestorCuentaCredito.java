package gonzalez.roberto.bl.logic;

import gonzalez.roberto.bl.dao.DAOCuentaCredito;
import gonzalez.roberto.bl.entities.Cliente;
import gonzalez.roberto.bl.entities.CuentaCredito;

import java.io.IOException;
import java.sql.SQLException;

public class GestorCuentaCredito {
    public static String registrarCuentaCredito(Cliente cliente, double interes, double limite) throws SQLException, IOException, ClassNotFoundException {
        return DAOCuentaCredito.insertarCuentaCredito(new CuentaCredito(interes, limite), cliente);
    }
}
