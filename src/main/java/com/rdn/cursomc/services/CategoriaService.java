package com.rdn.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdn.cursomc.domain.Categoria;
import com.rdn.cursomc.repositories.CategoriaRepository;
import com.rdn.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo; //Serviço acessa o obj de acesso aos dados
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		
		if (obj == null) {
			
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + 
					                          ", Tipo: " + Categoria.class.getName());			
		}
		return obj;
	}
}
