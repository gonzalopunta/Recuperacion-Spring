package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Long>{

}
