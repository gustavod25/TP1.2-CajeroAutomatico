package unlar.edu.ar.model;

import java.util.*;

public class CuentaBancaria {
    private final String numeroCuenta;
    private String pin;
    private double saldo;
    private String titular;
    private boolean activa;
    private List<Transaccion> historialTransacciones = new ArrayList<>();

    public CuentaBancaria() {
        this.numeroCuenta = "";
    }

    public CuentaBancaria(String numeroCuenta, String titular, String pin, double saldo, boolean activa,
            List<Transaccion> historialTransacciones) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.pin = pin;
        this.saldo = saldo;
        this.activa = activa;
        this.historialTransacciones = historialTransacciones;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public List<Transaccion> getHistorialTransacciones() {
        return historialTransacciones;
    }

    public void setHistorialTransacciones(List<Transaccion> historialTransacciones) {
        this.historialTransacciones = historialTransacciones;
    }

}
