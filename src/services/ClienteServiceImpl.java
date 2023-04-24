package services;

import entities.Banco;
import entities.Cliente;
import entities.Cuenta;
import entities.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteServiceImpl implements UsuarioService{
    private Scanner read = new Scanner(System.in).useDelimiter("\n");

    @Override
    public Usuario crearUsuario() {

        Cliente objCliente = new Cliente();

        System.out.println("Ingrese nombre cliente");
        objCliente.setNombre(read.next());
        System.out.println("Ingrese apellido cliente");
        objCliente.setApellido(read.next());
        System.out.println("Ingrese direccion del cliente");
        objCliente.setDireccion(read.next());
        System.out.println("Ingrese telefono del cliente");
        objCliente.setTelefono(read.next());
        System.out.println("Ingrese mail del cliente");
        objCliente.setMail(read.next());

        System.out.println("Ingrese usuario del cliente");
        objCliente.setUsuario(read.next());
        System.out.println("Ingrese contraseña del cliente");
        objCliente.setPassword(read.next());

        objCliente.setNumCuentas(new ArrayList<>());

        return objCliente;
    }

    public Usuario login(String usuarioLogin, String password, List<Usuario> usuarios) {

        Usuario usuarioValido = null;

        for (Usuario usuario : usuarios) {
            if (usuario.getUsuario() == usuarioLogin && usuario.getPassword() == password) {
                usuarioValido=usuario;
                break;
            }
        }
        return usuarioValido;
    }
}

