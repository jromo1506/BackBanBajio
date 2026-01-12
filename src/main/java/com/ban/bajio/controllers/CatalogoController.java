package com.ban.bajio.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ban.bajio.dto.CatalogoDTO;
import com.ban.bajio.services.ProductoProveedorService;

@RestController
@RequestMapping("/api/catalogo")
public class CatalogoController {
    private final ProductoProveedorService productoProveedorService;

    public CatalogoController(ProductoProveedorService productoProveedorService) {
        this.productoProveedorService = productoProveedorService;
    }

    @GetMapping
    public ResponseEntity<List<CatalogoDTO>> obtenerCatalogo() {
        return ResponseEntity.ok(productoProveedorService.obtenerCatalogo());
    }
}
