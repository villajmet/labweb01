package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.domain.Investigador;
import com.example.demo.repositories.InvestigadorRepository;

@Service
public class InvestigadorServiceImp implements InvestigadorService {

	@Autowired
	private InvestigadorRepository invRep;
	
	
	@Override
	@Transactional
	public List<Investigador> listarTodos() {
		return invRep.findAll();
	}

	@Override
	@Transactional
	public Investigador buscarPorId(long id) {
		Optional<Investigador> investigador =  invRep.findById(id);
		return investigador.get();
	}

	@Override
	@Transactional
	public Investigador grabar(Investigador investigador) {
		return invRep.save(investigador);		
	}

	@Override
	@Transactional
	public Investigador actualizar(Investigador investigador, Long id) {
		investigador.setIdInvestigador(id);
		return invRep.save(investigador);
	}

	@Override
	@Transactional
	public void eliminar(long id) {
		invRep.deleteById(id);

	}

	@Override
	@Transactional
	public Investigador findByEmail(String email) {
		Optional<Investigador> investigador = invRep.findByDni(email);
		return investigador.get();
	}
	
	@Override
	@Transactional
	public Investigador findByDni(String email) {
		return invRep.findByEmail(email).get();		
	}

}
