package com.dictionary.service;

import com.dictionary.repository.DictionaryRepository;
import com.dictionary.repository.IDictionaryRepository;

public class DictionaryService implements IDictionaryService{
    private IDictionaryRepository dictionaryRepository = new DictionaryRepository();

    public String dictionaryLookup(String englishWord){
       return dictionaryRepository.dictionaryLookup(englishWord);
    }
}
