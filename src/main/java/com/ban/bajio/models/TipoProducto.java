package com.ban.bajio.models;

import jakarta.persistence.*;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tipo_producto")
public class TipoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_producto")
    private Long idTipoProducto;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @OneToMany(mappedBy = "tipoProducto")
    @JsonIgnore
    private List<Producto> productos;

}