package com.cts.training.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.bean.Skills;
import com.cts.training.exception.SkillNotFoundException;
import com.cts.training.repository.SkillsRepository;

@RestController
@RequestMapping("/api")
public class SkillsController {
	
	@Autowired
	private SkillsRepository skillsRepository;
	
	@GetMapping("/skills")
	public List<Skills> getAllSkills() {
		return skillsRepository.findAll();
	}

	@GetMapping("/skills/{id}")
	public Optional<Skills> getSkillsById(@PathVariable Long id) {
		Optional<Skills> skill = skillsRepository.findById(id);
		if(!skill.isPresent()) 
			throw new SkillNotFoundException("The user with Id - :"+id+"does not exists");
		   return skill;
	}
	
	@PostMapping("/skills")
	public Skills insertSkills(@Valid @RequestBody Skills skills) {
		return skillsRepository.save(skills);
	}
	
	@DeleteMapping("/skills/{id}")
	public void deleteSkillById(@PathVariable Long id) {
		Optional<Skills> skill = skillsRepository.findById(id);
		if(!skill.isPresent()) 
			throw new SkillNotFoundException("The user with Id - :"+id+"does not exists");
		skillsRepository.deleteById(id);
	}
	
	@PutMapping("/skills/{id}")
	public Skills updateSkillById(@Valid @RequestBody Skills skills,@PathVariable Long id) {
		Optional<Skills> skill = skillsRepository.findById(id);
		if(!skill.isPresent()) 
			throw new SkillNotFoundException("The user with Id - :"+id+"does not exists");
		return skillsRepository.save(skills);
	}
}
