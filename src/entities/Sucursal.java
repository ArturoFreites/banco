package entities;

import java.util.List;

public class Sucursal {

    private Integer idSucursal;
    private String localidad;
    private Integer telefono;
    private Banco banco;
    List<Cliente> clientes;
    List<Empleado> empleados;

    public Sucursal() {
    }

    public Sucursal(Integer idSucursal, String localidad, Integer telefono, Banco banco, List<Cliente> clientes, List<Empleado> empleados) {
        this.idSucursal = idSucursal;
        this.localidad = localidad;
        this.telefono = telefono;
        this.banco = banco;
        this.clientes = clientes;
        this.empleados = empleados;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {

        return "Sucursal{" +
                "idSucursal=" + idSucursal +
                ", localidad='" + localidad + '\'' +
                ", telefono=" + telefono +
                ", banco=" + banco +
                ", clientes=" + clientes +
                ", empleados=" + empleados +
                '}';
    }
}
