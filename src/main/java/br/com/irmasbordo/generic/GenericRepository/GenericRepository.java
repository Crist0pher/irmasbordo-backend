package br.com.irmasbordo.generic.GenericRepository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<T, ID> extends JpaRepository<T,ID>{




    
}
