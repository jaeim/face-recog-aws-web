package model.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.repository.mapper.MemberMapper;
import com.repository.mapper.SettingMapper;

import model.Member;
import model.Setting;

public class SettingDAO {
	private SqlSessionFactory sqlSessionFactory;
	private static SettingDAO dao = new SettingDAO();
	
	public SettingDAO() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		} sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static SettingDAO getInstance() {
		return dao;
	}
	
	public Setting selectSettingInfo() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		Setting setting = null;
		try {
			setting = sqlSession.getMapper(SettingMapper.class).selectSettingInfo();
			// blob을 컴퓨터 내에 저장하기
			
//			System.out.println("image : " + member.getImage_blob());
		} catch (Exception e) {
			sqlSession.close();
		}
		
		
		return setting;
	}
}
