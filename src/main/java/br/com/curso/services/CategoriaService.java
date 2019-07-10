package br.com.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.domain.Categoria;
import br.com.curso.repositories.CategoriaRepository;
import br.com.curso.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id){
	    Optional<Categoria> obj = repo.findById(id);
	    return obj.orElseThrow(() -> new ObjectNotFoundException(//Expressão Lambda
	        "Objeto não encontrado! Id:" + id + ", Tipo: " + Categoria.class.getName()));    
	}

}
