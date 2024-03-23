package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.AvanceProyecto;
import com.example.demo.repositories.AvanceProyectoRepository;

public class AvanceProyectoServiceImp implements AvanceProyectoService {

	@Autowired
	private AvanceProyectoRepository invRep;
	
	
	@Override
	@Transactional
	public List<AvanceProyecto> listarTodos() {
		return invRep.findAll();
	}

	@Override
	@Transactional
	public AvanceProyecto buscarPorId(long id) {
		Optional<AvanceProyecto> investigador =  invRep.findById(id);
		return investigador.get();
	}

	@Override
	@Transactional
	public AvanceProyecto grabar(AvanceProyecto investigador) {
		return invRep.save(investigador);		
	}

	@Override
	@Transactional
	public AvanceProyecto actualizar(AvanceProyecto investigador, Long id) {
		investigador.setIdAvance(id);
		return invRep.save(investigador);
	}

	@Override
	@Transactional
	public void eliminar(long id) {
		invRep.deleteById(id);

	}


	
}
