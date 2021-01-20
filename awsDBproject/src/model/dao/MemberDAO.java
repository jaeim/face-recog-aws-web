package model.dao;

import java.io.InputStream;
import java.util.Map;

import org.apache.catalina.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mysql.cj.jdbc.Blob;
import com.repository.mapper.MemberMapper;

import model.Member;

public class MemberDAO {
	private SqlSessionFactory sqlSessionFactory;
	private static MemberDAO dao = new MemberDAO();
	
	public MemberDAO() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		} sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static MemberDAO getInstance() {
		return dao;
	}
	
	public Member selectOneMemberByLoginId(String login_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Member member = null;
		try {
			member = sqlSession.getMapper(MemberMapper.class).selectOneMemberByLoginId(login_id);
			// blob을 컴퓨터 내에 저장하기?
			
			System.out.println("image : " + member.getImage_blob());
		} catch (Exception e) {
			sqlSession.close();
		}
		return member;
	}
}
