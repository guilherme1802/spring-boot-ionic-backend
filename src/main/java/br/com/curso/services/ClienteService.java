package br.com.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.domain.Cliente;
import br.com.curso.repositories.ClienteRepository;
import br.com.curso.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id){
	    Optional<Cliente> obj = repo.findById(id);
	    return obj.orElseThrow(() -> new ObjectNotFoundException(//Expressão Lambda
	        "Objeto não encontrado! Id:" + id + ", Tipo: " + Cliente.class.getName()));    
	}

}
