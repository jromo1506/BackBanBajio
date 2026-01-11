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

import com.ban.bajio.models.Proveedor;
import com.ban.bajio.services.ProveedorService;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    // Listar todos los proveedores
    @GetMapping
    public ResponseEntity<List<Proveedor>> listarProveedores() {
        List<Proveedor> proveedores = proveedorService.listarProveedores();
        return ResponseEntity.ok(proveedores);
    }

    // Crear un proveedor
    @PostMapping
    public ResponseEntity<Void> crearProveedor(@RequestBody Proveedor proveedor) {
        proveedorService.crearProveedor(proveedor.getNombre(), proveedor.getDescripcion());
        return ResponseEntity.ok().build();
    }

    // Dar de baja un proveedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> bajaProveedor(@PathVariable Long id) {
        proveedorService.bajaProveedor(id);
        return ResponseEntity.ok().build();
    }
}
