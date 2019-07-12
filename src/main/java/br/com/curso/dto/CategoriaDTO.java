package br.com.curso.dto;

import java.io.Serializable;

import br.com.curso.domain.Categoria;

public class CategoriaDTO implements Serializable{
			private static final long serialVersionUID = 1L;
			
			private Integer id;
			private String nome;
			
			public CategoriaDTO(){
			}
			
			public CategoriaDTO(Categoria obj){
					id = obj.getId();
					nome = obj.getNome();
			}

			public Integer getId() {
				return id;
			}

			public void setId(Integer aId) {
				id = aId;
			}

			public String getNome() {
				return nome;
			}

			public void setNome(String aNome) {
				nome = aNome;
			}
			
}
