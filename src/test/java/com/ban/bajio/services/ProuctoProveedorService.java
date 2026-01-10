package com.ban.bajio.services;

import org.springframework.stereotype.Service;

import com.ban.bajio.repository.ProductoProveedorRepository;

import jakarta.transaction.Transactional;

@Service
public class ProuctoProveedorService {
    
    private final ProductoProveedorRepository productoProveedorRepository;

    public ProuctoProveedorService( ProductoProveedorRepository productoProveedorRepository) {
         this.productoProveedorRepository = productoProveedorRepository;
    }

    
    @Transactional
    public Object listarProveedoresPorProducto(Long idProducto) {
        return productoProveedorRepository.listarPorProducto(idProducto);
    }

    @Transactional
    public void agregarProveedor(
            Long idProducto,
            Long idProveedor,
            String claveProveedor,
            Double costo
    ) {
        productoProveedorRepository.insertarProductoProveedor(
                idProducto,
                idProveedor,
                claveProveedor,
                costo
        );
    }

    @Transactional
    public void quitarProveedor(Long idProductoProveedor) {
        productoProveedorRepository.eliminarProductoProveedor(idProductoProveedor);
    }
}
