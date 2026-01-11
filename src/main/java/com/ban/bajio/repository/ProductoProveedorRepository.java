package com.ban.bajio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.ban.bajio.models.ProductoProveedor;

public interface ProductoProveedorRepository extends JpaRepository<ProductoProveedor, Long> {

    @Procedure(procedureName = "sp_listar_proveedores_por_producto")
    List<ProductoProveedor> listarPorProducto(
            @Param("p_id_producto") Long idProducto
    );

    @Procedure(procedureName = "sp_insertar_producto_proveedor")
    void insertarProductoProveedor(
            @Param("p_id_producto") Long idProducto,
            @Param("p_id_proveedor") Long idProveedor,
            @Param("p_clave_proveedor") String claveProveedor,
            @Param("p_costo") Double costo
    );

    @Procedure(procedureName = "sp_eliminar_producto_proveedor")
    void eliminarProductoProveedor(
            @Param("p_id_producto_proveedor") Long idProductoProveedor
    );
}