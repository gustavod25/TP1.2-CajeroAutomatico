package unlar.edu.ar;

import java.util.ArrayList;
import java.util.List;

import unlar.edu.ar.model.CuentaBancaria;
import unlar.edu.ar.service.Operaciones;
import unlar.edu.ar.ui.Interfaz;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Operaciones service = new Operaciones();
        Interfaz ui = new Interfaz();

        CuentaBancaria cuenta1 = new CuentaBancaria("123456789", "Messi", "123", 100000.00, true, new ArrayList<>());

        CuentaBancaria cuenta2 = new CuentaBancaria("346272189", "Maradona", "789", 90000.00, true, new ArrayList<>());

        CuentaBancaria cuenta3 = new CuentaBancaria("987654321", "Ronaldo", "456", 15000.00, true, new ArrayList<>());

        try {
            service.depositar(cuenta1, 5000.00);
            service.extraccion(cuenta3, 2000.00);
            service.extraccion(cuenta2, 1000.00);
            service.depositar(cuenta2, 3000.00);
            service.transferencia(cuenta1, cuenta2, 5000.00);
            service.extraccion(cuenta3, 2000.00);
            service.extraccion(cuenta1, 2000.00);
            service.transferencia(cuenta2, cuenta3, 2000.00);
            service.depositar(cuenta1, 5000.00);
            service.depositar(cuenta2, 5000.00);
            service.transferencia(cuenta3, cuenta2, 2000.00);
            service.extraccion(cuenta1, 3000.00);
            service.depositar(cuenta1, 9000.00);
            service.extraccion(cuenta2, 4000.00);
            service.transferencia(cuenta1, cuenta3, 3000.00);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        List<CuentaBancaria> cuentas = new ArrayList<>();
        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
        cuentas.add(cuenta3);

        ui.Iniciar(cuenta1, cuentas);

    }
}
