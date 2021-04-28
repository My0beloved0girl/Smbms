package cn.hfxt.dao.user;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import cn.hfxt.dao.Smbms_Dao;
import cn.hfxt.dao.Sudao;
import cn.hfxt.entity.smbms_user;
import cn.hfxt.utils.MyBatisUtil;


public class UserMapperTest {
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException{
		String resource="mybatis-config.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	private Logger logger = Logger.getLogger(UserMapperTest.class);
	
	@Before
	public void setUp() throws Exception{

	}
	
	@Test
	public void test() {
		smbms_user su = null;
		SqlSession sqlSession=null;
		//1获取SqlSessionFactory对象
		SqlSessionFactory sqlsessionFactory;
		try {
			sqlsessionFactory = getSqlSessionFactory();
			//2.获取SqlSession对象
			sqlSession =  sqlsessionFactory.openSession();
			
			//3.获取接口的实现对象
			//em = sqlSession.getMapper(EmailUserDao.class); 
			//getSqlSessionFactory().getConfiguration().addMapper(Sudao.class);
			List<smbms_user> list = sqlSession.getMapper(Sudao.class).getsele();
			//emailUserDao.getid(1);
			for (smbms_user smbms : list) {
				System.out.println(smbms);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	
	@Test
	public void test01(){
		SqlSession createSqlSession = MyBatisUtil.createSqlSession();
		Smbms_Dao mapper = createSqlSession.getMapper(Smbms_Dao.class);
		System.out.println(mapper.SeleCount());
		System.out.println(mapper.SeleAll(0, 6));
	}

}
