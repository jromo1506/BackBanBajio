package com.ban.bajio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.ban.bajio.models.TipoProducto;

public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {
  @Procedure(procedureName = "sp_alta_baja_tipo_producto")
    void altaBajaTipoProducto(
        @Param("p_id_tipo_producto") Long idTipoProducto,
        @Param("p_nombre") String nombre,
        @Param("p_descripcion") String descripcion,
        @Param("p_accion") String accion
    );

    @Procedure(procedureName = "sp_listar_tipos_producto")
    List<TipoProducto> listarTiposProducto();

}