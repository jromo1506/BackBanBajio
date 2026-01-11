package com.ban.bajio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.ban.bajio.models.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    @Procedure(procedureName = "sp_alta_baja_proveedor")
    void altaBajaProveedor(
        @Param("p_id_proveedor") Long id,
        @Param("p_nombre") String nombre,
        @Param("p_descripcion") String descripcion,
        @Param("p_accion") String accion
    );


     @Procedure(procedureName = "sp_listar_proveedores")
    List<Proveedor> listarProveedores();
}