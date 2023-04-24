package services;

import entities.*;
import repository.BancoRepository;

import java.util.Scanner;

public class CuentaMenuService {

    public CuentaMenuService() {
    }
    private Scanner read = new Scanner(System.in);
    private BancoRepository bancoRepository = BancoRepository.obtenerInstancia();
    private RetiroServiceImpl retiroService = new RetiroServiceImpl();
    private DepositoServiceImpl depositoService = new DepositoServiceImpl();
    private TransferenciaService transferenciaService = new TransferenciaService();

    public void menu(Cuenta cuentaOperar){
        menuCuenta(cuentaOperar);
    }

    private void menuCuenta(Cuenta cuentaOperar) {
        Cuenta cuenta = cuentaOperar;
        int op;
        do{
            System.out.println("---------- MENU CUENTA BANCARIA ----------");
            System.out.println("-- NUM° CUENTA: "+cuenta.getNumCuenta()+ " | Saldo: $"+ cuenta.getSaldo()+" ---");
            System.out.println("---- CBU: "+cuenta.getCbu()+" ----");
            mostrarOpciones();
            System.out.println("Ingrese opcion:");
            op= read.nextInt();
            switch (op){
                case 1 :
                    retiroService.retirarDinero(cuenta);
                    break;
                case 2 :
                    depositoService.ingresarDinero(cuenta);
                    break;
                case 3 :
                    transferenciaService.realizarTranferencia(cuenta);
                    break;
                case 4:
                    mostraOperaciones(cuenta);
                    break;
                case 5:
                    System.out.println("Saliendo de la cuenta: " + cuenta.getNumCuenta());
                    break;
                default:
                    System.out.println("Ingrese una opcion correcta!");
            }
        }while(op!=5);
    }


    private void mostraOperaciones(Cuenta cuenta) {

        if (cuenta.getOperaciones().isEmpty()){
            System.out.println("NO SE REALIZARON OPERACIONES");
        }else {
            for (int i = 0; i < cuenta.getOperaciones().size(); i++) {
                Operacion operacion = cuenta.getOperaciones().get(i);
                if (operacion instanceof Transferencia){
                    Transferencia transferencia = (Transferencia) operacion;
                    mostrarTransferencia(transferencia,i);
                }else{
                    if (operacion instanceof Retiro){
                        Retiro retiro = (Retiro) operacion;
                        mostrarRetiro(retiro,i);
                    }else{
                        Deposito deposito = (Deposito) operacion;
                        mostrarDeposito(deposito,i);
                    }

                }
            }
        }
    }

    private void mostrarOpciones() {
        System.out.println("1- Retirar Dinero");
        System.out.println("2- Ingresar Dinero");
        System.out.println("3- Realizar Transferencia");
            System.out.println("4- Mostrar operaciones recientes");
        System.out.println("5- Salir de la cuenta");
    }

    private void mostrarTransferencia(Transferencia transferencia, Integer i){
        System.out.println(i+"- Fecha: "+transferencia.getDate() + " | Monto: $"+ transferencia.getMonto() + " | Titular Destino : "+transferencia.getTitularDestino()+" Sucursal Destino: "+transferencia.getSucursalDestino()+ " | Cuenta Destino: " + transferencia.getNumCtaDestino());
        System.out.println("    Titular Origen: "+ transferencia.getTitularOrigen()+ " | Sucursal Origen: " + transferencia.getSucursalOrigen()+ " | Cuenta Origen: "+transferencia.getNumCuentaOrigen());
    }
    private void mostrarRetiro(Retiro retiro,Integer i){
        System.out.println(i+"- Fecha: "+retiro.getDate() + " | Monto: $"+retiro.getMonto()+" | RETIRO " + retiro.getAgenteRetiro());
    }
    private void mostrarDeposito(Deposito deposito, Integer i){
        System.out.println(i+"- Fecha: "+ deposito.getDate() + " | Monto: $"+ deposito.getMonto()+" | DEPOSITO " + deposito.getAgenteDepositante());
    }

}
