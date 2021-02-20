package model.dao;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.repository.mapper.LogInfoMapper;
import com.repository.mapper.WorkingInfoMapper;

import model.LogInfo;
import model.WorkingInfo;

public class WorkingInfoDAO {
	private SqlSessionFactory sqlSessionFactory;
	private static WorkingInfoDAO dao = new WorkingInfoDAO();
	
	public WorkingInfoDAO() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		} sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static WorkingInfoDAO getInstance() {
		return dao;
	}
	
	public ArrayList<WorkingInfo> selecWorkingInfoById(int log_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		ArrayList<WorkingInfo> workingInfoList = null;
		try {
			workingInfoList = sqlSession.getMapper(WorkingInfoMapper.class).selectWorkingInfoById(log_id);
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}finally {
			sqlSession.close();
		}
		
		return workingInfoList;
	}
	
	public int insertWorkingInfo(WorkingInfo workingInfo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int result = 0;
		try {
			result = sqlSession.getMapper(WorkingInfoMapper.class).insertWorkingInfo(workingInfo);
			if(result > 0) {
				sqlSession.commit();
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}finally {
			sqlSession.close();
		}
		
		return result;
	}
}
