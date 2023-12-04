package airbnb.server.persistence.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import airbnb.server.persistence.DTO.HouseDTO;
import airbnb.server.persistence.DTO.IndividualRoomDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HouseDAO {
    private final SqlSessionFactory sqlSessionFactory;

    public HouseDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Map<String, Object>> selectApprovedAll(HashMap<String, Object> filter) {
        List<Map<String, Object>> list;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.HouseMapper.allHouseFilter", filter);
        } finally {
            sqlSession.close();
        }
        return list;
    }

    public List<HouseDTO> selectApprovedAll(int host_no) {
        List<HouseDTO> list = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.HouseMapper.allApprovedHouseInfoByHost", host_no);
        } finally {
            sqlSession.close();
        }
        return list;
    }


    public List<Map<String, Object>> selectApprovedAll() {
        List<Map<String, Object>> list = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.HouseMapper.allApprovedHouseInfo");
        } finally {
            sqlSession.close();
        }
        return list;
    }

    public HouseDTO selectHoustDTO(int house_no) {
        HouseDTO dto;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            dto = sqlSession.selectOne("mapper.HouseMapper.selectHouse", house_no);
        } finally {
            sqlSession.close();
        }
        return dto;
    }

    public List<Map<String, Object>> selectUnApprovedAll() {
        List<Map<String, Object>> list = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.HouseMapper.allUnApprovedHouseInfo");
        } finally {
            sqlSession.close();
        }
        return list;
    }

    public int ApproveHouse(int house_no) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int affectedRows = 0;

        try {
            affectedRows = sqlSession.update("mapper.HouseMapper.approved", house_no);
            sqlSession.flushStatements();
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return affectedRows;
    }

    public int insertHouse(HouseDTO houseDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int affectedRows = 0;

        try {
            affectedRows = sqlSession.insert("mapper.HouseMapper.insertHouse", houseDTO);
            sqlSession.flushStatements();
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return affectedRows;
    }

    public int insertHouse(IndividualRoomDTO individualRoomDTO, HouseDTO houseDTO) {
        int affectedRows = 0;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            affectedRows += sqlSession.insert("mapper.HouseMapper.insertHouse", houseDTO);
            sqlSession.flushStatements();
            sqlSession.commit();
            int house_no = maxHouseNo();
            houseDTO.setHouse_no(house_no);
            individualRoomDTO.setHouse_no(house_no);
            affectedRows += sqlSession.insert("mapper.HouseMapper.insertIndividualRoom", individualRoomDTO);
            sqlSession.flushStatements();
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return affectedRows;
    }

    public int maxHouseNo() {
        Integer house_no = 0;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            house_no = sqlSession.selectOne("mapper.HouseMapper.maxHouseNo");
        } finally {
            sqlSession.close();
        }

        return house_no;

    }

    //ASC Sort
    public List<Map<String, Object>> selectAllOrderByPaymentASC() {
        List<Map<String, Object>> list;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.HouseMapper.selectAllOrderByPriceASC");
        } finally {
            sqlSession.close();
        }
        return list;
    }

    //DESC Sort
    public List<Map<String, Object>> selectAllOrderByPaymentDESC() {
        List<Map<String, Object>> list;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.HouseMapper.selectAllOrderByPriceDESC");
        } finally {
            sqlSession.close();
        }
        return list;
    }


    public List<Map<String, Object>> allPayment(int host_no) {
        List<Map<String, Object>> list;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.HouseMapper.allHousePayMentInfo", host_no);
        } finally {
            sqlSession.close();
        }
        return list;
    }

    public List<Map<String, Object>> allDiscountInfo(int host_no) {
        List<Map<String, Object>> list;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.HouseMapper.allHouseDiscountInfo", host_no);
        } finally {
            sqlSession.close();
        }
        return list;
    }

    public int individualCheckInNum(Map<String, Object> map) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int checkInNum;

        try {
            checkInNum = sqlSession.selectOne("mapper.HouseMapper.individualCheckInNum", map);
        } finally {
            sqlSession.close();
        }
        return checkInNum;
    }
}
