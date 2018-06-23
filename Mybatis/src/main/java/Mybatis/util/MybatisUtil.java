package Mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static{
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        try {
            sqlSessionFactory= sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis.xml"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static  SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
