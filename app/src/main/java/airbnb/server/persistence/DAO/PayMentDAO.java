package airbnb.server.persistence.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import airbnb.server.persistence.DTO.PayMentDTO;

public class PayMentDAO {
    private final SqlSessionFactory sqlSessionFactory;

    public PayMentDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public PayMentDTO selectPayMent(int house_no){
        PayMentDTO payMent = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            payMent = sqlSession.selectOne("mapper.PayMentMapper.selectPayMent",house_no);
        } finally {
            sqlSession.close();
        }
        return payMent;
    }
    public int insertPayMent(PayMentDTO payMentDTO){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int affectedRows = 0;

        try{
            affectedRows = sqlSession.insert("mapper.PayMentMapper.insertPayMent",payMentDTO);
            sqlSession.flushStatements();
            sqlSession.commit();
        }finally{
            sqlSession.close();
        }
        return affectedRows;
    }

}
