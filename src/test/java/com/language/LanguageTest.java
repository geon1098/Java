package com.language;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.language.entity.Language;
import com.language.entity.LanguageRepository;

@SpringBootTest
@ComponentScan(basePackages = "language.entity")
@Transactional
public class LanguageTest {

    @Autowired
    private LanguageRepository languageRepository;

    @Test
    public void create() {
        // 생성
        Language language = Language.builder()
                .language_id(7)
                .name("Korea")
                .last_update(LocalDateTime.now())
                .build();

        // 엔티티 데이터베이스 저장
        languageRepository.save(language);

        // 저장확인
        Language savedLanguage = languageRepository.findById(7).orElse(null);
        assertNotNull(savedLanguage);
        assertEquals("Korea", savedLanguage.getName());
    }

    @Test
    public void read() {
        // 모두 조회
        List<Language> languages = languageRepository.findAll();

        // not null
        assertFalse(languages.isEmpty());
    }

    @Test
    public void update() {
        int languageIdToUpdate = 7;

        // 갱신할 언어 찾기
        Optional<Language> optionalLanguage = languageRepository.findById(languageIdToUpdate);

        if (optionalLanguage.isPresent()) {
            Language languageToUpdate = optionalLanguage.get();

            // 갱신
            languageToUpdate.setName("UpdatedName");
            languageToUpdate.setLast_update(LocalDateTime.now());

            // 갱신된거 저장
            languageRepository.save(languageToUpdate);

            // 갱신확인
            Language updatedLanguage = languageRepository.findById(languageIdToUpdate).orElse(null);
            assertNotNull(updatedLanguage);
            assertEquals("UpdatedName", updatedLanguage.getName());
        } else {
        	
        }
    }

    @Test
    public void delete() {
        int languageIdToDelete = 7;

        // 삭제할 언어
        Optional<Language> optionalLanguage = languageRepository.findById(languageIdToDelete);

        if (optionalLanguage.isPresent()) {
            Language languageToDelete = optionalLanguage.get();

            // 삭제
            languageRepository.delete(languageToDelete);

            // 삭제확인
            Language deletedLanguage = languageRepository.findById(languageIdToDelete).orElse(null);
            assertNull(deletedLanguage);
        } else {

        }
    }
}
