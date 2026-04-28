package unlar.edu.ar.model;

import java.time.*;

public class Transaccion {

    private TipoTransaccion tipo;
    private double monto;
    private LocalDateTime fechaHora;
    private String descripcion;
    private double saldoResultado;

    public double getSaldoResultado() {
        return saldoResultado;
    }

    public void setSaldoResultado(double saldoResultado) {
        this.saldoResultado = saldoResultado;
    }

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
        String tipoStr = (tipo != null) ? tipo.name() : descripcion;
        return String.format("[%s] %s: $%.2f | Saldo: $%.2f",
                fechaHora.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                tipoStr,
                monto,
                saldoResultado);
    }

    public String toString(double saldoResultado) {
        return String.format("[%s] %s: $%.2f | Saldo: $%.2f",
                fechaHora.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                tipo != null ? tipo : descripcion,
                monto,
                saldoResultado);
    }

}
