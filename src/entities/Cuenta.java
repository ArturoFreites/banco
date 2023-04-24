package entities;

import java.util.List;

public class Cuenta {
    private Integer numCuenta;
    private String cbu;
    private Double saldo;
    private Cliente cliente;
    private Sucursal sucursal;
    List<Operacion> operaciones;

    public Cuenta() {
    }

    public Cuenta(Integer numCuenta, String cbu, Double saldo, Cliente cliente, Sucursal sucursal, List<Operacion> operaciones) {
        this.numCuenta = numCuenta;
        this.cbu = cbu;
        this.saldo = saldo;
        this.cliente = cliente;
        this.sucursal = sucursal;
        this.operaciones = operaciones;
    }

    public Integer getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(Integer numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public List<Operacion> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operacion> operaciones) {
        this.operaciones = operaciones;
    }
}
