package com.example.services;
import org.springframework.stereotype.Service;

import com.example.entity.Categoria;
import com.example.repository.CategoriaRepository;

@Service
public class CategoriaService extends BaseService<Categoria, Long, CategoriaRepository>{
}
