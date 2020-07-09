package br.fatec.estantevirtualmvs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Table(name="tb_cliente")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario extends AbstractEntity{
	private static final long serialVersionUID = 1L;

    @Column(name="nm_nome", length=60)
    private String nome;
    @Column(name="ds_email", length=120)
    private String email;
    @Column(name="qt_idade")
    private String idade;
    @Column(name = "cd_cpf", length = 11)
	private String cpf;
    public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Usuario() { }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	

}
