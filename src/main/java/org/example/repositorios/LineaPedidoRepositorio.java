package org.example.repositorios;

import org.example.modelos.LineaPedido;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LineaPedidoRepositorio {

    private Session session;
    public LineaPedidoRepositorio(Session session){
        this.session = session;
    }

    public void mostrarPedidos(){
        Transaction trx = session.beginTransaction();
        List<LineaPedido> pedidos = session.createQuery("SELECT l FROM LineaPedido l").getResultList();
        for (LineaPedido l: pedidos) {
            System.out.println(l);
        }

        trx.commit();
    }


    public void mostrarPedidosCliente(int idCliente){
        Transaction trx = session.beginTransaction();
        List<LineaPedido> pedidosCliente = session.createQuery("SELECT l FROM LineaPedido l WHERE l.pedido.cliente.idCliente =: idCliente").setParameter("idCliente",idCliente).getResultList();
        for (LineaPedido l: pedidosCliente) {
            System.out.println(l);
        }

        trx.commit();
    }


}
