package entities;

import java.util.List;

public class Cuenta {
    private Integer numCuenta;
    private String cbu;
    private Double saldo;
    private Cliente cliente;
    private Sucursal sucursal;
    List<Operacion> operaciones;

}
