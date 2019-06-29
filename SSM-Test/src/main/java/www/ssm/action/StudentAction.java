package www.ssm.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import www.ssm.pojo.Student;
import www.ssm.service.IStudentService;
import www.ssm.util.abs.AbstractAction;

@Controller
@RequestMapping("/pages/admin/student/*")
public class StudentAction extends AbstractAction {
    @Autowired
    public IStudentService studentService;
    @RequestMapping("add_pre")
    public String addPre(){
        return super.getMessage("student.add.page");
    }
    @RequestMapping("add")
    public ModelAndView add(Student student){
        System.out.println("学生业务增加" + this.studentService.add(student));
        return null;
    }
}
