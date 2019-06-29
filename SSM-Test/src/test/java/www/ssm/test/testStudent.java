package www.ssm.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import www.ssm.pojo.Student;
import www.ssm.service.IStudentService;
@ContextConfiguration(locations = "classpath:spring/spring-base.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class testStudent {
    @Autowired
    private IStudentService studentService;
    @Test
    public void testAdd(){
        Student student = new Student();
        student.setSname("李久沅");
        System.out.println(this.studentService.add(student));
    }
    @Test
    public void testGet(){
        System.out.println(this.studentService.get(23L));
    }
    @Test
    public void testList(){
        System.out.println(
                this.studentService.list(
                            "sname","%李%",1,5)
        );
    }
}

