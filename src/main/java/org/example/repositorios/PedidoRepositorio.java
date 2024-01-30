package org.example.repositorios;

import org.example.modelos.Cliente;
import org.example.modelos.LineaPedido;
import org.example.modelos.Pedido;
import org.example.modelos.Producto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PedidoRepositorio {

    private Session session;



    public PedidoRepositorio(Session session){
        this.session = session;
    }

    public void addPedidos(Cliente cliente, Producto producto, Integer cant){
        Transaction trx = session.beginTransaction();
        Pedido pedido = new Pedido(cliente,new Date());

        LineaPedido lineaPedido = new LineaPedido(pedido,producto,cant);

        pedido.addListaPedidos(lineaPedido);
        session.save(pedido);

        trx.commit();
    }


    public void borrarPedidos(int idPedido){
        Pedido pedido = findById(idPedido);
        Transaction trx = session.beginTransaction();
        session.remove(pedido);
        System.out.println("Se ha eliminado el pedido");
        trx.commit();
    }


    public Pedido findById(int idPedido){
        Transaction trx = session.beginTransaction();
        Query query = this.session.createQuery("select p from Pedido p where p.idPedido=:idPedido");
        query.setParameter("idPedido", idPedido);
        Pedido pedido = (Pedido) query.getSingleResult();
        trx.commit();
        return pedido;
    }

    public String pedirString(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        return sc.nextLine();
    }

    public int pedirInt(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        return sc.nextInt();
    }



}
