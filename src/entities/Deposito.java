package entities;

import enums.AgenteDepositante;

import java.util.Date;

public class Deposito extends Operacion {
    private AgenteDepositante agenteDepositante;

    public Deposito() {
        super();
    }

    public Deposito(Double monto, Date date, AgenteDepositante agente) {
        super(monto, date);
        this.agenteDepositante = agente;
    }

    public AgenteDepositante getAgenteDepositante() {
        return agenteDepositante;
    }

    public void setAgenteDepositante(AgenteDepositante agenteDepositante) {
        this.agenteDepositante = agenteDepositante;
    }
}
