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

    /*
    表格依次显示的列, 数据下标对照排序序号
     */
    private String[] columns = {
            "studentId",
            "password",
            "name",
            "department",
            "major",
            "classes",
            "gender",
            "inYear",
            "nativePlace",
            "phone",
            "email"
    };

    /**
     * 根据条件分页查询学生记录
     *
     * @param page       分页参数
     * @param department 学院
     * @param major      专业
     * @param classes    班级
     * @return 学生列表
     */
    public List<StudentEntity> getStudentsByCondition(PagingRequest page, String department, String major, String classes) {
        Integer limitStart = page.getStart();
        Integer limitLength = page.getLength();
        String orderBy = columns[page.getOrder().get(0).getColumn()];
        String dir = page.getOrder().get(0).getDir().toLowerCase();
        String orderDir = "asc".equals(dir) ? "asc" : ("desc".equals(dir) ? "desc" : "");

        return studentDao.getStudents(department, major, classes, limitStart, limitLength, orderBy, orderDir);
    }

    /**
     * 获取符合条件的学生总数
     *
     * @param department 学院
     * @param major      专业
     * @param classes    班级
     * @return 学生总数
     */
    public Integer getStudentTotal(String department, String major, String classes) {
        return studentDao.getTotal(department, major, classes);
    }
}
