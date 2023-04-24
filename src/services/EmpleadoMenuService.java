package services;

import entities.Banco;
import entities.Cliente;
import entities.Cuenta;
import entities.Usuario;
import repository.BancoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpleadoMenuService {
    private BancoRepository bancoRepository = BancoRepository.obtenerInstancia();
    private CuentaService cuentaService = new CuentaService();
    private ClienteServiceImpl clienteService = new ClienteServiceImpl();
    private Scanner read = new Scanner(System.in);

    public EmpleadoMenuService() {
    }

    public void menu(){
        menuEmpleado();
    }
    private void menuEmpleado() {
        int op;

        do{
            System.out.println("---------- MENU EMPLEADO ----------");
            mostrarOpciones();
            System.out.println("Ingrese opcion:");
            op= read.nextInt();
            switch (op){
                case 1 :
                    crearCliente();
                    break;
                case 2 :
                    crearCuentas();
                    break;
                case 3 :
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ingrese una opcion correcta!");
            }
        }while(op!=3);
    }

    private void crearCuentas() {
        Boolean salir;
        Integer idCliente;
        List<Cliente> clientes= bancoRepository.getClientes();
        do {
            mostrarClientes();
            if(clientes.isEmpty()){
                System.out.println("NO HAY CLIENTES DISPONIBLES");
                salir=true;
            }else{
                idCliente = read.nextInt();
                Cliente cliente = clientes.get(idCliente);
                crearCuenta(cliente);
                salir=true;
            }
        }while (salir=false);
    }

    private void crearCuenta(Cliente cliente) {
        Cuenta cuenta = cuentaService.crearCuenta(cliente);
        bancoRepository.addCuenta(cuenta);
        bancoRepository.addCuentaCliente(cliente,cuenta.getNumCuenta());
        cuentaService.crearCbu(cuenta);
    }

    private void crearCliente() {
        bancoRepository.addUsuario(clienteService.crearUsuario());
    }

    private void mostrarOpciones() {
        System.out.println("1-Crear Cliente");
        System.out.println("2-Crear cuenta bancaria");
        System.out.println("3-Salir");
    }

    private void mostrarClientes() {
        System.out.println("Seleccione a que Cliente quiere agregarle una cuenta");
        List<Cliente> clientes = bancoRepository.getClientes();
            for (int i = 0; i < clientes.size(); i++) {
                Cliente cliente= clientes.get(i);
                System.out.println(i+" - "+cliente.getNombre()+" "+cliente.getApellido());
            }
    }


}
