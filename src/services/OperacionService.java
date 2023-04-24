package services;

import entities.Operacion;
import enums.AgenteDepositante;

public interface OperacionService {
    public Operacion crearOperacion(Double monto);
    public void mostrarOpciones();
}
