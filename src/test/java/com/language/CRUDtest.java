package com.language;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.language.entity.Language;
import com.language.entity.LanguageMapper;
import com.language.entity.LanguageService;

public class CRUDtest {

	@Autowired
    private LanguageMapper languageMapper;
	
	@Autowired
    private LanguageService languageService;
	
	@Test
    public void testCRUD() {
		
		Language language = Language.builder()
				.language_id(7)
                .name("Korea")
                .last_update(LocalDateTime.now())
                .build();
	}
	
	@Test
	public void testInsert() {
		
	}
	

}
