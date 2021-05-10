package ee.bcs.valiit.dictionary.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DictionaryRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createEngTransl(String estWord, String engWord){
        String sql = "INSERT INTO dictionary(est_word, eng_word) VALUES(:dbEstWord, :dbEngWord)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbEstWord", estWord);
        paramMap.put("dbEngWord", engWord);
        jdbcTemplate.update(sql, paramMap);
    }

    public void createEstTransl(String engWord, String estWord){
        String sql = "INSERT INTO dictionary(eng_word, est_word) VALUES(:dbEngWord, :dbEstWord)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbEngWord", engWord);
        paramMap.put("dbEstWord", estWord);
        jdbcTemplate.update(sql, paramMap);
    }

//    public String getEngTransl(String estWord) {
//        String sql = "SELECT eng_word FROM dictionary WHERE est_word = :dbEstWord";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("dbEstWord", estWord);
//        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
//    }
//
//    public String getEstTransl(String engWord) {
//        String sql = "SELECT est_word FROM dictionary WHERE eng_word = :dbEngWord";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("dbEngWord", engWord);
//        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
//    }

    public List<String> getEstAllTransl(String engWord){
        String sql = "SELECT est_word FROM dictionary WHERE eng_word = :dbEngWord";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbEngWord", engWord);
        return jdbcTemplate.queryForList(sql, paramMap, String.class);
    }

    public List<String> getEngAllTransl(String estWord){
        String sql = "SELECT eng_word FROM dictionary WHERE est_word = :dbEstWord";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbEstWord", estWord);
        return jdbcTemplate.queryForList(sql, paramMap, String.class);
    }

//    public List<DictionaryData> getAllDictionary() {
//        String sql = "SELECT * FROM dictionary";
//        return jdbcTemplate.query(sql, new HashMap(), new DictionaryRowMapper());
//    }


}
