package airbnb.server.persistence.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import airbnb.server.persistence.DTO.TotalSalesDTO;

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
}
