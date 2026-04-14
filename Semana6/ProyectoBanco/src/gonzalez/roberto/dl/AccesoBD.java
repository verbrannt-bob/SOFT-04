package gonzalez.roberto.dl;

import gonzalez.roberto.bl.entities.CuentaAhorros;

import javax.xml.transform.Result;
import java.sql.*;

public class AccesoBD {
    private Connection conexion;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public AccesoBD(String direccion, String usuario, String contrasenia) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection(direccion, usuario, contrasenia);
    }

    public void ejecutarStatement(String statement) throws SQLException {
        this.statement = conexion.createStatement();
        this.statement.executeUpdate(statement);
    }

    public void ejecutarStatement(String statement, double d, String s1, String s2) throws SQLException {
        this.statement = conexion.prepareStatement(statement);
        preparedStatement.setDouble(1, d);
        preparedStatement.setString(2, s1);
        preparedStatement.setString(3, s2);
        this.statement.executeUpdate(statement);
    }

    public ResultSet ejecutarQuery(String query, String s1, String s2) throws SQLException {
        preparedStatement = conexion.prepareStatement(query);
        preparedStatement.setString(1, s1);
        preparedStatement.setString(2, s2);
        return preparedStatement.executeQuery();
    }

    public ResultSet ejecutarQuery(String query, String s) throws SQLException {
        preparedStatement = conexion.prepareStatement(query);
        preparedStatement.setString(1, s);
        return preparedStatement.executeQuery();
    }

}
