package entities;

import enums.Cargo;

public class Empleado extends Usuario {

    private Cargo cargo;

    public Empleado() {
        super();
    }

    public Empleado(String nombre, String apellido, String direccion, String telefono, String mail, String usuario, String password, Cargo cargo) {
        super(nombre, apellido, direccion, telefono, mail, usuario, password);
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

}
