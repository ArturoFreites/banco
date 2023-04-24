package services;

import entities.Cuenta;
import entities.Deposito;
import entities.Operacion;
import entities.Retiro;
import enums.AgenteDepositante;
import repository.BancoRepository;

import java.util.Date;
import java.util.Scanner;

public class DepositoServiceImpl implements OperacionService{

    public DepositoServiceImpl() {
    }

    private Scanner read = new Scanner(System.in);
    private BancoRepository bancoRepository = BancoRepository.obtenerInstancia();

    @Override
    public Operacion crearOperacion(Double monto) {
        Deposito deposito = new Deposito();
        deposito.setMonto(monto);
        deposito.setDate(new Date());
        deposito.setAgenteDepositante(selecionarAgente());

        return deposito;
    }


    private AgenteDepositante selecionarAgente() {
        boolean valido=false;
        Integer opcion;
        AgenteDepositante agenteDepositante = null;
        do{
            System.out.println("Ingrese por que medio va a realizar la operacion");
            mostrarOpciones();
            opcion= read.nextInt();
            switch (opcion){
                case 1:
                    agenteDepositante = AgenteDepositante.CAJERO;
                    break;
                case 2:
                    agenteDepositante = AgenteDepositante.SUCURSAL;
                    break;
                default:
                    System.out.println("Ingrese opcion valida!");
            }

        }while (opcion>3 || opcion<0);

        return agenteDepositante;
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("1-CAJERO");
        System.out.println("2-SUCURSAL");
    }

    public void ingresarDinero(Cuenta cuentaOperar) {
        Cuenta cuenta = cuentaOperar;
        Double saldoIngresar;
        Boolean valido =false;
        do{
            System.out.println("Ingrese el monto a depositar");
            saldoIngresar=read.nextDouble();

            if (saldoIngresar<30000){
                Double saldo = cuenta.getSaldo();
                saldo = saldo+saldoIngresar;
                cuenta.setSaldo(saldo);
                bancoRepository.updateCuenta(cuenta);

                Operacion objOperacion = crearOperacion(saldoIngresar);
                bancoRepository.addOperacion(cuenta,objOperacion);

                valido=true;
            }else{
                System.out.println("No puede depositar mas de $30.000!");
                System.out.println("La AFIP lo visitá!");
            }
        }while (valido=false);
    }
}
