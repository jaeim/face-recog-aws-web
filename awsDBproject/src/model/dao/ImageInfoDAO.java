package model.dao;

import java.io.InputStream;
import java.util.ArrayList;

import model.ImageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.repository.mapper.ImageInfoMapper;

public class ImageInfoDAO {
	private SqlSessionFactory sqlSessionFactory;
	private static ImageInfoDAO dao = new ImageInfoDAO();
	
	public ImageInfoDAO() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		} sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static ImageInfoDAO getInstance() {
		return dao;
	}
	
	public ArrayList<ImageInfo> selectAllImageInfo(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ArrayList<ImageInfo> imageInfoList = null;
		
		try {
			imageInfoList = sqlSession.getMapper(ImageInfoMapper.class).selectAllImageInfo();		
			System.out.println(imageInfoList.get(0).getUSER_ID());
			
		}catch(Exception e) {
			sqlSession.close();
			System.out.print(e.getMessage());
		}
		
		return imageInfoList;
	}
	
	public ArrayList<ImageInfo> selectImageInfoByWorkId(int work_id){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ArrayList<ImageInfo> imageInfoList = null;
		
		try {
			imageInfoList = sqlSession.getMapper(ImageInfoMapper.class).selectImageInfoByWorkId(work_id);
			
		}catch(Exception e) {
			sqlSession.close();
			System.out.print(e.getMessage());
		}
		
		return imageInfoList;
	}
	
	public int insertImageInfo(ImageInfo imageInfo) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			result = sqlSession.getMapper(ImageInfoMapper.class).insertImageInfo(imageInfo);
			sqlSession.commit();
		}catch(Exception e) {
			sqlSession.close();
			System.out.print(e.getMessage());
		}
		
		return result;
	}
}
