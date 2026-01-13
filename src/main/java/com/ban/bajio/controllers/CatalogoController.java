package com.ban.bajio.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/filtros")
    public ResponseEntity<List<CatalogoDTO>> filtrar(
            @RequestParam(required = false) Long idTipoProducto,
            @RequestParam(required = false) Boolean esActivo,
            @RequestParam(required = false) String busqueda
    ) {
        return ResponseEntity.ok(
                productoProveedorService.filtrar(idTipoProducto, esActivo, busqueda)
        );
    }
}
