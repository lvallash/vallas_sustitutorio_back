package cibertec.edu.pe.vallas_sustitutorio.controller;

import cibertec.edu.pe.vallas_sustitutorio.model.Categoria;
import cibertec.edu.pe.vallas_sustitutorio.service.CategoriaService;
import cibertec.edu.pe.vallas_sustitutorio.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/util")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UtilController {

  @Autowired
  private CategoriaService categoriaService;

  @GetMapping("/listarCategorias")
  @ResponseBody
  public List<Categoria> listasCategorias() {
    return categoriaService.listarCategorias();
  }




}
