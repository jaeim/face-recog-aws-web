package model.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import javax.imageio.ImageIO;

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
	
	public ArrayList<Member> selectAllMember(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ArrayList<Member> memberList = null;
		try {
			memberList = sqlSession.getMapper(MemberMapper.class).selectAllMember();
		} catch (Exception e) {
		} finally {
			sqlSession.close();
		}
		return memberList;
	}
	
	public Member selectOneMemberByLoginId(String login_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Member member = null;
		try {
			member = sqlSession.getMapper(MemberMapper.class).selectOneMemberByLoginId(login_id);
			// blob을 컴퓨터 내에 저장하기
			
//			System.out.println("image : " + member.getImage_blob());
		} catch (Exception e) {
		}finally {
			sqlSession.close();
		}
		return member;
	}
	
	public Member selectOneMemberById(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Member member = null;
		try {
			member = sqlSession.getMapper(MemberMapper.class).selectOneMemberById(id);
	
		} catch (Exception e) {
		} finally {
			sqlSession.close();
		}
		return member;
	}
	
	public Member loginCheck(String login_id, String password) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Member member = null;
		try {
			member = sqlSession.getMapper(MemberMapper.class).loginCheck(login_id, password);

		} catch (Exception e) {
		}finally {
			sqlSession.close();
		}
		return member;
	}
	
	public int countAllMember( ) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int count = 0;
		try {
			count = sqlSession.getMapper(MemberMapper.class).countAllMember();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sqlSession.close();
		}
		return count;
	}
	
	
}
