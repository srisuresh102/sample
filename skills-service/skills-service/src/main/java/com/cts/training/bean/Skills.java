package com.cts.training.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Skills {
	
	@Id
	private Long id;
	@NotEmpty(message="name should not be empty")
	@Size(min=4, max=20,message="name should have minimum of 4 characters")
	private String name;
	private String description;
	@NotEmpty(message="description should not be empty")
	private String level;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	

}
