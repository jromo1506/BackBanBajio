package com.ban.bajio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ban.bajio.models.Producto;
import com.ban.bajio.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

   @Transactional
    public List<Producto> listarProductos(String clave, Long idTipoProducto) {
        return productoRepository.listarProductos(clave, idTipoProducto);
    }

    @Transactional
    public void crearProducto(Producto producto) {
        productoRepository.insertarProducto(
                producto.getClave(),
                producto.getNombre(),
                producto.getPrecio().doubleValue(),
                producto.getTipoProducto().getIdTipoProducto()
        );
    }

    @Transactional
    public void actualizarProducto(Long idProducto, Producto producto) {
        productoRepository.actualizarProducto(
                idProducto,
                producto.getNombre(),
                producto.getPrecio().doubleValue(),
                producto.getTipoProducto().getIdTipoProducto(),
                producto.getEsActivo()
        );
    }

    @Transactional
    public void eliminarProducto(Long idProducto) {
        productoRepository.desactivarProducto(idProducto);
    }
    
}
