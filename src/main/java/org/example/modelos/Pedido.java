package org.example.modelos;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"lineaPedidosPedidos","cliente"})
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedido")
    private int idPedido;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @NonNull
    private Date fecha;

    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL)
    private List<LineaPedido> lineaPedidosPedidos = new ArrayList<>();

    public Pedido(Cliente cliente, Date date) {
        this.cliente = cliente;
        this.fecha = date;
    }

    public void addListaPedidos(LineaPedido lineaPedido){
        this.lineaPedidosPedidos.add(lineaPedido);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pedido{");
        sb.append("idPedido=").append(idPedido);
        sb.append(", cliente=").append(cliente);
        sb.append(", fecha=").append(fecha);
        return sb.toString();
    }
}
