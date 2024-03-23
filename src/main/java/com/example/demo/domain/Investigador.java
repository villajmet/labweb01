
package com.example.demo.domain;
import java.io.Serializable;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data
public class Investigador implements Serializable {
	
	private static final long serialVersionUID = 1;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInvestigador;

	private String apePat;
	private String apeMat;
	private String nombres;	
	@Column(unique = true)
	private String email;	
	@Column(unique = true)
	private String dni;
	
	private Date  fechaRef;
	
	@ManyToMany
	@JoinTable(name = "InvestigadoresProyectos",
		joinColumns = @JoinColumn(name="idInvestigador"),
		inverseJoinColumns = @JoinColumn(name="idPryInv")
			)
	private List<ProyectoInvestigacion> proyectos;
	
}
