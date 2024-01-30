package org.example;

import org.example.modelos.Cliente;
import org.example.modelos.LineaPedido;
import org.example.modelos.Producto;
import org.example.repositorios.ClienteRepositorio;
import org.example.repositorios.LineaPedidoRepositorio;
import org.example.repositorios.PedidoRepositorio;
import org.example.repositorios.ProductoRepositorio;
import org.example.utilities.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static PedidoRepositorio pedidoRepositorio;
    static ClienteRepositorio clienteRepositorio;
    static ProductoRepositorio productoRepositorio;

    public static void main(String[] args) {
        Session session = HibernateUtil.get().openSession();
        LineaPedidoRepositorio lineaPedidoRepositorio = new LineaPedidoRepositorio(session);
            pedidoRepositorio = new PedidoRepositorio(session);
            clienteRepositorio = new ClienteRepositorio(session);
            productoRepositorio = new ProductoRepositorio(session);

            lineaPedidoRepositorio.mostrarPedidos();
            lineaPedidoRepositorio.mostrarPedidosCliente(1);


            //Hacer pedido
/*
        String res = "";
        List<Integer> cantidades = new ArrayList<>();
        List<Integer> idProductos = new ArrayList<>();
        do {
            int idCliente = pedirInt("Introduce tu ID de cliente");
            Cliente cliente = clienteRepositorio.findByid(idCliente);
            int idProducto = pedirInt("Introduce la id del producto");
            Producto producto = productoRepositorio.findProductoById(idProducto);
            int cant = pedirInt("Introduce la cantidad de producto");

            pedidoRepositorio.addPedidos(cliente,producto,cant);
            res = pedirString("¿Quieres añadir mas lineas al pedido? SI / NO");
        }while (res.equalsIgnoreCase("SI"));
*/

        pedidoRepositorio.borrarPedidos(1);

        session.close();
    }


    public static String pedirString(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        return sc.nextLine();
    }

    public static int pedirInt(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        return sc.nextInt();
    }
}