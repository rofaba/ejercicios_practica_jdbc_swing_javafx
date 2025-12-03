package org.example;

import org.example.modelo.Producto;
import org.example.modelo.Tienda;
import org.example.service.BodegaService;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");


        BodegaService bs = new BodegaService();

        Tienda mmk = new Tienda("MediaMarkt", "Málaga");
        Tienda fnac = new Tienda("Fnac", "Madrid");
        Tienda elcorte = new Tienda("El Corte Inglés", "Barcelona");

        Producto ps = new Producto("PlayStation5", 550.0);
        Producto nes = new Producto("Nintendo Switch", 300.0);
        Producto mbp = new Producto("Macbook Pro", 1500.0);

        bs.guardarProducto(ps);
        bs.guardarProducto(nes);
        bs.guardarProducto(mbp);
        bs.guardarTienda(mmk);
        bs.guardarTienda(fnac);
        bs.guardarTienda(elcorte);

        bs.registrarProductoEnTienda(ps, mmk.getId());
        bs.registrarProductoEnTienda(nes, mmk.getId());
        bs.registrarProductoEnTienda(mbp, fnac.getId());

        System.out.println("Operations completed successfully.");
        List<Tienda> tiendas = bs.getAllTiendas();

        for (Tienda t : tiendas) {
            System.out.println("Tienda: " + t.getName() + " en " + t.getCity());
            for (Producto p : t.getProducts()) {
                System.out.println(" - Producto: " + p.getName() + " por $" + p.getPrice());
            }
        }

        //bs.eliminarTienda(fnac);
    }
}