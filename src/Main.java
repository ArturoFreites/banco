import com.sun.deploy.net.MessageHeader;
import entities.*;
import enums.Cargo;
import repository.BancoRepository;
import services.BancoMenuService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        BancoMenuService bancoMenuService = new BancoMenuService();
        BancoRepository bancoRepository = BancoRepository.obtenerInstancia();
        bancoRepository.cargarBanco(cargaBancoEjemplo());
        System.out.println("---- "+bancoRepository.getBanco().getNombre().toUpperCase()+" ---- ");
        bancoMenuService.menu();

    }
    public static Banco cargaBancoEjemplo() {
        Banco banco = new Banco("Banco Nacion",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());

        Sucursal objSucursal1 = new Sucursal("Lezama", "2242-432303");
        Sucursal objSucursal2 = new Sucursal("La Plata", "2242-432303");

        List<Sucursal> sucursales = banco.getSucursales();
        sucursales.add(objSucursal1);
        sucursales.add(objSucursal2);

        banco.setSucursales(sucursales);

        Usuario objEmpleado1 = new Empleado("Roman","0choa","San Martin 122","2241-434321","luisarturofreites@gmail.com","empleado1","12345", Cargo.VENTAS);
        List<Usuario> usuarios = banco.getUsuarios();
        usuarios.add(objEmpleado1);
        banco.setUsuarios(usuarios);
        return banco;
    }

}