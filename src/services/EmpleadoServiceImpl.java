package services;

import entities.Cliente;
import entities.Cuenta;
import entities.Empleado;
import entities.Usuario;
import enums.Cargo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpleadoServiceImpl implements UsuarioService{

    Scanner read = new Scanner(System.in);
    @Override
    public Usuario crearUsuario() {
        Empleado objEmpleado = new Empleado();

        System.out.println("Ingrese nombre empleado");
        objEmpleado.setNombre(read.next());
        System.out.println("Ingrese apellido empleado");
        objEmpleado.setApellido(read.next());
        System.out.println("Ingrese direccion del empleado");
        objEmpleado.setDireccion(read.next());
        System.out.println("Ingrese telefono del empleado");
        objEmpleado.setTelefono(read.next());
        System.out.println("Ingrese mail del empleado");
        objEmpleado.setMail(read.next());

        System.out.println("Ingrese mail del usuario");
        objEmpleado.setMail(read.next());

        System.out.println("Ingrese mail del empleado");
        objEmpleado.setMail(read.next());

        objEmpleado.setCargo(Cargo.VENTAS);

        return objEmpleado;
    }

}
