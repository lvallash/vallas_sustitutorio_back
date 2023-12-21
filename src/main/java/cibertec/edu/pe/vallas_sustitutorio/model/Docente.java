package cibertec.edu.pe.vallas_sustitutorio.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="docente")
public class Docente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int iddocente;

  private String nombre;

  private String dni;

  private double sueldo;

  private String sexo;

  private String fechanacimiento;

  @ManyToOne
  @JoinColumn(name = "idcategoria")
  private Categoria categoria;

}
