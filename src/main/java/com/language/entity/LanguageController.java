package com.language.entity;

import com.language.entity.Language;
import com.language.entity.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping("/")
    public List<Language> getAllLanguages() {
        return languageService.getAllLanguages();
        
    }

    @GetMapping("/{id}")
    public Language getLanguageById(@PathVariable int id) {
        return languageService.getLanguageById(id);
    }

    @PostMapping("/")
    public void insertLanguage(@RequestBody Language language) {
        
        
    	languageService.insertLanguage(language);
    }

    @PutMapping("/{id}")
    public void updateLanguage(@PathVariable int id, @RequestBody Language language) {
        language.setLanguage_id(id);
        languageService.updateLanguage(language);
    }

    @DeleteMapping("/{id}")
    public void deleteLanguage(@PathVariable int id) {
        languageService.deleteLanguage(id);
    }
}