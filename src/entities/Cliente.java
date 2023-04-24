package entities;

import java.util.List;

public class Cliente extends Usuario {
    List<Integer> numCuentas;

    public Cliente() {
        super();
    }

    public Cliente(String nombre, String apellido, String direccion, String telefono, String mail, String usuario, String password, List<Integer> numCuentas) {
        super(nombre, apellido, direccion, telefono, mail, usuario, password);
        this.numCuentas = numCuentas;
    }

    public List<Integer> getNumCuentas() {
        return numCuentas;
    }

    public void setNumCuentas(List<Integer> numCuentas) {
        this.numCuentas = numCuentas;
    }
}