package br.com.gustavo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavo.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

	Cambio findByFromAndTo(String from, String to);
}
