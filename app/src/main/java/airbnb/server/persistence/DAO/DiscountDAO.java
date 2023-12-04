package airbnb.server.persistence.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import airbnb.server.persistence.DTO.AmountDiscountDTO;
import airbnb.server.persistence.DTO.RateDiscountDTO;

import java.util.Map;

public class DiscountDAO {
    private final SqlSessionFactory sqlSessionFactory;

    public DiscountDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public Map<String, Object> selectDiscount(int house_no){
        Map<String, Object> list;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectOne("mapper.DiscountMapper.selectDiscount", house_no);
        } finally {
            sqlSession.close();
        }
        return list;
    }

    public Map<String, Object> selectDiscountByReservation_no(int reservation_no){
        Map<String, Object> list;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectOne("mapper.DiscountMapper.selectDiscountByReservation_no", reservation_no);
        } finally {
            sqlSession.close();
        }
        return list;
    }

    public int insertAmountDiscount(AmountDiscountDTO amountDiscountDTO){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int affectedRows = 0;

        try{
            affectedRows = sqlSession.insert("mapper.DiscountMapper.insertDiscount",amountDiscountDTO);
            sqlSession.flushStatements();
            amountDiscountDTO.setDiscount_no(sqlSession.selectOne("mapper.DiscountMapper.recentlyAddedDiscountNo"));
            affectedRows += sqlSession.insert("mapper.DiscountMapper.insertAmount",amountDiscountDTO);
            sqlSession.flushStatements();
            sqlSession.commit();
        }finally{
            sqlSession.close();
        }
        return affectedRows;
    }
    public int insertRateDiscount(RateDiscountDTO rateDiscountDTO){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int affectedRows = 0;

        try{
            affectedRows = sqlSession.insert("mapper.DiscountMapper.insertDiscount",rateDiscountDTO);
            sqlSession.flushStatements();
            rateDiscountDTO.setDiscount_no(sqlSession.selectOne("mapper.DiscountMapper.recentlyAddedDiscountNo"));
            affectedRows += sqlSession.insert("mapper.DiscountMapper.insertRate",rateDiscountDTO);
            sqlSession.flushStatements();
            sqlSession.commit();
        }finally{
            sqlSession.close();
        }
        return affectedRows;
    }
}
