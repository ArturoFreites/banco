package services;

import entities.*;
import repository.BancoRepository;

import java.util.List;
import java.util.Scanner;

public class BancoMenuService {

    private Scanner read = new Scanner(System.in);
    private UsuarioMenuService usuarioMenuService = new UsuarioMenuService();
    private EmpleadoMenuService empleadoMenuService= new EmpleadoMenuService();
    private BancoRepository bancoRepository = BancoRepository.obtenerInstancia();



    public void menu(){
        menuBanco();
    }

    private void menuBanco(){
        String salir;
        do {
            menuLogin();
            System.out.println("Desea loguearse con otro usuario de: " + bancoRepository.getBanco().getNombre() + " | S/N");
            salir= read.next();
        }while(salir.equals("S"));
        System.out.println("LOGIN BANCO CERRADO!");
    }

    private void menuLogin(){
        String usuario;
        String password;
        Usuario usuarioValido;
        do{
            System.out.println("Ingrese usuario");
            usuario=read.next();
            System.out.println("Ingrese contraseña");
            password=read.next();
            usuarioValido= login(usuario,password);
            if(usuarioValido==null){
                System.out.println("-- Usuario incorrecto! Intente nuevamente --");
            }
        }while(usuarioValido==null);

        if (usuarioValido instanceof Cliente){
            usuarioMenuService.menu((Cliente) usuarioValido);
        }else{
            empleadoMenuService.menu();
        }
    }

    private Usuario login(String usuarioLogin, String contraseñaLogin) {
        Usuario usuarioValido=null;
        for (Usuario usuario: bancoRepository.getUsuarios()) {
            if (usuario.getUsuario().equals(usuarioLogin) && usuario.getPassword().equals(contraseñaLogin)) {
                usuarioValido=usuario;
                break;
            }
        }
        return usuarioValido;
    }

}
