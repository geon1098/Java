package com.language.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {

    @Autowired
    private LanguageMapper languageMapper;

    public Language getLanguageById(int id) {
        return languageMapper.getLanguageById(id);
    }

    public List<Language> getAllLanguages() {
        return languageMapper.getAllLanguages();
    }

    public void insertLanguage(Language language) {
        languageMapper.insertLanguage(language);
        LocalDateTime currentDateTime = LocalDateTime.now(); // 현재 날짜와 시간
        language.setLastUpdate(currentDateTime);
        languageMapper.insertLanguage(language);
    }

    public void updateLanguage(Language language) {
        languageMapper.updateLanguage(language);
    }

    public void deleteLanguage(int id) {
        languageMapper.deleteLanguage(id);
    }
}