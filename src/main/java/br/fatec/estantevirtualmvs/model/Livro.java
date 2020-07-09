package br.fatec.estantevirtualmvs.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Table(name="tb_livro")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Livro implements Serializable{
	private static final long serialVersionUID = 1L;
      @Id
      @GeneratedValue(strategy=GenerationType.AUTO) 
      private Long id; 
   
      
      @Column(name="titulo", length = 100)
       private String titulo; 
  
     
      @Column(name="autor", length = 100)
      private String autor;
       
      @Column(name="descricao", length = 255)
      private String descricao;
      
       @ManyToOne
       @JoinColumn(name="editora_id")
       private Editora editora;
       
      public Long getId() {
            return id;
      }
      public void setId(Long id) {
            this.id = id;
      }
      public String getTitulo() {
            return titulo;
      }
      public void setTitulo(String titulo) {
            this.titulo = titulo;
      }
     
      public String getAutor() {
            return autor;
      }
      public void setAutor(String autor) {
            this.autor = autor;
      }
      public String getDescricao() {
            return descricao;
      }
      public void setDescricao(String description) {
            this.descricao = description;
      }
      
      @Override
      public int hashCode() {
          int hash = 7;
          hash = 53 * hash + 
                   Objects.hashCode(this.id != null ? this.id : 0);
          return hash;
      }

      @Override
      public boolean equals(Object obj) {
          if (this == obj)
              return true;
          if (obj == null || getClass() != obj.getClass())
              return false;
          final Livro other = (Livro) obj;
          return Objects.equals(this.id, other.id);
      }
       
  
}
