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
        Transaccion transaccion = new Transaccion(TipoTransaccion.DEPOSITO, monto, LocalDateTime.now(), "Deposito");
        transaccion.setSaldoResultado(cuenta.getSaldo());
        cuenta.getHistorialTransacciones().add(transaccion);
        System.out.println("Tu Nuevo saldo es de : $" + cuenta.getSaldo());
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
        Transaccion transaccion = new Transaccion(TipoTransaccion.EXTRACCION, monto, LocalDateTime.now(), "Extraccion");
        transaccion.setSaldoResultado(cuenta.getSaldo());
        cuenta.getHistorialTransacciones().add(transaccion);
        System.out.println("Tu Nuevo saldo es de : $" + cuenta.getSaldo());
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
        Transaccion transaccionOrigen = new Transaccion(TipoTransaccion.TRANSFERENCIA, monto, LocalDateTime.now(),
                "Transferencia a " + cuentaDestino.getTitular());
        transaccionOrigen.setSaldoResultado(cuentaOrigen.getSaldo());
        Transaccion transaccionDestino = new Transaccion(TipoTransaccion.TRANSFERENCIA, monto, LocalDateTime.now(),
                "Transferencia desde " + cuentaOrigen.getTitular());
        transaccionDestino.setSaldoResultado(cuentaDestino.getSaldo());
        cuentaOrigen.getHistorialTransacciones().add(transaccionOrigen);
        cuentaDestino.getHistorialTransacciones().add(transaccionDestino);
        System.out.println("Transferencia exitosa.");
    }
}
