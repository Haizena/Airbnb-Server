package airbnb.server.persistence.DAO;

import airbnb.server.persistence.DTO.LoginedUser;
import airbnb.server.persistence.DTO.UserDTO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;

public class UserDAO {
    private final SqlSessionFactory sqlSessionFactory;
    public UserDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public LoginedUser loginType(String id, String pw) {
        List<UserDTO> loginInfo = selectAll();
        for (UserDTO userDTO : loginInfo) {
            //input id,pw is exist -> return LoginedUser that have user's role and user's number
            if (userDTO.getId().equals(id) && userDTO.getPw().equals(pw)) {
                return new LoginedUser(userDTO.getRole(),userDTO.getUserNo());
            }
        }

        //if input id,pw is not exist -> return null
        return null;
    }
    public int insertUser(UserDTO userDTO){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int a = 0;
        try{
            a = sqlSession.insert("mapper.UserMapper.insertUser",userDTO);
            sqlSession.flushStatements();
            int newUserNo = sqlSession.selectOne("mapper.UserMapper.maxUserNo");
            userDTO.setUserNo(newUserNo);
            switch(userDTO.getRole()){
                case host:
                    sqlSession.insert("mapper.UserMapper.insertHost",userDTO.getUserNo());
                    break;
                case guest:
                    sqlSession.insert("mapper.UserMapper.insertGuest",userDTO.getUserNo());
                    break;
                case manager:
                    break;
            }
            sqlSession.flushStatements();
            sqlSession.commit();
        }finally{
            sqlSession.close();
        }
        return a;
    }

    //HashMap has keys "name", "phoneNum", "dateOfBirth", "user_no"
    public void modifyUser(HashMap<String,Object> modifyUser){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            sqlSession.selectList("mapper.UserMapper.userModify",modifyUser);
        } finally {
            sqlSession.close();
        }
    }

    //HashMap has keys "pw", "user_no"
    public void modifyPw(HashMap<String,Object> modifyUser){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            sqlSession.selectList("mapper.UserMapper.pwModify",modifyUser);
        } finally {
            sqlSession.close();
        }
    }

    private List<UserDTO> selectAll() {
        List<UserDTO> list = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            list = sqlSession.selectList("mapper.UserMapper.allUserInfo");
        } finally {
            sqlSession.close();
        }
        return list;
    }

    public String getPw(int user_no){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String pw;
        try {
            pw=sqlSession.selectOne("mapper.UserMapper.getPw",user_no);
        } finally {
            sqlSession.close();
        }
        return pw;
    }
}