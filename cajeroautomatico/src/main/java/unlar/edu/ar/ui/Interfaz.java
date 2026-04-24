package unlar.edu.ar.ui;

import java.util.Scanner;

import unlar.edu.ar.model.CuentaBancaria;
import unlar.edu.ar.service.Operaciones;

public class Interfaz {

    private final Scanner sc = new Scanner(System.in);

    public void Iniciar(CuentaBancaria cuenta) {

        Operaciones service = new Operaciones();

        System.out.println("Cajero Automatico");

        boolean salir = false; 

        while (!salir) {

            try {

            System.out.println("\n--- Titular: " + cuenta.getTitular() + " ---");
                System.out.println("1. Consultar Saldo");
                System.out.println("2. Depositar");
                System.out.println("3. Extraer");
                System.out.println("4. Transferir"); 
                System.out.println("5. Ver Historial");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opcion: ");

                int opcion = sc.nextInt();



                switch (opcion) {

                    case 1: System.out.println("Saldo: " + cuenta.getSaldo()); 

                        break;

                    case 2: System.out.println("Monto a Depositar: ");

                        double monto = sc.nextDouble();   

                        service.depositar(cuenta,monto);

                        break;
                    
                    case 3: System.out.println("Monto a extraer: ");

                        double monto = sc.nextDouble();

                        service.extraccion(cuenta,monto);

                        break;

                    case 4: System.out.println("Monto a transferir: ");

                        double monto = sc.nextDouble();

                        // service.transferencia(cuenta,monto);  // TODO: fix method

                        break;

                    case 5: System.out.println("Historial de cuenta: ");

                        cuenta.getHistorialTransacciones().forEach(System.out::println);

                        break;

                    case 6: System.out.println("Saliendo..." ); 
                    
                        salir = true; 

                        break; 

                    default: System.out.println("Opcion invalida");

                        break;

                    
                }

            }
            
        }

    }

}
