package br.com.irmasbordo.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserModel {
    
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	@Column(unique=true)
	private String login;
	
	@Column
	private String password;

	
	
	public UserModel(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public UserModel() {
		super();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
