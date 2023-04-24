package services;

import entities.Cliente;
import entities.Cuenta;
import entities.Usuario;
import repository.BancoRepository;

import java.util.List;
import java.util.Scanner;

public class UsuarioMenuService {

    private Scanner read = new Scanner(System.in);
    private CuentaMenuService cuentaMenuService = new CuentaMenuService();
    private BancoRepository bancoRepository = BancoRepository.obtenerInstancia();

    public void menu(Cliente clienteOperar){
        menuCliente(clienteOperar);
    }
    private void menuCliente(Cliente clienteOperar) {

        int numCuenta;
        boolean salir =false;
        boolean cuentaValida=false;
        List<Cuenta> cuentas = bancoRepository.getCuentasCliente(clienteOperar);

        System.out.println("-----------------------------------");
        System.out.println("Bienvenido " + clienteOperar.getNombre()+" "+clienteOperar.getApellido()+ "!");
        System.out.println("-----------------------------------");
        do{
            bancoRepository.getCuentasCliente(clienteOperar);
            if (cuentas.isEmpty()) {
                System.out.println("NO TIENE CUENTAS");
                System.out.println("Saliendo!");
                salir=true;}
            else{
                mostrarCuentas(cuentas);
                numCuenta=read.nextInt();
                if (numCuenta>=cuentas.size()){
                    System.out.println("Ingrese una cuenta valida!");
                } else{
                    cuentaMenuService.menu(cuentas.get(numCuenta));
                    System.out.println("Desea continuar con otra cuenta? S/N");
                    salir = read.next().equals("N")? true : false;
                }
            }


        }while(salir==false);
        System.out.println("SESSION CERRADA");

    }

    private void mostrarCuentas( List<Cuenta> cuentas ){
        System.out.println("Ingrese numero de cuenta con la quiere operar");
        for (int i = 0; i < cuentas.size() ; i++) {
            Cuenta cuenta = cuentas.get(i);
            System.out.println(i+"- Cuenta: " + cuenta.getNumCuenta() + " | Saldo: $" + cuenta.getSaldo() );
        }
    }

}
