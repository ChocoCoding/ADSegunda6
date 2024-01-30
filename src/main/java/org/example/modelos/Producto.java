package org.example.modelos;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "producto")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"lineaPedidosProductos"})
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private int idProducto;

    @NonNull
    private String nombre;
    @NonNull
    private String descripcion;
    @NonNull
    private double precio;
    @NonNull
    private String imagen;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    List<LineaPedido> lineaPedidosProductos = new ArrayList<>();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Producto{");
        sb.append("idProducto=").append(idProducto);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append(", precio=").append(precio);
        sb.append(", imagen='").append(imagen).append('\'');
        return sb.toString();
    }
}
