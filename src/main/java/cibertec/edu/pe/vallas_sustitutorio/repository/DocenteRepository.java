package cibertec.edu.pe.vallas_sustitutorio.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import cibertec.edu.pe.vallas_sustitutorio.model.Docente;


import java.util.List;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {


	@Query("select d from Docente d where d.nombre like ?1")
	public abstract List<Docente> listarPorNombreLike(String nombre);


}


