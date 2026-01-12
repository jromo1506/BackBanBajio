package com.ban.bajio.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter

@NoArgsConstructor
public class ProductoDTO {
   private Long idProducto;
    private String clave;
    private String nombreProducto;
    private BigDecimal precio;
    private Long idTipoProducto;
    private String tipoProducto;
    private Boolean esActivo;

    // Constructor
    public ProductoDTO(Long idProducto, String clave, String nombreProducto, BigDecimal precio, Long idTipoProducto, String tipoProducto, Boolean esActivo) {
        this.idProducto = idProducto;
        this.clave = clave;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.idTipoProducto = idTipoProducto;
        this.tipoProducto = tipoProducto;
        this.esActivo = esActivo;
    }

    // getters y setters
}
