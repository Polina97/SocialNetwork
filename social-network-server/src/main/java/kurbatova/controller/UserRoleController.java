package kurbatova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kurbatova.model.UserRole;
import kurbatova.repo.UserRoleRepository;

@RestController
public class UserRoleController {
	@Autowired
	UserRoleRepository repository;
	
	@RequestMapping("user_role/save")
    public String save(){
		repository.save(new UserRole("TestRole"));
        return "Done";
    }
	
	@RequestMapping("user_role/getRoles")
	public List<UserRole> getRoles(){
		return (List<UserRole>) repository.findAll();
	}
}
