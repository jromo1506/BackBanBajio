package com.ban.bajio.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.ban.bajio.dto.ProductoDTO;
import com.ban.bajio.dto.ProductoRequest;
import com.ban.bajio.models.Producto;
import com.ban.bajio.models.TipoProducto;
import com.ban.bajio.repository.ProductoRepository;

import jakarta.transaction.Transactional;
import tools.jackson.databind.ObjectMapper;

@Service
public class ProductoService {

    

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;

    }
    /*
    
    
    */
 
    public List<ProductoDTO> listarProductos() {
        List<Object[]> results = productoRepository.listarProductosConTipo();

        return results.stream().map(r -> new ProductoDTO(
                ((Number) r[0]).longValue(),   // id_producto
                (String) r[1],                 // clave
                (String) r[2],                 // nombre_producto
                (BigDecimal) r[3],             // precio
                ((Number) r[4]).longValue(),   // id_tipo_producto
                (String) r[5],                 // tipo_producto
                (Boolean) r[6]                 // es_activo
        )).toList();
    }


    @Transactional
   public void crearProducto(ProductoRequest req) {

    productoRepository.insertarProducto(
        req.getClave(),
        req.getNombre(),
        req.getPrecio(),
        req.getIdTipoProducto() // ✅ Long directo
    );
}


  @Transactional
public void actualizarProducto(Long idProducto, ProductoRequest req) {

    Producto producto = productoRepository.findById(idProducto)
        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

    producto.setClave(req.getClave());
    producto.setNombre(req.getNombre());
    producto.setPrecio(req.getPrecio());
    producto.setEsActivo(req.getEstatus());

    // 🔥 NO LEAS tipoProducto, SOLO SETÉALO
    if (req.getIdTipoProducto() != null) {
        TipoProducto tipo = new TipoProducto();
        tipo.setIdTipoProducto(req.getIdTipoProducto());
        producto.setTipoProducto(tipo);
    } else {
        producto.setTipoProducto(null);
    }

    productoRepository.save(producto);
}

    @Transactional
    public void eliminarProducto(Long idProducto) {
        productoRepository.desactivarProducto(idProducto);
    }

    @Transactional
    public void eliminarProductoCascade(Long idProducto) {
       productoRepository.borrarProducto(idProducto);
    }

}
