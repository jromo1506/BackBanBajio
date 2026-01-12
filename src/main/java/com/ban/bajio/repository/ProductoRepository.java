package com.ban.bajio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.ban.bajio.dto.ProductoDTO;
import com.ban.bajio.models.Producto;

import java.math.BigDecimal;
import java.util.List;


public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Listado con filtros (Clave y Tipo Producto)


   
    @Query(value = "CALL sp_listar_productos()", nativeQuery = true)
    List<Object[]> listarProductosConTipo();
    

    // Alta de producto
    @Procedure(procedureName = "sp_insertar_producto")
        void insertarProducto(
        @Param("p_clave") String clave,
        @Param("p_nombre") String nombre,
        @Param("p_precio") BigDecimal precio,
        @Param("p_id_tipo_producto") Long idTipoProducto
        );

    // Actualizar producto
    @Procedure(procedureName = "sp_actualizar_producto")
    void actualizarProducto(
            @Param("p_id_producto") Long idProducto,
            @Param("p_nombre") String nombre,
            @Param("p_precio") Double precio,
            @Param("p_id_tipo_producto") Long idTipoProducto,
            @Param("p_es_activo") Boolean esActivo
    );

    // Borrado lógico
    @Procedure(procedureName = "sp_desactivar_producto")
    void desactivarProducto(
            @Param("p_id_producto") Long idProducto
    );


    //Borrado cascada
     @Procedure(procedureName = "sp_borrar_producto")
    void borrarProducto(Long p_id_producto);



}