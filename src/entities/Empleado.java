package entities;

import enums.Cargo;

public class Empleado extends Usuario {

    private Cargo cargo;
    private Sucursal sucursal;

    public Empleado() {
        super();
    }

    public Empleado(Long id, String nombre, String apellido, String direccion, Integer telefono, String mail, Cargo cargo, Sucursal sucursal) {
        super(id, nombre, apellido, direccion, telefono, mail);
        this.cargo = cargo;
        this.sucursal = sucursal;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
