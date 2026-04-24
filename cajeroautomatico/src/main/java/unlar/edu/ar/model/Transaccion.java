package unlar.edu.ar.model;

import java.time.LocalDate;
import java.time.*;

public class Transaccion {

    private TipoTransaccion tipo;
    private double monto;
    private LocalDateTime fechaHora;
    private String descripcion;
    public TipoTransaccion getTipo() {
        return tipo;
    }
    public void setTipo(TipoTransaccion tipo) {
        this.tipo = tipo;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Transaccion(String descripcion, double monto) {
        this.descripcion = descripcion;
        this.monto = monto;
        this.fechaHora = LocalDateTime.now();
    }

    public Transaccion(TipoTransaccion tipo, double monto, LocalDateTime fechaHora, String descripcion) {
        this.tipo = tipo;
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return tipo + " - " + monto + " - " + fechaHora + " - " + descripcion;
    }

    

}
