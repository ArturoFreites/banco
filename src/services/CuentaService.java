package services;

import entities.Banco;
import entities.Cliente;
import entities.Cuenta;
import entities.Sucursal;
import repository.BancoRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class CuentaService {

    private BancoRepository bancoRepository = BancoRepository.obtenerInstancia();
    private Scanner read= new Scanner(System.in);
    public Cuenta crearCuenta(Cliente cliente) {

        Cuenta objCuenta = new Cuenta();
        System.out.println("Ingrese saldo de la cuenta");
        objCuenta.setSaldo(read.nextDouble());
        objCuenta.setNumCuenta(bancoRepository.getCuentas().size()+1);
        objCuenta.setSucursal(seleccionarSucursal());
        objCuenta.setCliente(cliente);
        objCuenta.setOperaciones(new ArrayList<>());
        return objCuenta;
    }

    private Sucursal seleccionarSucursal() {
        Integer opcion;
        boolean valido=false;
        do{
            mostrarSucursales();
            opcion=read.nextInt();
            valido = opcion<bancoRepository.getSucursales().size()? true : false;

        }while (valido==false);
        return bancoRepository.getSucursales().get(opcion);
    }

    private void mostrarSucursales(){
        System.out.println("Ingrese Sucursal de donde abre la cuenta");
        for (int i = 0; i < bancoRepository.getSucursales().size(); i++) {
            Sucursal sucursal = bancoRepository.getSucursales().get(i);
            System.out.println(i+"- "+ sucursal.getLocalidad());
        }
    }


    public void crearCbu(Cuenta cuenta) {
        Cuenta cuentaCbu= cuenta;
        String idCuenta = String.valueOf(bancoRepository.getIdCuenta(cuenta));
        String idSucursal = String.valueOf(bancoRepository.getIdSucursal(cuenta.getSucursal()));
        String cbu="";
        for (int i = 0; i < 3-idSucursal.length() ; i++) {
            cbu = cbu + "0";
        }
        cbu=cbu+idSucursal;
        for (int i = 0; i < 5-idCuenta.length() ; i++) {
            cbu = cbu + "0";
        }
        cbu=cbu+idCuenta;
        cuentaCbu.setCbu(cbu);
        bancoRepository.updateCuenta(cuentaCbu);
    }
}
