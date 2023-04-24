package services;

import entities.*;
import repository.BancoRepository;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class TransferenciaService{

    private Scanner read = new Scanner(System.in);
    private BancoRepository bancoRepository = BancoRepository.obtenerInstancia();

    public TransferenciaService() {
    }

    public Operacion crearTransferencia(Cuenta cuentaOrigen, Double monto, Cuenta cuentaDestino){

        Transferencia transferencia = new Transferencia();
        transferencia.setNumCuentaOrigen(cuentaOrigen.getNumCuenta());
        transferencia.setTitularOrigen(cuentaOrigen.getCliente().getNombre()+" "+cuentaOrigen.getCliente().getApellido());
        transferencia.setSucursalOrigen( cuentaOrigen.getSucursal().getLocalidad());
        transferencia.setDate(new Date());
        transferencia.setMonto(monto);
        transferencia.setTitularDestino(cuentaDestino.getCliente().getNombre()+" " + cuentaDestino.getCliente().getApellido());
        transferencia.setNumCtaDestino(cuentaDestino.getNumCuenta());
        transferencia.setSucursalDestino(cuentaDestino.getSucursal().getLocalidad());
        return transferencia;
    }

    private void realizarOperacionesCuentas(Cuenta cuentaDestino, Cuenta cuentaOrigen, Double monto) {
        Cuenta ctaOrigenActualizada = cuentaOrigen;
        Double ctaSaldo= ctaOrigenActualizada.getSaldo()-monto;
        ctaOrigenActualizada.setSaldo(ctaSaldo);

        bancoRepository.updateCuenta(ctaOrigenActualizada);

        Cuenta ctaDestinoActualizada = cuentaDestino;
        ctaSaldo=ctaDestinoActualizada.getSaldo()+monto;
        ctaDestinoActualizada.setSaldo(ctaSaldo);

        bancoRepository.updateCuenta(ctaDestinoActualizada);

    }

    public void realizarTranferencia(Cuenta cuentaOrigen){
        String cbu;
        Boolean confirmado=false;
        Double monto;
        do{
            System.out.println("Ingrese cbu de la cuenta destino");
            cbu=read.next();
            Cuenta cuentaDestino = obtenerCuentaDestino(cbu);
            Sucursal sucursalDestino = obtenerSucursalDestino(cbu);
            System.out.println("Ingrese monto a transferir");
            monto= read.nextDouble();

            if (monto<=cuentaOrigen.getSaldo()){
                if (cuentaDestino!=null && sucursalDestino!= null){
                    System.out.println("TITULAR DESTINO: " + cuentaDestino.getCliente().getNombre()+ cuentaDestino.getCliente().getApellido());
                    System.out.println("CUENTA DESTINO: " + cuentaDestino.getNumCuenta());
                    System.out.println("SUCURSAL DESTINO: " + cuentaDestino.getSucursal().getLocalidad());
                    bancoRepository.addOperacion(cuentaOrigen,crearTransferencia(cuentaOrigen,monto,cuentaDestino));
                    bancoRepository.addOperacion(cuentaDestino,crearTransferencia(cuentaOrigen,monto,cuentaDestino));
                    System.out.println("TRANSFERENCIA ENVIADA");
                    realizarOperacionesCuentas(cuentaDestino,cuentaOrigen,monto);
                    confirmado=true;
                }
                else{
                    System.out.println("CBU INVALIDO!");
                }
            }else {
                System.out.println("Su saldo no es suficiente!!");
            }
        }while (confirmado==false);
    }

    private Sucursal obtenerSucursalDestino(String cbu) {
        String idSucursal="";
        for (int i = 0; i <3 ; i++) {
            idSucursal=idSucursal.concat(String.valueOf(cbu.charAt(i)));

        }
        try{
            return bancoRepository.getSucursales().get(Integer.parseInt(idSucursal));
        }catch (Exception e){
            return null;
        }
    }

    private Cuenta obtenerCuentaDestino(String cbu) {
        String numCuenta="";
        for (int i = 3; i <cbu.length() ; i++) {
            numCuenta=numCuenta.concat(String.valueOf(cbu.charAt(i)));
        }
        try{
            return bancoRepository.getCuentas().get(Integer.parseInt(numCuenta));
        }catch (Exception e){
            return null;
        }

    }
}
