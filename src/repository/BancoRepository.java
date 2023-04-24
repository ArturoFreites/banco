package repository;

import entities.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BancoRepository {
    private static BancoRepository instancia = null;
    private Banco banco;

    private BancoRepository() {
    }

    public static BancoRepository obtenerInstancia() {
        if (instancia == null) {
            instancia = new BancoRepository();
        }
        return instancia;
    }

    public void cargarBanco(Banco banco) {
        this.banco = banco;
    }

    public Banco getBanco() {
        return banco;
    }
    public List<Usuario> getUsuarios(){
        return banco.getUsuarios();
    }
    public List<Sucursal> getSucursales() {
        return banco.getSucursales();
    }


    public void addUsuario(Usuario usuario){
        List<Usuario> usuarios = banco.getUsuarios();
        usuarios.add(usuario);
        banco.setUsuarios(usuarios);
    }

    public Usuario getUsuarioId(Integer idUsuario){
        return banco.getUsuarios().get(idUsuario);
    }

    public List<Cliente> getClientes(){

        List<Cliente> clientes= new ArrayList<>();
        for (Usuario usuario : banco.getUsuarios()) {
            if (usuario instanceof Cliente){
                clientes.add((Cliente) usuario);
            }
        }
        return clientes;
    }

    public List<Cuenta> getCuentasCliente(Cliente cliente) {
        List<Integer>numCuentas= cliente.getNumCuentas();
        List<Cuenta> cuentas= new ArrayList<>();
        for (Integer numCuenta:numCuentas) {
            for (Cuenta cuenta: banco.getCuentas()) {
                if (cuenta.getNumCuenta().equals(numCuenta)){
                    cuentas.add(cuenta);
                }
            }
        }
        return cuentas;
    }

    public List<Cuenta> getCuentas() {
        return banco.getCuentas();
    }
    public void addCuenta(Cuenta cuenta){
        List<Cuenta> cuentas= banco.getCuentas();
        cuentas.add(cuenta);
        banco.setCuentas(cuentas);
    }

    public void addCuentaCliente(Cliente cliente, Integer numCuenta){
        List<Integer> cuentas = cliente.getNumCuentas();
        cuentas.add(numCuenta);
        cliente.setNumCuentas(cuentas);
        Usuario usuario = cliente;
        Integer idCliente = getUsuarios().indexOf(usuario);
        List<Usuario> usuarios = getUsuarios();
        usuarios.set(idCliente,usuario);
        banco.setUsuarios(usuarios);
    }

    public void updateCuenta(Cuenta cuenta) {
        Integer idCuenta = getCuentas().indexOf(cuenta);
        List<Cuenta> cuentas = getCuentas();
        cuentas.set(idCuenta,cuenta);
        banco.setCuentas(cuentas);
    }

    private List<Operacion> getOperaciones(Cuenta cuenta) {
        Integer idCuenta = getCuentas().indexOf(cuenta);
        Cuenta objCuenta = banco.getCuentas().get(idCuenta);
        return objCuenta.getOperaciones();
    }

    public void addOperacion(Cuenta cuenta, Operacion operacion) {
        Integer idCuenta = getCuentas().indexOf(cuenta);
        List<Operacion> operacionesList = getOperaciones(cuenta);
        operacionesList.add(operacion);
        updateCuenta(cuenta);
    }

    public Integer getIdCuenta(Cuenta cuenta){
        List<Cuenta> cuentas = getCuentas();
        return cuentas.indexOf(cuenta);
    }

    public Integer getIdSucursal(Sucursal sucursal){
        List<Sucursal> sucursales = getSucursales();
        return sucursales.indexOf(sucursal);
    }


}
