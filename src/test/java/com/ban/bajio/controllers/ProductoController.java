package com.ban.bajio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ban.bajio.models.Producto;
import com.ban.bajio.services.ProductoService;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/prouctos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("")
    public ResponseEntity<List<Producto>> listarProductos(@RequestParam String clave,@RequestParam Long idTipoProducto) {
        return ResponseEntity.ok(
            productoService.listarProductos(clave, idTipoProducto);
        );
    }

    @PostMapping("")
    public ResponseEntity<Void> crearProducto(@RequestBody Producto producto) {
        productoService.crearProducto(producto);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("")
    public ResponseEntity<Void> actualizarProducto(@PathVariable Long id, @RequestBody Producto entity) {
        this.productoService.actualizarProducto(id ,entity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id){
        this.productoService.eliminarProducto(id);
        return ResponseEntity.ok().build();
    }
    
    
}
