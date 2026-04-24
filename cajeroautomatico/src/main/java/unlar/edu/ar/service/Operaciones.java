package unlar.edu.ar.service;

import java.time.LocalDateTime;

import unlar.edu.ar.exception.*;
import unlar.edu.ar.model.*;

public class Operaciones {
    // validar cuenta activa
    // validar positivo
    // actualizar
    // registrar
    public void depositar(CuentaBancaria cuenta, double monto) {
        if (!cuenta.isActiva()) {
            throw new CuentaInactivaException("Cuenta inactiva.");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo.");
        }
        cuenta.setSaldo(cuenta.getSaldo() + monto);
        Transaccion transaccion = new Transaccion("Depósito", monto);
        cuenta.getHistorialTransacciones().add(transaccion.toString());
        System.out.println("Depósito exitoso. Nuevo saldo: " + cuenta.getSaldo());
    }

    public void extraccion(CuentaBancaria cuenta, double monto) {
        if (!cuenta.isActiva()) {
            throw new CuentaInactivaException("Cuenta inactiva.");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo.");
        }
        if (monto > 10000) {
            throw new LimiteExtraccionExcedidoException("Límite de extracción excedido (máximo 10000).");
        }
        if (cuenta.getSaldo() < monto) {
            throw new SaldoInsuficienteException("Saldo insuficiente.");
        }
        cuenta.setSaldo(cuenta.getSaldo() - monto);
        Transaccion transaccion = new Transaccion("Extracción", -monto);
        cuenta.getHistorialTransacciones().add(transaccion.toString());
        System.out.println("Extracción exitosa. Nuevo saldo: " + cuenta.getSaldo());
    }

    //
    public void transferencia(CuentaBancaria cuentaOrigen, CuentaBancaria cuentaDestino, double monto) {
        if (!cuentaOrigen.isActiva() || !cuentaDestino.isActiva()) {
            throw new CuentaInactivaException("Una de las cuentas está inactiva.");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo.");
        }
        if (cuentaOrigen.getSaldo() < monto) {
            throw new SaldoInsuficienteException("Saldo insuficiente en la cuenta origen.");
        }
        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto);
        cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);
        Transaccion transaccionOrigen = new Transaccion(TipoTransaccion.TRANSFERENCIA, -monto, LocalDateTime.now(),
                "Transferencia a " + cuentaDestino.getTitular());
        Transaccion transaccionDestino = new Transaccion(TipoTransaccion.TRANSFERENCIA, monto, LocalDateTime.now(),
                "Transferencia desde " + cuentaOrigen.getTitular());
        cuentaOrigen.getHistorialTransacciones().add(transaccionOrigen.toString());
        cuentaDestino.getHistorialTransacciones().add(transaccionDestino.toString());
        System.out.println("Transferencia exitosa.");
    }
}
