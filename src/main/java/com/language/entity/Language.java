package com.language.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int language_id;

	private String name;
	
	private LocalDateTime last_update;
	
	
	public int getLanguageId() {
		return language_id;
	}

	public void setLanguageId(int language_id) {
		this.language_id = language_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getLastUpdate() {
		return last_update;
	}

	public void setLastUpdate(LocalDateTime last_update) {
		this.last_update = last_update;
	}
	@Builder
	public Language(int language_id, String name, LocalDateTime last_update) {
		this.language_id = language_id;
		this.name = name;
		this.last_update = last_update;
	}
}
