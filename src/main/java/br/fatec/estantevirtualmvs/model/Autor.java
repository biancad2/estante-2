package br.fatec.estantevirtualmvs.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

@Table(name = "tb_autor")
@Entity
public class Autor extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "nm_nome", length = 60)
	private String nome;
	@Column(name = "ds_nacionalidade", length = 60)
	private String nacionalidade;
}
