package model.dao;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.repository.mapper.LogInfoMapper;

import model.LogInfo;

public class LogInfoDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	private static LogInfoDAO dao = new LogInfoDAO();
	
	public LogInfoDAO() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		} sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static LogInfoDAO getInstance() {
		return dao;
	}
	
	public ArrayList<LogInfo> selectLogInfoById(int user_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		ArrayList<LogInfo> logInfoList = null;
		try {
			logInfoList = sqlSession.getMapper(LogInfoMapper.class).selectLogInfoById(user_id);
		}catch(Exception e) {
			sqlSession.close();
			System.out.print(e.getMessage());
		}
		
		return logInfoList;
	}
	
	public int insertLogInfo(LogInfo logInfo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int result = 0;
		try {
			result = sqlSession.getMapper(LogInfoMapper.class).insertLogInfo(logInfo);
			if(result > 0) {
				sqlSession.commit();
			}
		}catch(Exception e) {
			sqlSession.close();
			System.out.print(e.getMessage());
		}
		
		return result;
	}
}
