package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Investigador;
import com.example.demo.services.InvestigadorService;

@RestController
@RequestMapping("/api/v1/investigadores")
public class InvestigadorController {
	@Autowired
	private InvestigadorService invService;
	
	
	@GetMapping
	public List<Investigador>  ListarInvestigadores(){
		return invService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public Investigador ListarPorId(@PathVariable Long id){
		return invService.buscarPorId(id);
	}

	@PostMapping
	public Investigador crearInvestigador(@RequestBody Investigador investigador){
		return invService.grabar(investigador);
	}
	
	@PutMapping("/{id}")
	public Investigador editarInvestigador(@PathVariable Long id,@RequestBody Investigador inv){
		Investigador invDb = invService.buscarPorId(id);
		
		invDb.setApeMat(inv.getApeMat());
		invDb.setApePat(inv.getApePat());
		invDb.setDni(inv.getDni());
		invDb.setEmail(inv.getEmail());
		return invService.grabar(invDb);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarInvestigador(@PathVariable Long id){
		invService.eliminar(id);
	}
	
}

