package gonzalez.roberto.tl;

import gonzalez.roberto.bl.entities.Cliente;
import gonzalez.roberto.bl.logic.GestorCliente;
import gonzalez.roberto.bl.logic.GestorCuentaAhorro;
import gonzalez.roberto.bl.logic.GestorCuentaCredito;
import gonzalez.roberto.bl.logic.GestorCuentaDebito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;

public class Controlador {

    private static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void registrarCliente() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("\n --- Resgistro de cliente ---");
        System.out.println("\n Ingrese su nombre completo");
        String nombre_completo = entrada.readLine();
        System.out.println("\n Ingrese su fechaNacimiento");
        java.time.LocalDate fechaNacimiento = LocalDate.parse(entrada.readLine());
        System.out.println("\n Ingrese su cedula");
        String cedula = entrada.readLine();
        System.out.println("\n Ingrese su ocupación");
        String ocupacion = entrada.readLine();
        System.out.println("\n Ingrese su residencia");
        String residencia = entrada.readLine();
        System.out.println("\n Ingrese su contraseña");
        String contrasenia = entrada.readLine();
        System.out.println(GestorCliente.registrarCliente(nombre_completo, cedula, fechaNacimiento, ocupacion, residencia, contrasenia));
    }

    public static Cliente ingresarCliente() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("\n--- Ingreso como cliente ---");
        System.out.println("\nIngrese su cedula:");
        String cedula = entrada.readLine();
        System.out.println("Ingrese su contraseña:");
        String contrasenia = entrada.readLine();
        return GestorCliente.ingresarCliente(cedula,contrasenia);
    }

    public static void registrarCuentaAhorros(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("\n---Apertura Cuenta Ahorros---");
        System.out.print(GestorCuentaAhorro.registarCuentaAhorro(cliente));
    }

    public static void registrarCuentaDebito(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("\n---Apertura Cuenta Debito---");
        System.out.println(GestorCuentaDebito.registrarCuentaDebito(cliente));
    }

    public static void registrarCuentaCredito(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("\n---Apertura Cuenta Credito---");
        System.out.println("\nElija el tipo de cuenta");
        System.out.println("\n(1) Básica: Interes= 5%  Limite=$1000" +
                "\n(2) Platinum: Interes=6.5%  Limite=$2500" +
                "\n(3) Black: Interes=8%  Limite=$10000");
        String opcion = entrada.readLine();
        if(Objects.equals(opcion, "1")) System.out.println(GestorCuentaCredito.registrarCuentaCredito(cliente, 0.05, 1000));
        else if (Objects.equals(opcion, "2")) System.out.println(GestorCuentaCredito.registrarCuentaCredito(cliente, 0.065, 2500));
        else if (Objects.equals(opcion, "3")) System.out.println(GestorCuentaCredito.registrarCuentaCredito(cliente, 0.08, 10000));
    }


}
