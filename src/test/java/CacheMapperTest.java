import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.CacheMapper;
import org.example.pojo.Emp;
import org.example.utils.SqlSessionUtils;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    @Test
    public void testOneCache() throws IOException {
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        CacheMapper cacheMapper=sqlSession.getMapper(CacheMapper.class);
        Emp emp1=cacheMapper.getEmpByEid(1);
        System.out.println(emp1);
        sqlSession.clearCache();
        Emp emp2=cacheMapper.getEmpByEid(1);
        System.out.println(emp2);
    }
    @Test
    public void testTwoCache(){
        try {
            InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession1= sqlSessionFactory.openSession(true);
            CacheMapper cacheMapper1=sqlSession1.getMapper(CacheMapper.class);
            Emp emp1=cacheMapper1.getEmpByEid(1);
            System.out.println(emp1);
            sqlSession1.close();
            SqlSession sqlSession2= sqlSessionFactory.openSession(true);
            CacheMapper cacheMapper2=sqlSession2.getMapper(CacheMapper.class);
            Emp emp2=cacheMapper2.getEmpByEid(1);
            System.out.println(emp2);
            sqlSession2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}