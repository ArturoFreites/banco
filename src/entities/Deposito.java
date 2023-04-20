package entities;

import enums.Agente;

import java.util.Date;

public class Deposito extends Operacion {
    private Agente agente;
    private String descripcion;

    public Deposito() {
        super();
    }

    public Deposito(Double id, Double monto, Date date, Integer numCuentaOrigen, Agente agente, String descripcion) {
        super(id, monto, date, numCuentaOrigen);
        this.agente = agente;
        this.descripcion = descripcion;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
