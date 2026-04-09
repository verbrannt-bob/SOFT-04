package gonzalez.roberto.bl.dao;

import gonzalez.roberto.bl.entities.Cliente;
import gonzalez.roberto.dl.Conector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOCliente {
    private static String statement;
    private static String query;

    public static String insertarCliente(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        statement = "INSERT INTO t_cliente VALUES ('" + cliente.getNombre_completo() + "', '"+ cliente.getCedula() + "', '" + cliente.getFechaNacimiento() +"', '" + cliente.getOcupacion() + "', '" + cliente.getResidencia() + "', '" + cliente.getContrasenia() + "');";
        Conector.getConexion().ejecutarStatement(statement);
        return "El cliente se registro con éxito";
    }

    public static Cliente seleccionarCliente(String cedula, String contrasenia) throws SQLException, IOException, ClassNotFoundException {
        // SELECT FROM t_clientes WHERE cedula = * AND contrasenia = **;
        query = "SELECT * FROM t_cliente WHERE cedula = ? AND contrasenia = ?;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, cedula, contrasenia);
        if (!resultado.next()) return null;
        return new Cliente(resultado.getString("nombre_completo"), resultado.getString("cedula"), resultado.getDate("fecha_nacimiento").toLocalDate(), resultado.getString("ocupacion"), resultado.getString("residencia"), resultado.getString("contrasenia"));
    }
}
