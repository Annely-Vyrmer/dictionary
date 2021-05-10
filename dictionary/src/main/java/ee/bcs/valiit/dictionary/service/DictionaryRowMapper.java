//package ee.bcs.valiit.dictionary.service;
//
//import javax.swing.tree.RowMapper;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class DictionaryRowMapper implements RowMapper<DictionaryList> {
//    @Override
//    public DictionaryList mapRow(ResultSet resultSet, int i) throws SQLException{
//        DictionaryList dictionaryResult = new DictionaryList();
//        dictionaryResult.setEstWord(resultSet.getString("estWord"));
//        dictionaryResult.setEngWord(resultSet.getString("engword"));
//        return dictionaryResult;
//    }
//}
