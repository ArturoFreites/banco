package entities;

import enums.AgenteDepositante;
import enums.AgenteRetiro;

import java.util.Date;

public class Retiro extends Operacion{
    private AgenteRetiro agenteRetiro;

    public Retiro() {
        super();
    }

    public Retiro(Double monto, Date date, AgenteRetiro agenteRetiro) {
        super(monto, date);
        this.agenteRetiro = agenteRetiro;
    }

    public AgenteRetiro getAgenteRetiro() {
        return agenteRetiro;
    }

    public void setAgenteRetiro(AgenteRetiro agenteRetiro) {
        this.agenteRetiro = agenteRetiro;
    }
}
