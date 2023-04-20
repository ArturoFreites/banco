package entities;

import java.util.Date;

public abstract class Operacion {
    private Double id;
    private Double monto;
    private Date date;
    private Integer numCuentaOrigen;

    public Operacion() {
    }

    public Operacion(Double id, Double monto, Date date, Integer numCuentaOrigen) {
        this.id = id;
        this.monto = monto;
        this.date = date;
        this.numCuentaOrigen = numCuentaOrigen;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNumCuentaOrigen() {
        return numCuentaOrigen;
    }

    public void setNumCuentaOrigen(Integer numCuentaOrigen) {
        this.numCuentaOrigen = numCuentaOrigen;
    }
}
