package com.ban.bajio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ban.bajio.models.TipoProducto;
import com.ban.bajio.repository.TipoProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class TipoProductoService {
    private final TipoProductoRepository tipoProductoRepository;

    public TipoProductoService(TipoProductoRepository   tipoProductoRepository) {
        this.tipoProductoRepository = tipoProductoRepository;
    }


    @Transactional
    public List<TipoProducto> listarTipos() {
        return tipoProductoRepository.listarTiposProducto();
    }

    @Transactional
    public void crearTipoProducto(String nombre, String descripcion) {
        tipoProductoRepository.altaBajaTipoProducto(null, nombre, descripcion, "ALTA");
    }

    @Transactional
    public void bajaTipoProducto(Long idTipoProducto) {
        tipoProductoRepository.altaBajaTipoProducto(idTipoProducto, null, null, "BAJA");
    }
}
