import org.apache.ibatis.session.SqlSession;
import org.example.mapper.DynamicSQLMapper;
import org.example.pojo.Emp;
import org.example.utils.SqlSessionUtils;
import org.junit.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {
    @Test
    public void testGetEmpByCondition() throws IOException {
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper=sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp>list=dynamicSQLMapper.getEmpByCondition(new Emp(null,null,null,"男",""));
        System.out.println(list);
    }
    @Test
    public void testGetEmpByChoose() throws IOException {
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper=sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp>list=dynamicSQLMapper.getEmpByChoose(new Emp(null,"张三",18,"女","135"));
        System.out.println(list);
    }
    @Test
    public void testDeleteMoreByArray() throws IOException {
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper=sqlSession.getMapper(DynamicSQLMapper.class);
        int result=dynamicSQLMapper.deleteMoreByArray(new Integer[]{6,7,8});
        System.out.println(result);
    }
    @Test
    public void testInsertMoreByList() throws IOException {
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper=sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1=new Emp(null,"a1",23,"男","123@qq.com");
        Emp emp2=new Emp(null,"a2",23,"男","123@qq.com");
        Emp emp3=new Emp(null,"a3",23,"男","123@qq.com");
        List<Emp>list=Arrays.asList(emp1,emp2,emp3);
        System.out.println(dynamicSQLMapper.insertMoreByList(list));
    }
}
