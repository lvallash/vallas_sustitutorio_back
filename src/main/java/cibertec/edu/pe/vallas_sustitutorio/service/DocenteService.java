package cibertec.edu.pe.vallas_sustitutorio.service;

import cibertec.edu.pe.vallas_sustitutorio.model.Docente;

import cibertec.edu.pe.vallas_sustitutorio.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteService {

	@Autowired
	private DocenteRepository repository;

	public Docente insertarActualizarDocente(Docente docente) {
		return repository.save(docente);
	}

	public List<Docente> listaDocentePorNombreLike(String nombre) {
		return repository.listarPorNombreLike(nombre);
	}
	public void eliminaDocente(int idDocente) {
		repository.deleteById(idDocente);
	}



}
