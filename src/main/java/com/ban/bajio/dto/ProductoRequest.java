package com.ban.bajio.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductoRequest {
    private String clave;
    private String nombre;
    private BigDecimal precio;
    private Long idTipoProducto;
    private String estatus;
}
