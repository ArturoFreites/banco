package entities;

import java.util.List;

public class Banco {
    private String nombre;
    private List<Sucursal> sucursales;
    private List<Usuario> usuarios;
    private List<Cuenta> cuentas;


    public Banco() {
    }

    public Banco(String nombre, List<Sucursal> sucursales, List<Usuario> usuarios, List<Cuenta> cuentas) {
        this.nombre = nombre;
        this.sucursales = sucursales;
        this.usuarios = usuarios;
        this.cuentas = cuentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}
