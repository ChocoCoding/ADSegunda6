package org.example.modelos;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cliente")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"pedidosCliente"})
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private int idCliente;

    @NonNull
    private String dni;
    @NonNull
    private String nombre;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Pedido> pedidosCliente;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("idCliente=").append(idCliente);
        sb.append(", dni='").append(dni).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        return sb.toString();
    }


}
