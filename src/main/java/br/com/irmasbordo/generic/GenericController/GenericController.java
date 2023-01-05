package br.com.irmasbordo.generic.GenericController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.irmasbordo.generic.GenericService.GenericService;

public class GenericController<T, ID, R extends JpaRepository<T, ID>, S extends GenericService<T, ID, R>> {

	@Autowired
	protected S service;

	@GetMapping("id")
	public Optional<T> getById(@RequestParam ID id) {

		return service.findById(id);

	}

	@GetMapping
	public List<T> listAll() {

		return service.listAll();
	}

	@PostMapping
	public Object save(@RequestBody T entity) {

		return entity;
	}

}
