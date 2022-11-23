package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Emp;
import java.util.List;

public interface DynamicSQLMapper {
    /*
    * 多条件查询(结果数目不确定,故使用List作为返回值类型)
    * */
    List<Emp>getEmpByCondition(Emp emp);
    /*
    * 测试choose、when、otherwise
    * */
    List<Emp>getEmpByChoose(Emp emp);
    /*
    * 通过数组实现批量删除
    * */
    int deleteMoreByArray(@Param("eids") Integer[] eids);
    /*
    * 通过list集合实现批量添加
    * */
    int insertMoreByList(@Param("emps") List<Emp>emps);
}