package xyz.antsgroup.demo.spring.paging;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service("studentService")
public class StudentService {
    @Resource(name = "studentDao")
    private IStudentDao studentDao;


    public List<StudentEntity> getStudentsByCondition(PageQuery page, String department, String major, String classes) {
        return studentDao.getStudents(department, major, classes, page);
    }
}
