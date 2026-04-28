package unlar.edu.ar.ui;

import java.util.List;
import java.util.Scanner;
import unlar.edu.ar.model.CuentaBancaria;
import unlar.edu.ar.service.Operaciones;

public class Interfaz {

    private final Scanner sc = new Scanner(System.in);

    // Colores ANSI
    private static final String VERDE = "\033[32m";
    private static final String ROJO = "\033[31m";
    private static final String AZUL = "\033[34m";
    private static final String RESET = "\033[0m";

    private void limpiarPantalla() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++)
                System.out.println();
        }
    }

    private void esperarVolverMenu() {
        System.out.println("\n" + AZUL + "Presione M para volver al menu" + RESET);
        while (!sc.nextLine().trim().toUpperCase().equals("M"))
            ;
    }

    public void Iniciar(CuentaBancaria cuenta, List<CuentaBancaria> cuentas) {
        Operaciones service = new Operaciones();
        boolean salir = false;

        while (!salir) {
            limpiarPantalla();
            System.out.println(AZUL + "=== CAJERO AUTOMATICO ===" + RESET);
            System.out.println("Cuenta: " + cuenta.getNumeroCuenta() + " - Titular: " + cuenta.getTitular());
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Extraer");
            System.out.println("4. Transferir");
            System.out.println("5. Ver Historial");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");

            try {
                int opcion = sc.nextInt();
                sc.nextLine();
                double monto;

                switch (opcion) {
                    case 1:
                        limpiarPantalla();
                        System.out.println(AZUL + "=== CONSULTAR SALDO ===" + RESET);
                        System.out.println("Saldo: $" + String.format("%.2f", cuenta.getSaldo()));
                        esperarVolverMenu();
                        break;
                    case 2:
                        limpiarPantalla();
                        System.out.println(AZUL + "=== DEPOSITAR ===" + RESET);
                        System.out.print("Monto: $");
                        monto = sc.nextDouble();
                        sc.nextLine();
                        System.out.println(VERDE + "Deposito exitoso" + RESET);
                        service.depositar(cuenta, monto);
                        esperarVolverMenu();
                        break;
                    case 3:
                        limpiarPantalla();
                        System.out.println(AZUL + "=== EXTRAER ===" + RESET);
                        System.out.print("Monto: $");
                        monto = sc.nextDouble();
                        sc.nextLine();
                        System.out.println(VERDE + "Extraccion exitosa" + RESET);
                        service.extraccion(cuenta, monto);
                        esperarVolverMenu();
                        break;
                    case 4:
                        limpiarPantalla();
                        System.out.println(AZUL + "=== TRANSFERIR ===" + RESET);
                        System.out.print("Numero de cuenta destino: ");
                        String cuentaDestinoNum = sc.nextLine();

                        // Buscar cuenta destino en la lista
                        CuentaBancaria cuentaDestino = null;
                        for (CuentaBancaria c : cuentas) {
                            if (c.getNumeroCuenta().equals(cuentaDestinoNum)
                                    && !c.getNumeroCuenta().equals(cuenta.getNumeroCuenta())) {
                                cuentaDestino = c;
                                break;
                            }
                        }

                        if (cuentaDestino == null) {
                            System.out.println(ROJO + "Cuenta destino no encontrada" + RESET);
                        } else {
                            System.out.print("Monto: $");
                            monto = sc.nextDouble();
                            sc.nextLine();
                            try {
                                service.transferencia(cuenta, cuentaDestino, monto);
                                System.out.println(
                                        VERDE + "Transferencia exitosa a " + cuentaDestino.getTitular() + RESET);
                            } catch (Exception e) {
                                System.out.println(ROJO + "Error: " + e.getMessage() + RESET);
                            }
                        }
                        esperarVolverMenu();
                        break;
                    case 5:
                        limpiarPantalla();
                        System.out.println(AZUL + "=== HISTORIAL ===" + RESET);
                        cuenta.getHistorialTransacciones().forEach(System.out::println);
                        esperarVolverMenu();
                        break;
                    case 6:
                        limpiarPantalla();
                        System.out.println(VERDE + "Gracias por usar el cajero" + RESET);
                        salir = true;
                        break;
                    default:
                        System.out.println(ROJO + "Opcion invalida" + RESET);
                        System.in.read();
                        break;
                }
            } catch (Exception e) {
                System.out.println(ROJO + "Error: " + e.getMessage() + RESET);
                sc.nextLine();
            }
        }
    }
}
