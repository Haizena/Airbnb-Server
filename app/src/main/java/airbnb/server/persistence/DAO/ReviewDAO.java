package airbnb.server.persistence.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import airbnb.server.persistence.DTO.ReviewDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewDAO {
    private final SqlSessionFactory sqlSessionFactory;

    public ReviewDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    //Parent_no is review_no, if host write rereview input Parent_no to review_no
    public void insertReview(HashMap<String, Object> callInsertReview) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            //affectedRows = sqlSession.insert("mapper.ReviewMapper.insertReview", reviewDTO);
            sqlSession.selectOne("mapper.ReviewMapper.callInsertReview", callInsertReview);
            sqlSession.flushStatements();
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public int insertReReview(ReviewDTO reviewDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int affectedRows = 0;

        try {
            affectedRows = sqlSession.insert("mapper.ReviewMapper.insertReReview", reviewDTO);
            sqlSession.flushStatements();
            sqlSession.commit();
            reviewDTO.setReview_no(sqlSession.selectOne("mapper.ReviewMapper.maxReviewNo"));
        } finally {
            sqlSession.close();
        }
        return affectedRows;
    }

    //call rereview's review, if Not Exist return null -> if(reReview != null)
    public List<Map<String,Object>> review(int house_no) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Map<String, Object>> reReview;

        try {
            reReview = sqlSession.selectList("mapper.ReviewMapper.review", house_no);
        } finally {
            sqlSession.close();
        }
        return reReview;
    }

    public ReviewDTO reReview(int review_no) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ReviewDTO reReview;

        try {
            reReview = sqlSession.selectOne("mapper.ReviewMapper.reReview", review_no);
        } finally {
            sqlSession.close();
        }
        return reReview;
    }

    public List<Map<String, Object>> houseReview(int house_no) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Map<String, Object>> list;

        try {
            list = sqlSession.selectList("mapper.ReviewMapper.houseReview", house_no);
        } finally {
            sqlSession.close();
        }
        return list;
    }

    public List<Map<String, Object>> writeReviewList(int guest_no) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Map<String, Object>> list;

        try {
            list = sqlSession.selectList("mapper.ReviewMapper.isChecked", guest_no);
        } finally {
            sqlSession.close();
        }
        return list;
    }
}
