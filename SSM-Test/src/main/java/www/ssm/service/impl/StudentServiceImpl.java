package www.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.ssm.dao.IStudentDao;
import www.ssm.pojo.Student;
import www.ssm.service.IStudentService;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;

    @Override
    public boolean add(Student student) {
        return this.studentDao.doCreate(student);
    }

    @Override
    public Student get(Long id) {
        return this.studentDao.findById(id);
    }

    @Override
    public Map<String, Object> list(String column, String keyword, long currentPage, int lineSize) {
        //结果返回
        Map<String,Object> result = new HashMap<>();
        //参数传递
        Map<String,Object> params = new HashMap<>();
        params.put("column",column);
        params.put("keyword",keyword);
        params.put("start",(currentPage-1) *lineSize);
        params.put("lineSize",lineSize);
        result.put("allRecorders",this.studentDao.getAllCount(params));
        result.put("allStudents",this.studentDao.findSplit(params));
        return result;
    }
}
