package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.Investigador;

public interface InvestigadorService {
	List<Investigador> listarTodos();	
	Investigador buscarPorId(long id);	
	Investigador grabar(Investigador investigador);
	Investigador actualizar(Investigador investigador, Long id);	
	void eliminar(long id);	
	Investigador findByEmail(String email);
	Investigador findByDni(String dni);
}
