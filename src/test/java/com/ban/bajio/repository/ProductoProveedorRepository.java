package com.ban.bajio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.ban.bajio.models.ProductoProveedor;

public interface ProductoProveedorRepository extends JpaRepository<ProductoProveedor, Long> {

    // Proveedores asociados a un producto
    @Procedure(name = "sp_listar_proveedores_por_producto")
    List<ProductoProveedor> listarPorProducto(
            @Param("p_id_producto") Long idProducto
    );

    // Asociar proveedor a producto
    @Procedure(name = "sp_insertar_producto_proveedor")
    void insertarProductoProveedor(
            @Param("p_id_producto") Long idProducto,
            @Param("p_id_proveedor") Long idProveedor,
            @Param("p_clave_proveedor") String claveProveedor,
            @Param("p_costo") Double costo
    );

    // Quitar proveedor de producto
    @Procedure(name = "sp_eliminar_producto_proveedor")
    void eliminarProductoProveedor(
            @Param("p_id_producto_proveedor") Long idProductoProveedor
    );
}