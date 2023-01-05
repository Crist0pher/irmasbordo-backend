package br.com.irmasbordo.login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long>{

	public Optional<UserModel> findByLogin(String login);
}
