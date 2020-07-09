package br.fatec.estantevirtualmvs.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.estantevirtualmvs.model.Autor;



public interface AutorRepository extends JpaRepository<Autor, Long> {
	List<Autor> findByNome(String nome);
}
