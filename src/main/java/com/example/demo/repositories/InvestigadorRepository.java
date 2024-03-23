package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.demo.domain.Investigador;

public interface InvestigadorRepository extends JpaRepositoryImplementation<Investigador, Long> {

	 Optional<Investigador> findByDni(String dni);
	 Optional<Investigador> findByEmail(String email);
}

