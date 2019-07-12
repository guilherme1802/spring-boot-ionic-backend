package br.com.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.curso.domain.Categoria;
import br.com.curso.repositories.CategoriaRepository;
import br.com.curso.services.exceptions.DataIntegrityException;
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
	
	public Categoria insert(Categoria obj){
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj){
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id){
		find(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria porque possui produtos");	
		}	
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}

}
