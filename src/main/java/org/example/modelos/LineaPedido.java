package org.example.modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lineapedido")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"producto","pedido"})
public class LineaPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLineaPedido")
    private int idLineaPedido;
    @NonNull
    private int cantidad;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idPedido")
    private Pedido pedido;

    public LineaPedido(Pedido pedido, Producto producto, Integer cant) {
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cant;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LineaPedido{");
        sb.append("idLineaPedido=").append(idLineaPedido);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", producto=").append(producto.getIdProducto());
        sb.append(", pedido=").append(pedido.getIdPedido());
        return sb.toString();
    }
}
