package unlar.edu.ar.model;

import java.util.*;

public class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;
    private String titular;
    private boolean activa;
    private List<String> historialTransacciones = new ArrayList<>();

    public CuentaBancaria() {
    }

    public CuentaBancaria(String numeroCuenta, double saldo, String titular, boolean activa,
            List<String> historialTransacciones) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.titular = titular;
        this.activa = activa;
        this.historialTransacciones = historialTransacciones;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
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

    public List<String> getHistorialTransacciones() {
        return historialTransacciones;
    }

    public void setHistorialTransacciones(List<String> historialTransacciones) {
        this.historialTransacciones = historialTransacciones;
    }

}
