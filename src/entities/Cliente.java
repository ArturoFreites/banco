package entities;

import java.util.List;

public class Cliente extends Usuario {
    List<Cuenta> cuentas;

    public Cliente() {
        super();
    }

    public Cliente(Long id, String nombre, String apellido, String direccion, Integer telefono, String mail, List<Cuenta> cuentas) {
        super(id, nombre, apellido, direccion, telefono, mail);
        this.cuentas = cuentas;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

}
