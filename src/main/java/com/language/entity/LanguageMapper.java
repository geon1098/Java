package com.language.entity;

import java.util.List;

public interface LanguageMapper {
    Language getLanguageById(int id);
    List<Language> getAllLanguages();
    void insertLanguage(Language language);
    void updateLanguage(Language language);
    void deleteLanguage(int id);
}