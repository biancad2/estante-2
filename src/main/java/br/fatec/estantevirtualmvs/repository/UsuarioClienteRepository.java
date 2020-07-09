package br.fatec.estantevirtualmvs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.estantevirtualmvs.model.UsuarioCliente;



public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Long> {

}
