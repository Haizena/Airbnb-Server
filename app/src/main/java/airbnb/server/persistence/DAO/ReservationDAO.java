package airbnb.server.persistence.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import airbnb.server.persistence.DTO.ReservationDTO;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class ReservationDAO {
    private final SqlSessionFactory sqlSessionFactory;

    public ReservationDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public int insertReservation(ReservationDTO reservationDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int affectedRows = 0;

        try {
            affectedRows = sqlSession.insert("mapper.ReservationMapper.insertReservation", reservationDTO);
            sqlSession.flushStatements();
            sqlSession.commit();
            reservationDTO.setReservation_no(recentlyAddedReservationNo());
        } finally {
            sqlSession.close();
        }
        return affectedRows;
    }
    public int recentlyAddedReservationNo() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int reservationNo;

        try {
            reservationNo = sqlSession.selectOne("mapper.ReservationMapper.maxReservationNo");
            sqlSession.flushStatements();
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return reservationNo;
    }
    public int reviewed(int reservation_no) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int affectedRows = 0;

        try {
            affectedRows = sqlSession.insert("mapper.ReservationMapper.reviewed", reservation_no);
            sqlSession.flushStatements();
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return affectedRows;
    }
    public int approved(int reservation_no) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int affectedRows = 0;

        try {
            affectedRows = sqlSession.insert("mapper.ReservationMapper.approved", reservation_no);
            sqlSession.flushStatements();
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return affectedRows;
    }
    public void checkOuted(int reservation_no){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            sqlSession.insert("mapper.ReservationMapper.checkOuted", reservation_no);
            sqlSession.flushStatements();
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
    public void unCheckOuted(int reservation_no){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            sqlSession.insert("mapper.ReservationMapper.unCheckOuted", reservation_no);
            sqlSession.flushStatements();
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
    public List<ReservationDTO> selectHost(int host_no){
        List<ReservationDTO> list = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.ReservationMapper.selectHostInfo",host_no);
        } finally {
            sqlSession.close();
        }
        return list;
    }
    public List<ReservationDTO> selectGuest(int guest_no){
        List<ReservationDTO> list = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.ReservationMapper.selectGuestInfo",guest_no);
        } finally {
            sqlSession.close();
        }
        return list;
    }
    public List<Map<String, Object>> selectApprovedGuest(int guest_no){
        List<Map<String,Object>> list = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.ReservationMapper.selectApprovedGuestInfo",guest_no);
        } finally {
            sqlSession.close();
        }
        return list;
    }
    public List<Map<String, Object>> selectUnReviewedCheckOut(int guest_no){
        List<Map<String, Object>> list;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.ReservationMapper.selectUnReviewedCheckOut",guest_no);
        } finally {
            sqlSession.close();
        }
        return list;
    }
    public List<Map<String, Object>> allApprovedList (){
        List<Map<String, Object>> list = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.ReservationMapper.AllApprovedList");
        } finally {
            sqlSession.close();
        }
        return list;
    }
    public List<Map<String,Object>> allApprovedList (int house_no){
        List<Map<String, Object>> list = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.ReservationMapper.reservationApprovedList",house_no);
        } finally {
            sqlSession.close();
        }
        return list;
    }
    public Map<String, Date> dateList (int reservation_no){
        Map<String, Date> list;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectOne("mapper.ReservationMapper.dateList",reservation_no);
        } finally {
            sqlSession.close();
        }
        return list;
    }

    public List<Map<String, Object>> hostAllInfo (int host_no){
        List<Map<String, Object>> list = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.ReservationMapper.hostAllInfo",host_no);
        } finally {
            sqlSession.close();
        }
        return list;
    }
    public void deleteReservation(int reservation_no){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            sqlSession.insert("mapper.ReservationMapper.dropReservation", reservation_no);
            sqlSession.flushStatements();
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public List<Map<String, Object>> hostAllInfoApproved (int host_no){
        List<Map<String, Object>> list;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.ReservationMapper.hostAllInfoApproved",host_no);
        } finally {
            sqlSession.close();
        }
        return list;
    }
}
