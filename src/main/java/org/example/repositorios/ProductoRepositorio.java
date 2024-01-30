package org.example.repositorios;

import org.example.modelos.LineaPedido;
import org.example.modelos.Producto;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductoRepositorio {

    private Session session;
    public ProductoRepositorio(Session session){
        this.session = session;
    }

    public Producto findProductoById(int idProducto){
       Transaction trx = session.beginTransaction();
       Producto producto = (Producto) session.createQuery("SELECT p FROM Producto p WHERE p.idProducto = :idProducto").setParameter("idProducto",idProducto).getSingleResult();
       trx.commit();
       return producto;




    }

}
