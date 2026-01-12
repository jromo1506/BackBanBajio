package com.ban.bajio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ban.bajio.dto.CatalogoDTO;
import com.ban.bajio.repository.ProductoProveedorRepository;
import com.ban.bajio.services.ProductoProveedorService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/productos/{idProducto}/proveedores")
public class ProductoProveedorController {
      private final ProductoProveedorService productoProveedorService;

    public ProductoProveedorController(ProductoProveedorService productoProveedorService) {
       this.productoProveedorService = productoProveedorService;
    }

    @GetMapping
    public ResponseEntity<?> listarProveedores(@PathVariable Long idProducto) {
        return ResponseEntity.ok(
                productoProveedorService.listarProveedoresPorProducto(idProducto)
        );
    }




    // 🔹 Agregar proveedor a producto
    @PostMapping
    public ResponseEntity<Void> agregarProveedor(
           @PathVariable Long idProducto,
            @RequestParam Long idProveedor,
            @RequestParam String claveProveedor,
            @RequestParam Double costo
    ) {
        productoProveedorService.agregarProveedor(
                idProducto,
                idProveedor,
                claveProveedor,
                costo
        );
        return ResponseEntity.ok().build();
    }


     // 🔹 Quitar proveedor
    @DeleteMapping("/{idProductoProveedor}")
    public ResponseEntity<Void> quitarProveedor(
            @PathVariable Long idProductoProveedor
    ) {
        productoProveedorService.quitarProveedor(idProductoProveedor);
        return ResponseEntity.ok().build();
    }

    
}
