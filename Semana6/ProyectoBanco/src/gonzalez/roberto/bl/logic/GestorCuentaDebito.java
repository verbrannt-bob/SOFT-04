package gonzalez.roberto.bl.logic;

import gonzalez.roberto.bl.dao.DAOCuentaAhorro;
import gonzalez.roberto.bl.dao.DAOCuentaDebito;
import gonzalez.roberto.bl.entities.Cliente;
import gonzalez.roberto.bl.entities.CuentaAhorros;
import gonzalez.roberto.bl.entities.CuentaDebito;

import java.io.IOException;
import java.sql.SQLException;

public class GestorCuentaDebito {
    private static double interes = 0.04;

    public static String registrarCuentaDebito(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        return DAOCuentaDebito.insertarCuentaDebito(new CuentaDebito(interes), cliente);
    }

    public static String retirar(Cliente cliente, String id, double monto) throws SQLException, IOException, ClassNotFoundException {
        return DAOCuentaDebito.actualizarRetiro(cliente, id, monto);
    }
}
