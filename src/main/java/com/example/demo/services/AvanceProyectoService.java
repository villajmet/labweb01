package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.AvanceProyecto;

public interface AvanceProyectoService {
	List<AvanceProyecto> listarTodos();	
	AvanceProyecto buscarPorId(long id);	
	AvanceProyecto grabar(AvanceProyecto avanceProyecto);
	AvanceProyecto actualizar(AvanceProyecto avanceProyecto, Long id);	
	void eliminar(long id);	
}
