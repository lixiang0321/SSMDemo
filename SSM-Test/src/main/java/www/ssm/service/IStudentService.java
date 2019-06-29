package www.ssm.service;

import org.springframework.cache.annotation.Cacheable;
import www.ssm.pojo.Student;

import java.util.Map;

public interface IStudentService {
    public boolean add(Student student);
    @Cacheable(cacheNames = "student")
    public Student get(Long id);
    public Map<String,Object> list(String column, String keyword, long currentPage, int lineSize);
}
