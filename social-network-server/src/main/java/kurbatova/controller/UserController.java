package kurbatova.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kurbatova.model.Profile;
import kurbatova.model.User;
import kurbatova.model.UserRole;
import kurbatova.model.enums.UserGender;
import kurbatova.repo.ProfileRepository;
import kurbatova.repo.UserRepository;
import kurbatova.repo.UserRoleRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepo;
	@Autowired
	UserRoleRepository userRoleRepo;
	@Autowired
	ProfileRepository profileRepo;
	
	@PostMapping(value="user/login")
	public Map<String, Object> login(
			@RequestParam(value="login", required=true) String login,
			@RequestParam(value="password", required=true) String password) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			User user = userRepo.findByLoginPassword(login, password);
			if (user != null) {
				result.put("result", 0);
				result.put("user", user);
			} else {
				result.put("result", 1);
			}
		} catch (Exception e) {
			System.out.println(e);
			result.put("result", 1);
		}

		return result;
	}
	
	@PostMapping(value="user/register")
	public Map<String, Object> register(
			@RequestParam(value="email", required=true) String email,
			@RequestParam(value="firstName", required=true) String firstName,
			@RequestParam(value="lastName", required=true) String lastName,
			@RequestParam(value="gender", required=true) String gender,
			@RequestParam(value="birthDate", required=true) String birthDate,
			@RequestParam(value="password", required=true) String password) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Optional<UserRole> userRole = userRoleRepo.findByName("User");
			if (userRole.isPresent()) {
				User user = createUser(email, password, userRole.get());
				createProfile(firstName, lastName, gender, birthDate, user);
				result.put("result", 0);
			} else {
				result.put("result", 1);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			result.put("result", 1);
		}
		return result;
	}
	
	private User createUser(String email, String password, UserRole userRole) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setUserRole(userRole);
		user.setBlocked(false);
		user.setLogin(email);
		user = userRepo.save(user);
		return user;
	}
	
	private Profile createProfile(String firstName, String lastName, String gender, String birthDate, User user) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		Date birthDay;
		try {
			birthDay = formatter.parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
            throw e;
        }

		Profile profile = new Profile();
		profile.setFirstName(firstName);
		profile.setLastName(lastName);
		profile.setUserGender(UserGender.values()[Integer.valueOf(gender)]);
		profile.setBirthDay(birthDay);
		profile.setUser(user);
		profileRepo.save(profile);
		return profile;
	}
}
