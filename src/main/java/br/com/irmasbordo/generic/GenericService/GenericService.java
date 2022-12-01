package br.com.irmasbordo.generic.GenericService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.irmasbordo.generic.GenericRepository.GenericRepository;

@Service
public class GenericService<T, ID, Repository extends GenericRepository<T, ID>> {


	@Autowired
	Repository repository;  

	public Optional<T> findById(ID id) {

		return repository.findById(id);
	}

	public T save(T entity) {

		return repository.save(entity);
	}
	
	public List<T> listAll(){
		return repository.findAll();
	}




}
