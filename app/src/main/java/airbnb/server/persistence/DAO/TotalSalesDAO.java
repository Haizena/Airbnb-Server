package airbnb.server.persistence.DAO;

import airbnb.server.persistence.DTO.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import airbnb.server.persistence.DTO.TotalSalesDTO;

import java.util.List;
import java.util.Map;

public class TotalSalesDAO {
    private final SqlSessionFactory sqlSessionFactory;
    public TotalSalesDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void insertTotalAmount(TotalSalesDTO totalSalesDTO){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            sqlSession.insert("mapper.TotalSales.insertTotalSales", totalSalesDTO);
            sqlSession.flushStatements();
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void dropTotalAmount(int reservation_no){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            sqlSession.insert("mapper.TotalSales.dropTotalSales", reservation_no);
            sqlSession.flushStatements();
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public int totalAmountReservation_No(int reservation_no){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int totalAmount;

        try {
            totalAmount = sqlSession.selectOne("mapper.TotalSales.selectTotalSales", reservation_no);
            sqlSession.flushStatements();
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return totalAmount;
    }

    public int totalAmountHost(int host_no){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int totalAmount;

        try {
            totalAmount = sqlSession.selectOne("mapper.TotalSales.selectTotalSalesByHost", host_no);
            sqlSession.flushStatements();
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return totalAmount;
    }

    public List<Map<String, Object>> allTotalSales(int house_no){
        List<Map<String, Object>> list = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.TotalSales.allTotalSales");
        } finally {
            sqlSession.close();
        }
        return list;
    }
}
