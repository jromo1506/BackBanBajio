package com.ban.bajio.services;

import java.util.List;

import com.ban.bajio.models.Proveedor;
import com.ban.bajio.repository.ProveedorRepository;

public class ProveedorService {


    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }


    public List<Proveedor> listarTodos() {
        return proveedorRepository.findAll();
    }
}
