package airbnb.server.persistence.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import airbnb.server.persistence.DTO.*;

public class ConvenienceDAO {
    private final SqlSessionFactory sqlSessionFactory;

    public ConvenienceDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public ConvenienceDTO selectConvenience(int house_no) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ConvenienceDTO convenienceDTO;
        try {
            HouseConveDTO houseConveDTO = sqlSession.selectOne("mapper.ConveMapper.selectHouseConve", house_no);
            BasicConveDTO basicConveDTO = sqlSession.selectOne("mapper.ConveMapper.selectBasicConve", houseConveDTO.getBasic_no());
            ManySearchConveDTO manySearchConveDTO = sqlSession.selectOne("mapper.ConveMapper.selectManySearchConve", houseConveDTO.getManysearch_no());
            SafetyConveDTO safetyConveDTO = sqlSession.selectOne("mapper.ConveMapper.selectSafetyConve", houseConveDTO.getSafety_no());
            AccessibilityConvesDTO accessibilityConvesDTO = sqlSession.selectOne("mapper.ConveMapper.selectAccessConve", houseConveDTO.getAccess_no());
            convenienceDTO = new ConvenienceDTO(basicConveDTO, manySearchConveDTO, safetyConveDTO, accessibilityConvesDTO, houseConveDTO);
        } finally {
            sqlSession.close();
        }
        return convenienceDTO;
    }

    public int insertHouseConve(HouseConveDTO houseConveDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int houseconve_no;

        try {
            sqlSession.insert("mapper.ConveMapper.insertHouseConve", houseConveDTO);
            sqlSession.flushStatements();
            sqlSession.commit();
            houseconve_no = maxHouseConve();
        } finally {
            sqlSession.close();
        }
        return houseconve_no;
    }

    public int maxHouseConve(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int max;
        try {
            max = sqlSession.selectOne("mapper.ConveMapper.maxHouseConve");
        } finally {
            sqlSession.close();
        }
        return max;
    }

    //return access_no;
    public int insertAccessConve(AccessibilityConvesDTO accessibilityConvesDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int maxAccess;

        try {
            sqlSession.insert("mapper.ConveMapper.accessibilityConve", accessibilityConvesDTO);
            sqlSession.flushStatements();
            sqlSession.commit();
            maxAccess = maxAccess();
            accessibilityConvesDTO.setAccessibilityconve_no(maxAccess);
        } finally {
            sqlSession.close();
        }
        return maxAccess;
    }

    public int maxAccess() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int max = 0;

        try {
            max = sqlSession.selectOne("mapper.ConveMapper.maxAccess");
        } finally {
            sqlSession.close();
        }
        return max;
    }

    //return BasicConve_no
    public int insertBasicConve(BasicConveDTO basicConveDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int maxBasic;
        try {
            sqlSession.insert("mapper.ConveMapper.basicConve", basicConveDTO);
            sqlSession.flushStatements();
            sqlSession.commit();
            maxBasic = maxBasic();
            basicConveDTO.setBasicconve_no(maxBasic);
        } finally {
            sqlSession.close();
        }
        return maxBasic;
    }

    public int maxBasic() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int max = 0;

        try {
            max = sqlSession.selectOne("mapper.ConveMapper.maxBasic");
        } finally {
            sqlSession.close();
        }
        return max;
    }

    public int insertManySerchConve(ManySearchConveDTO manySearchConveDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int maxManySearch_no;
        try {
            sqlSession.insert("mapper.ConveMapper.manySearchConve", manySearchConveDTO);
            sqlSession.flushStatements();
            sqlSession.commit();
            maxManySearch_no = maxManySearch();
            manySearchConveDTO.setManysearchconve_no(maxManySearch_no);
        } finally {
            sqlSession.close();
        }
        return maxManySearch_no;
    }

    public int maxManySearch() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int max = 0;

        try {
            max = sqlSession.selectOne("mapper.ConveMapper.maxManySearch");
        } finally {
            sqlSession.close();
        }
        return max;
    }

    public int insertSafetyConve(SafetyConveDTO safetyConveDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int maxSafety;

        try {
            sqlSession.insert("mapper.ConveMapper.safetyConve", safetyConveDTO);
            sqlSession.flushStatements();
            sqlSession.commit();
            maxSafety = maxSafety();
            safetyConveDTO.setSafetyconve_no(maxSafety);
        } finally {
            sqlSession.close();

        }
        return maxSafety;
    }

    public int maxSafety() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int max = 0;

        try {
            max = sqlSession.selectOne("mapper.ConveMapper.maxSafety");
        } finally {
            sqlSession.close();
        }
        return max;
    }

}
