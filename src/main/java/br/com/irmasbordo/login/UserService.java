package br.com.irmasbordo.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.irmasbordo.generic.GenericService.GenericService;

@Service
public class UserService extends GenericService<UserModel, Long, UserRepository> {

	@Autowired
	PasswordEncoder encoder;

	public boolean validarSenha(String login, String password) {

		Optional<UserModel> optUser = repository.findByLogin(login);

		if (optUser.isEmpty()) {
			return false;
		}

		UserModel user = optUser.get();

		boolean valid = encoder.matches(password, user.getPassword());

		return valid;

	}

	public Boolean validarLogin(String login) {

		Optional<UserModel> optUser = repository.findByLogin(login);

		if (optUser.isEmpty()) {
			return false;
		}

		UserModel user = optUser.get();

		return true;
	}

}
