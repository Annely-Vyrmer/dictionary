package ee.bcs.valiit.dictionary.controller;

import ee.bcs.valiit.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api")
@RestController
public class DictionaryController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private DictionaryService dictionaryService;

    //CREATE EST-ENG TRANSLATION
    //http://localhost:9090/api/createEngTransl/suvi/summer
    @PostMapping("createEngTransl/{estWord}/{engWord}")
    public void createEngTransl(@PathVariable("estWord") String estWord,
                                @PathVariable("engWord") String engWord){
        dictionaryService.createEngTransl(estWord, engWord);
    }
    //CREATE ENG-EST TRANSLATION
    //http://localhost:9090/api/createEstTransl/autumn/sügis
    @PostMapping("createEstTransl/{engWord}/{estWord}")
    public void createEstTransl(@PathVariable("engWord") String engWord,
                                @PathVariable("estWord") String estWord){
        dictionaryService.createEstTransl(engWord, estWord);
    }

//    //GET ENG TRANSLATION
//    //http://localhost:9090/api/getEngTransl/suvi
//    @GetMapping("getEngTransl/{estWord}")
//    public String getEngTransl(@PathVariable("estWord") String estWord) {
//        return dictionaryService.getEngTransl(estWord);
//    }
//    //GET EST TRANSLATION
//    //http://localhost:9090/api/getEstTransl/summer
//    @GetMapping("getEstTransl/{engWord}")
//    public String getEstTransl(@PathVariable("engWord") String engWord) {
//        return dictionaryService.getEstTransl(engWord);
//    }

    //LIST of EST translations for one ENG entry
    //http://localhost:9090/api/getEstAllTransl/summer
    @GetMapping("getEstAllTransl/{engWord}")
    public List<String> getEstAllTransl(@PathVariable("engWord") String engWord){
        return dictionaryService.getEstAllTransl(engWord);
    }
    //LIST of ENG translations for one EST entry
    //http://localhost:9090/api/getEngAllTransl/suvi
    @GetMapping("getEngAllTransl/{estWord}")
    public List<String> getEngAllTransl(@PathVariable("estWord") String estWord){
        return dictionaryService.getEngAllTransl(estWord);
    }

}
