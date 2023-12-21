package cibertec.edu.pe.vallas_sustitutorio.service;

import cibertec.edu.pe.vallas_sustitutorio.repository.CategoriaRepository;
import cibertec.edu.pe.vallas_sustitutorio.model.Categoria;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository categoriaRepository;


  public List<Categoria> listarCategorias() {
    return categoriaRepository.findAll();
  }
}
