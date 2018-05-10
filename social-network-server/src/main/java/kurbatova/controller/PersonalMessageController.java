package kurbatova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import kurbatova.repo.PersonalMessageRepository;

@RestController
public class PersonalMessageController {
	@Autowired
	PersonalMessageRepository repository;
}
