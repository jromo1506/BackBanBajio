package com.ban.bajio.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping
    public List<TipoProducto> listarTipos() {
        return tipoProductoService.listarTodos();
    }
}
