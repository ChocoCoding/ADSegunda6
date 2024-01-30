package org.example.repositorios;

import org.example.modelos.Cliente;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteRepositorio {
    private Session session;
    public ClienteRepositorio(Session session){
        this.session = session;
    }

    public Cliente findByid(int idCliente){
        Transaction trx = session.beginTransaction();
        Cliente cliente = (Cliente) session.createQuery("SELECT c FROM Cliente c WHERE idCliente =: idCliente").setParameter("idCliente",idCliente).getSingleResult();
        trx.commit();
        return cliente;
    }
}
