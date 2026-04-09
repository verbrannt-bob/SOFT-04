package gonzalez.roberto.bl.logic;

import gonzalez.roberto.bl.dao.DAOCliente;
import gonzalez.roberto.bl.entities.Cliente;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class GestorCliente {

    public static String registrarCliente(String nombre_completo, String cedula, LocalDate fechaNacimiento, String ocupacion, String residencia, String contrasenia) throws SQLException, IOException, ClassNotFoundException {
        return DAOCliente.insertarCliente(new Cliente(nombre_completo, cedula, fechaNacimiento, ocupacion, residencia, contrasenia));
    }

    public static Cliente ingresarCliente(String cedula, String contrasenia) throws SQLException, IOException, ClassNotFoundException {
        return DAOCliente.seleccionarCliente(cedula, contrasenia);
    }
}
