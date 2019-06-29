package www.ssm.dao;

import www.ssm.pojo.Student;

import java.util.List;
import java.util.Map;

public interface IStudentDao {
    public boolean doCreate(Student student);
    public Student findById(Long sid);

    /**
     * 进行数据的分页显示
     * key = column 、 value=传递的查询列
     * key = keyword 、value=模糊查询关键字
     * key = start  、 value=开始的行数
     * key = lineSize 、value=每页显示数据
     *
     * 如果此时没有传递column 或者是keyword参数，则表示对全部数据进行分页
     * @param params
     * @return
     */
    public List<Student> findSplit(Map<String,Object> params);

    /**
     * 进行个数的统计处理
     * key = column value=要进行查询的列
     * key = keyword value =模糊查询的关键字
     * @param params
     * @return
     */
    public Long getAllCount(Map<String,Object> params);
}
