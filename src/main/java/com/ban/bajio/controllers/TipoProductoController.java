package com.ban.bajio.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ban.bajio.models.TipoProducto;
import com.ban.bajio.services.TipoProductoService;


@RestController
@RequestMapping("/api/tipos-producto")
public class TipoProductoController {
    
    private final TipoProductoService tipoProductoService;

    public TipoProductoController(TipoProductoService tipoProductoService) {
        this.tipoProductoService = tipoProductoService;
    }


 
    // Listar todos los tipos de producto
    @GetMapping
    public ResponseEntity<List<TipoProducto>> listarTipos() {
        return ResponseEntity.ok(tipoProductoService.listarTipos());
    }

    // Crear tipo de producto
    @PostMapping
    public ResponseEntity<Void> crearTipo(@RequestBody TipoProducto tipoProducto) {
        tipoProductoService.crearTipoProducto(tipoProducto.getNombre(), tipoProducto.getDescripcion());
        return ResponseEntity.ok().build();
    }

    // Dar de baja tipo de producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> bajaTipo(@PathVariable Long id) {
        tipoProductoService.bajaTipoProducto(id);
        return ResponseEntity.ok().build();
    }
}
