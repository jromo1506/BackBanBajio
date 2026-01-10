package com.ban.bajio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.ban.bajio.models.Producto;
import java.util.List;

public interface ProductoRepository  extends  JpaRepository{
    
    // Listado con filtros (Clave y Tipo Producto)
    @Procedure(name = "sp_listar_productos")
    List<Producto> listarProductos(
            @Param("p_clave") String clave,
            @Param("p_id_tipo_producto") Long idTipoProducto
    );

    // Alta de producto
    @Procedure(name = "sp_insertar_producto")
    void insertarProducto(
            @Param("p_clave") String clave,
            @Param("p_nombre") String nombre,
            @Param("p_precio") Double precio,
            @Param("p_id_tipo_producto") Long idTipoProducto
    );

    // Actualizar producto
    @Procedure(name = "sp_actualizar_producto")
    void actualizarProducto(
            @Param("p_id_producto") Long idProducto,
            @Param("p_nombre") String nombre,
            @Param("p_precio") Double precio,
            @Param("p_id_tipo_producto") Long idTipoProducto,
            @Param("p_es_activo") Boolean esActivo
    );

    // Borrado lógico
    @Procedure(name = "sp_desactivar_producto")
    void desactivarProducto(@Param("p_id_producto") Long idProducto);
}
