package unlar.edu.ar.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.ToDoubleBiFunction;

import unlar.edu.ar.exception.*;
import unlar.edu.ar.model.*;

public class Operaciones {
    // validar cuenta activa
    // validar positivo
    // actualizar
    // registrar
    public void depositar(CuentaBancaria cuenta, double monto) {
        if (cuenta.isActiva() && monto > 0) {
            cuenta.setSaldo(cuenta.getSaldo() + monto);
            System.out.println("Depósito exitoso. Nuevo saldo: " + cuenta.getSaldo());
        } else {
            System.out.println("No se pudo realizar el depósito. Verifique la cuenta y el monto.");
            throw new CuentaInactivaException("Cuenta inactiva o monto no válido.");

        }
        // actualizar saldo
        double nuevoSaldo = cuenta.getSaldo() + monto;
        cuenta.setSaldo(nuevoSaldo);
        // registrar transacción
        Transaccion transaccion = new Transaccion("Depósito: ", monto);
        System.out.println("Depósito registrado: " + monto);
        cuenta.getTransacciones().add(transaccion.toString());
    }

    public void extraccion(CuentaBancaria cuenta, double monto) {
        if (cuenta.isActiva() && monto > 0 && cuenta.getSaldo() >= monto) {
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            System.out.println("Extracción exitosa. Nuevo saldo: " + cuenta.getSaldo());
        } else if (monto <= 10000) {
            throw new LimiteExtraccionExcedidoException("Limite excedido");
            System.out.println("Monto no válido. El monto debe ser mayor a 0 y menor o igual a 10000.");
        } else {
            System.out.println("No se pudo realizar la extracción. Verifique la cuenta, el monto y el saldo.");
            throw new CuentaInactivaException("Cuenta inactiva, monto no válido o saldo insuficiente.");
        }
        // actualizar saldo
        double nuevoSaldo = cuenta.getSaldo() - monto;
        cuenta.setSaldo(nuevoSaldo);
        // registrar transacción
        Transaccion transaccion = new Transaccion("Extracción: ", monto);
        System.out.println("Extracción registrada: " + monto);
        cuenta.getTransacciones().add(transaccion.toString());
    }

    //
    public void transferencia(CuentaBancaria cuenta, double monto){
        public void Transferencia(String numeroCuentaOrigen, String numeroCuentaDestino, double monto) {
        // validar monto positivo
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        } else if (monto > cuentaOrigen.getSaldo()) {
            throw new IllegalArgumentException("Saldo insuficiente en la cuenta origen");
        } else {
            // actualizar saldo
            double nuevoSaldoOrigen = cuentaOrigen.getSaldo() - monto;
            cuentaOrigen.setSaldo(nuevoSaldoOrigen);

            double nuevoSaldoDestino = cuentaDestino.getSaldo() + monto;
            cuentaDestino.setSaldo(nuevoSaldoDestino);
            // registrar
            Transaccion transaccionOrigen = new Transaccion(TipoTransaccion.TRANSFERENCIA, monto, LocalDateTime.now(),
                    "Transferencia a la cuenta " + numeroCuentaDestino);
            Transaccion transaccionDestino = new Transaccion(TipoTransaccion.TRANSFERENCIA, monto, LocalDateTime.now(),
                    "Transferencia desde la cuenta " + numeroCuentaOrigen);
            cuentaOrigen.getHistorialTransacciones().add(transaccionOrigen.toString());
            cuentaDestino.getHistorialTransacciones().add(transaccionDestino.toString());

        }
    }




    // consultar saldo
    public void consulta(String numeroCuenta) {
        // consultar saldo
        double saldo = cuenta.getSaldo();
    }

    // consultar historial
    public void consultarHistorial(String numeroCuenta) {
        // consultar historial
        List<String> historial = cuenta.getHistorialTransacciones();
    }


    }

}
