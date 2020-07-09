package br.fatec.estantevirtualmvs.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


import br.fatec.estantevirtualmvs.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	List<Livro> findByAutor(String autor);
	List<Livro> findByTitulo(String titulo);
}
