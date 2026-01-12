package com.ban.bajio.dto;

import java.math.BigDecimal;

public interface CatalogoDTO {

    Long getIdProducto();
    String getClaveProducto();
    String getNombreProducto();
    BigDecimal getPrecio();
    Boolean getEsActivo();

    Long getIdProductoProveedor();
    String getClaveProveedor();
    BigDecimal getCosto();

    Long getIdProveedor();
    String getNombreProveedor();
}