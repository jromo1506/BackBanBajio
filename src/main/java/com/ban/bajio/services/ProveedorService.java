package com.ban.bajio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ban.bajio.models.Proveedor;
import com.ban.bajio.repository.ProveedorRepository;

import jakarta.transaction.Transactional;

@Service
public class ProveedorService {


    private final ProveedorRepository proveedorRepository;

   
    public ProveedorService(ProveedorRepository proveedorRepository){
        this.proveedorRepository = proveedorRepository;
    }

    @Transactional
    public List<Proveedor> listarProveedores() {
        return proveedorRepository.listarProveedores();
    }

    @Transactional
    public void crearProveedor(String nombre, String descripcion) {
        proveedorRepository.altaBajaProveedor(null, nombre, descripcion, "ALTA");
    }

    @Transactional
    public void bajaProveedor(Long idProveedor) {
        proveedorRepository.altaBajaProveedor(idProveedor, null, null, "BAJA");
    }
}

