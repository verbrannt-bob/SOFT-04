package gonzalez.roberto.bl.logic;

import gonzalez.roberto.bl.dao.DAOCuentaAhorro;
import gonzalez.roberto.bl.entities.Cliente;
import gonzalez.roberto.bl.entities.CuentaAhorros;

import java.io.IOException;
import java.sql.SQLException;

public class GestorCuentaAhorro {
    static double interes = 0.04;

    public static String registarCuentaAhorro(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        return DAOCuentaAhorro.insertarCuentaAhorro(new CuentaAhorros(interes), cliente);
    }
}
