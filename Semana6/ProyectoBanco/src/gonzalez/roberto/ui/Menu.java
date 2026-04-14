package gonzalez.roberto.ui;

import gonzalez.roberto.bl.entities.Cliente;
import gonzalez.roberto.bl.logic.GestorCuentaAhorro;
import gonzalez.roberto.tl.Controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import static gonzalez.roberto.tl.Controlador.*;

public class Menu {
    private static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void menuPrincipal() throws IOException, SQLException, ClassNotFoundException {
        byte opcion;
        while (true) {
            System.out.println("\n--- Menú principal ---");
            System.out.println("1) Registrarse como cliente");
            System.out.println("2) Ingresar como cliente");
            System.out.println("0) Salir");
            System.out.print("Ingrese su elección: ");
            opcion = Byte.parseByte(entrada.readLine());
            if (opcion == 0) {
                System.out.println("Gracias por utilizar nuestro programa :)");
                break;
            } else if (opcion == 1) registrarCliente();
            else if (opcion == 2){
                Cliente cliente = Controlador.ingresarCliente();
                if(cliente == null){
                    System.out.print("Autenticacion invalida");
                    continue;
                }
                System.out.println("Autenticacion valida");
                menuCliente(cliente);
            }
            else System.out.println("Opción inválida.");
        }
    }


    public static void menuCliente(Cliente cliente) throws IOException, SQLException, ClassNotFoundException {
        System.out.print("\nSeleccione una opcion:");
        System.out.print("\n1. Abrir una cuenta");
        System.out.print("\n2. Hacer un retiro");
        String opcion = entrada.readLine();
        switch(opcion){
            case "1":
                System.out.print("\nSeleccione un tipo de cuenta: \n1.Cuenta de ahorros \n2.Cuenta de debito \n3.Cuenta de Credito");
                String tipo = entrada.readLine();
                switch (tipo){
                    case "1":
                        registrarCuentaAhorros(cliente);
                        break;

                    case "2":
                        registrarCuentaDebito(cliente);
                        break;

                    case "3":
                        registrarCuentaCredito(cliente);
                        break;
                }
                break;

            case "2":
                retirar(cliente);
                break;
        }
    }
}
