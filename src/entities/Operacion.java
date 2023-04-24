package entities;

import java.util.Date;

public abstract class Operacion {
    private Double monto;
    private Date date;

    public Operacion() {
    }

    public Operacion(Double monto, Date date) {
        this.monto = monto;
        this.date = date;
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
}
