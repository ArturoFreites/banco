package services;

import entities.Cuenta;
import entities.Operacion;
import entities.Retiro;
import enums.AgenteDepositante;
import enums.AgenteRetiro;
import repository.BancoRepository;

import java.util.Date;
import java.util.Scanner;

public class RetiroServiceImpl implements OperacionService{

    public RetiroServiceImpl() {
    }

    private Scanner read = new Scanner(System.in);
    private BancoRepository bancoRepository = BancoRepository.obtenerInstancia();

    @Override
    public Operacion crearOperacion(Double monto) {
        Retiro retiro = new Retiro();
        retiro.setMonto(monto);
        retiro.setDate(new Date());
        retiro.setAgenteRetiro(selecionarAgente());

        return retiro;
    }

    private AgenteRetiro selecionarAgente() {
        Integer opcion;
        AgenteRetiro agenteRetiro = null;
        do{
            System.out.println("Ingrese por que medio va a realizar la operacion");
            mostrarOpciones();
            opcion= read.nextInt();
            switch (opcion){
                case 1:
                    agenteRetiro = AgenteRetiro.CAJERO;
                    break;
                case 2:
                    agenteRetiro = AgenteRetiro.NEGOCIO;
                    break;
                case 3:
                    agenteRetiro = AgenteRetiro.SUCURSAL;
                    break;
                default:
                    System.out.println("Ingrese opcion valida!");
            }

        }while (opcion>3 || opcion<0);

        return agenteRetiro;
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("1-CAJERO");
        System.out.println("2-COMERCIO");
        System.out.println("3-SUCURSAL");
    }

    public void retirarDinero(Cuenta cuenta) {
        Double saldoRetirar;
        Boolean valido =false;
        do{
            System.out.println("Ingrese el monto a retirar");
            saldoRetirar=read.nextDouble();

            if (saldoRetirar<=cuenta.getSaldo()){
                Double saldo = cuenta.getSaldo();
                saldo = saldo-saldoRetirar;
                cuenta.setSaldo(saldo);
                bancoRepository.updateCuenta(cuenta);

                Operacion objOperacion = crearOperacion(saldoRetirar);
                bancoRepository.addOperacion(cuenta,objOperacion);

                valido=true;
            }else{
                System.out.println("Ingrese un monto valido!");
            }
        }while (valido=false);
    }


}
