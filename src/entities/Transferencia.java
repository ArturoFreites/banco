package entities;

import java.util.Date;

public class Transferencia extends Operacion{

    private String titularOrigen;
    private Integer numCuentaOrigen;
    private String titularDestino;
    private Integer numCtaDestino;
    private String sucursalOrigen;
    private String sucursalDestino;

    public Transferencia() {
        super();
    }

    public Transferencia(Double monto, Date date, String titularOrigen, Integer numCuentaOrigen, String titularDestino, Integer numCtaDestino, String sucursalOrigen, String sucursalDestino) {
        super(monto, date);
        this.titularOrigen = titularOrigen;
        this.numCuentaOrigen = numCuentaOrigen;
        this.titularDestino = titularDestino;
        this.numCtaDestino = numCtaDestino;
        this.sucursalOrigen = sucursalOrigen;
        this.sucursalDestino = sucursalDestino;
    }

    public String getTitularOrigen() {
        return titularOrigen;
    }

    public void setTitularOrigen(String titularOrigen) {
        this.titularOrigen = titularOrigen;
    }

    public Integer getNumCuentaOrigen() {
        return numCuentaOrigen;
    }

    public void setNumCuentaOrigen(Integer numCuentaOrigen) {
        this.numCuentaOrigen = numCuentaOrigen;
    }

    public String getTitularDestino() {
        return titularDestino;
    }

    public void setTitularDestino(String titularDestino) {
        this.titularDestino = titularDestino;
    }

    public Integer getNumCtaDestino() {
        return numCtaDestino;
    }

    public void setNumCtaDestino(Integer numCtaDestino) {
        this.numCtaDestino = numCtaDestino;
    }

    public String getSucursalOrigen() {
        return sucursalOrigen;
    }

    public void setSucursalOrigen(String sucursalOrigen) {
        this.sucursalOrigen = sucursalOrigen;
    }

    public String getSucursalDestino() {
        return sucursalDestino;
    }

    public void setSucursalDestino(String sucursalDestino) {
        this.sucursalDestino = sucursalDestino;
    }
}
