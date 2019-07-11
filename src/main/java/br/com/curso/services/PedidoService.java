package br.com.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.domain.Pedido;
import br.com.curso.repositories.PedidoRepository;
import br.com.curso.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id){
	    Optional<Pedido> obj = repo.findById(id);
	    return obj.orElseThrow(() -> new ObjectNotFoundException(//Expressão Lambda
	        "Objeto não encontrado! Id:" + id + ", Tipo: " + Pedido.class.getName()));    
	}

}
