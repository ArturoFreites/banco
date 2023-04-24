package entities;

import java.util.List;

public class Sucursal {
    private String localidad;
    private String telefono;

    public Sucursal() {

    }

    public Sucursal(String localidad, String telefono) {
        this.localidad = localidad;
        this.telefono = telefono;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
