package model.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.repository.mapper.MemberMapper;

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
		
		Setting setting = new Setting();
		
		return setting;
	}
}
