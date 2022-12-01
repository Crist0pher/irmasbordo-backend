package br.com.irmasbordo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class GenericModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	

}
