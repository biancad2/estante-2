package br.fatec.estantevirtualmvs.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.fatec.estantevirtualmvs.model.Livro;


@Table(name = "tb_editora")
@Entity
public class Editora extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "nm_nome", length = 60)
	private String nome;
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Column(name = "ds_descricao", length = 60)
	private String descricao;
	
	@OneToMany(mappedBy="editora")
	private List<Livro> livros;
}