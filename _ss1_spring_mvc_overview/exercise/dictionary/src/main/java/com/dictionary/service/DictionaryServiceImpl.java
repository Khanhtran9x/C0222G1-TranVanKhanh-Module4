package com.dictionary.service;

import com.dictionary.repository.DictionaryRepositoryImpl;
import com.dictionary.repository.IDictionaryRepository;

public class DictionaryServiceImpl implements IDictionaryService{
    private IDictionaryRepository dictionaryRepository = new DictionaryRepositoryImpl();

    public String dictionaryLookup(String englishWord){
       return dictionaryRepository.dictionaryLookup(englishWord);
    }
}
