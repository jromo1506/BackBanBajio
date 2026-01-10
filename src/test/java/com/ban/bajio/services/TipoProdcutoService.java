package com.ban.bajio.services;

import java.util.List;

import com.ban.bajio.models.TipoProducto;
import com.ban.bajio.repository.TipoProductoRepository;

public class TipoProdcutoService {
    private final TipoProductoRepository tipoProductoRepository;

    public TipoProdcutoService(TipoProductoRepository   tipoProductoRepository) {
        this.tipoProductoRepository = tipoProductoRepository;
    }


    public List<TipoProducto> listarTodos() {
        return tipoProductoRepository.findAll();
    }
}
