package br.com.irmasbordo.generic.GenericService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class GenericService<T, ID, Repository extends JpaRepository<T, ID>> {


	@Autowired
	protected Repository repository;  

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
