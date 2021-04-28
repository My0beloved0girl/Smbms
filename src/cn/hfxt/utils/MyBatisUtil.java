 package cn.hfxt.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 工具类
 * @author Lenovo
 *
 */
public class MyBatisUtil {
	private static SqlSessionFactory factory;
	static{//在静态代码下，factory只会被创建一次
		try {
			InputStream is = Resources.getResourceAsStream("mybatisconfig.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	创建SqlSession对象和关闭SqlSession
	public static SqlSession createSqlSession() {
		return factory.openSession(false);//true为自动提交事务
	}
	public static void closeSqlSession(SqlSession sqlSession) {
		if(null != sqlSession) {
			sqlSession.close();
		}
	}
}
