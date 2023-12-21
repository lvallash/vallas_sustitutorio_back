package cibertec.edu.pe.vallas_sustitutorio.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class Categoria {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idcategoria;

  private String nombre;

}
