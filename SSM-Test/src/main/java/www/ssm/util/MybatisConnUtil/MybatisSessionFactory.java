package www.ssm.util.MybatisConnUtil;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisSessionFactory {
    private static final String CONFIG_FILE="mybatis/mybatis.cfg.xml";
    private static SqlSessionFactory sqlSessionFactory;
    private static final ThreadLocal<SqlSession> SESSION_THREAD_LOCAL = new ThreadLocal<SqlSession>();
    static{
        buildSqlSessionFactory();
    }
    public static SqlSessionFactory buildSqlSessionFactory(){
        try {
            InputStream inputStream = Resources.getResourceAsStream(CONFIG_FILE);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }
    public static SqlSession getSession(){
        SqlSession session = SESSION_THREAD_LOCAL.get();
        if(session ==null){
            session = sqlSessionFactory.openSession();
            SESSION_THREAD_LOCAL.set(session);
        }
        return session;
    }
    public static void close() {
        SqlSession session = SESSION_THREAD_LOCAL.get() ;
        if (session != null) {
            session.close();
            SESSION_THREAD_LOCAL.remove();
        }
    }
    /**
     * 获取SqlSessionFactory接口实例
     * @return 返回一个sessionFactory
     */
    public static SqlSessionFactory getSessionFactory() {
        return sqlSessionFactory ;
    }
}
