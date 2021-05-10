package ee.bcs.valiit.dictionary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ee.bcs.valiit.dictionary.repository.DictionaryRepository;

import java.util.List;

@Service
public class DictionaryService {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    public void createEngTransl(String estWord, String engWord){
        dictionaryRepository.createEngTransl(estWord, engWord);
//        return "Uus tõlge salvestatud: " +input+ " = " +translation;
    }

    public void createEstTransl(String engWord, String estWord){
        dictionaryRepository.createEstTransl(engWord, estWord);
//        return "Uus tõlge salvestatud: " +input+ " = " +translation;
    }

//    public String getEngTransl(String estWord){
//        return "Tõlge: " +estWord+ " = " +dictionaryRepository.getEngTransl(estWord);
//    }
//
//    public String getEstTransl(String engWord){
//        return "Tõlge: " +engWord+ " = " +dictionaryRepository.getEstTransl(engWord);
//    }

    public List<String> getEstAllTransl(String engWord) {
        return dictionaryRepository.getEstAllTransl(engWord);
    }

    public List<String> getEngAllTransl(String estWord) {
        return dictionaryRepository.getEngAllTransl(estWord);
    }
}
