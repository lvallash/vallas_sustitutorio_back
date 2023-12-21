package cibertec.edu.pe.vallas_sustitutorio.controller;


import cibertec.edu.pe.vallas_sustitutorio.util.Constantes;
import cibertec.edu.pe.vallas_sustitutorio.model.Docente;
import cibertec.edu.pe.vallas_sustitutorio.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/docente")
@CrossOrigin(origins = "http://localhost:4200")
public class DocenteController {

	@Autowired
	private DocenteService service;


	@GetMapping("/listarDocente/{nom}")
	@ResponseBody
	public ResponseEntity<List<Docente>> listarDocentePorNombreLike(@PathVariable("nom") String nom) {
		List<Docente> lista  = null;
		try {
			if (nom.equals("todos")) {
				lista = service.listaDocentePorNombreLike("%");
			}else {
				lista = service.listaDocentePorNombreLike("%" + nom + "%");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}

	@PostMapping("/registrarDocente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertarDocente(@RequestBody Docente obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIddocente(0);


			Docente objSalida =  service.insertarActualizarDocente(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizarDocente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizarDocente(@RequestBody Docente obj) {
		Map<String, Object> salida = new HashMap<>();


		try {
			Docente objSalida =  service.insertarActualizarDocente(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}


	@DeleteMapping("/eliminaDocente/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaDocente(@PathVariable("id") int idDocente) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaDocente(idDocente);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}







