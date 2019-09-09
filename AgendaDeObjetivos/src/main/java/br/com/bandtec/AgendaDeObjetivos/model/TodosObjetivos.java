package br.com.bandtec.AgendaDeObjetivos.model;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosObjetivos extends JpaRepository<Objetivo, Integer> {
	
	public void save(Objetivo objetivo);

	public List<Objetivo> ate(LocalDate data);
}