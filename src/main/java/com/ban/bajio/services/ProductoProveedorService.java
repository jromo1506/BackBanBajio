package com.ban.bajio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ban.bajio.dto.CatalogoDTO;
import com.ban.bajio.repository.ProductoProveedorRepository;
import com.ban.bajio.repository.ProveedorRepository;
import jakarta.transaction.Transactional;

@Service
public class ProductoProveedorService {

    private final ProveedorRepository proveedorRepository;
    
    private final ProductoProveedorRepository productoProveedorRepository;

    public ProductoProveedorService( ProductoProveedorRepository productoProveedorRepository, ProveedorRepository proveedorRepository) {
         this.productoProveedorRepository = productoProveedorRepository;
         this.proveedorRepository = proveedorRepository;
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


   

    public List<CatalogoDTO> obtenerCatalogo() {
        return productoProveedorRepository.obtenerCatalogo();
    }


    @Transactional
    public List<CatalogoDTO> filtrar(
            Long idTipoProducto,
            Boolean esActivo,
            String busqueda
    ) {
        return productoProveedorRepository.filtrarCatalogo(
                idTipoProducto,
                esActivo,
                busqueda
        );
    }
}
