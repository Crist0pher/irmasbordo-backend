package br.com.irmasbordo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.irmasbordo.generic.GenericController.GenericController;

@RestController
@RequestMapping("/user")
public class UserController extends GenericController<UserModel, Long, UserRepository, UserService> {

	@Autowired
	PasswordEncoder encoder;

	@PostMapping
	public Object save(@RequestBody UserModel user) {

		user.setPassword(encoder.encode(user.getPassword()));

		return service.save(user);
	}

	@GetMapping("/validarSenha")
	public ResponseEntity<String> validarSenha(@RequestParam String login, @RequestParam String password) {

		if(!service.validarLogin(login)) {
			return new ResponseEntity<String>("Usuário não localizado", HttpStatus.UNAUTHORIZED);
		}
		
		HttpStatus status = service.validarSenha(login,password) ? HttpStatus.OK: HttpStatus.UNAUTHORIZED;
		return new ResponseEntity<String>(status);

	}
}
