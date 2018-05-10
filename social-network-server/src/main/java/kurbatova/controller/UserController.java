package kurbatova.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kurbatova.model.User;
import kurbatova.repo.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepo;
	
	@PostMapping(value="user/login")
	public Map<String, Object> login(
			@RequestParam(value="login", required=true) String login,
			@RequestParam(value="password", required=true) String password) {

		Map<String, Object> result = new HashMap<String, Object>();
		try {
			User user = userRepo.findByLoginPassword(login, password);
			result.put("result", 0);
			result.put("userId", user.getUserId());
		} catch (Exception e) {
			System.out.println(e);
			result.put("result", 1);
		}

		return result;
	}
}
