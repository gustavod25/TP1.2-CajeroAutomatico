package unlar.edu.ar;

import java.util.ArrayList;

import unlar.edu.ar.model.CuentaBancaria;
import unlar.edu.ar.ui.Interfaz;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Interfaz ui = new Interfaz();

        CuentaBancaria cuenta1 = new CuentaBancaria("123456789", "Messi", "123", 10000.00, true, new ArrayList<>());

        ui.Iniciar(cuenta1);

    }
}
