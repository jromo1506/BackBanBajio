package com.ban.bajio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ban.bajio.models.TipoProducto;

public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {
}