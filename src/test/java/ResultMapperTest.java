import org.apache.ibatis.session.SqlSession;
import org.example.mapper.DeptMapper;
import org.example.mapper.EmpMapper;
import org.example.pojo.Dept;
import org.example.pojo.Emp;
import org.example.utils.SqlSessionUtils;
import org.junit.Test;
import java.io.IOException;
import java.util.List;

public class ResultMapperTest {
    @Test
    public void testGetAllEmp() throws IOException {
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        List<Emp> list=empMapper.getAllEmp();
        list.forEach(emp -> System.out.println(emp));
    }
    @Test
    public void testGetEmpAndDept() throws IOException {
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        Emp emp=empMapper.getEmpAndDept(1);
        System.out.println(emp);
    }
    @Test
    public void testGetEmpAndDeptByStep() throws IOException {
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        Emp emp=empMapper.getEmpAndDeptByStepOne(3);
        System.out.println(emp.getEmpName());
        System.out.println(emp.getDept());
    }
    @Test
    public void testGetDeptAndEmp() throws IOException {
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        DeptMapper deptMapper=sqlSession.getMapper(DeptMapper.class);
        Dept dept=deptMapper.getDeptAndEmp(1);
        System.out.println(dept);
    }
    @Test
    public void testGetDeptAndEmpByStep() throws IOException {
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        DeptMapper deptMapper=sqlSession.getMapper(DeptMapper.class);
        Dept dept=deptMapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept);
    }
}
