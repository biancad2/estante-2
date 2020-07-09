package br.fatec.estantevirtualmvs.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.estantevirtualmvs.model.Editora;



public interface EditoraRepository extends JpaRepository<Editora, Long> {
	List<Editora> findByNome(String nome);
}
