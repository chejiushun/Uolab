/**
 * 太原科技大学(c)版权所有 2020-2023
 */
package com.yckj.uol.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


/**
 *MyBatisUtil工具类
 * @author liuxinda
 * @version 1.0
 */
public class MyBatisUtil {
	private static  InputStream  inputStream = null;
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		String resource = "mybatis-config.xml";
		
		// 1.读取资源配置文件
		try {
			inputStream = Resources.getResourceAsStream(resource);
			// 2.创建SqlSessionFactory对象
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	}
	/**
	 * 获取sqlSession 对象
	 * @return
	 */
	 public static  SqlSession getSqlSession() {
		 return sqlSessionFactory.openSession();	
	}
	 /**
	  * 关闭链接 ，释放资源
	  * @param sqlSession
	  */
	 public static void close(SqlSession sqlSession) {
		 sqlSession.close();
	 }
	 
}
