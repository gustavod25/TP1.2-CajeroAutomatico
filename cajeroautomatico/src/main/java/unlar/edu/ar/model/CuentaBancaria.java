package unlar.edu.ar.model;

import java.util.*;

public class CuentaBancaria {
    private String pin;
    private double saldo;
    private String titular;
    private boolean activa;
    private List<String> historialTransacciones = new ArrayList<>();

    public CuentaBancaria() {
    }

    public CuentaBancaria(String titular, String pin, double saldo, boolean activa,
            List<String> historialTransacciones) {
        this.titular = titular;
        this.pin = pin;
        this.saldo = saldo;
        this.activa = activa;
        this.historialTransacciones = historialTransacciones;
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

    public List<String> getHistorialTransacciones() {
        return historialTransacciones;
    }

    public void setHistorialTransacciones(List<String> historialTransacciones) {
        this.historialTransacciones = historialTransacciones;
    }

}
