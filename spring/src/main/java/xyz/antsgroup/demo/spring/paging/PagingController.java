package xyz.antsgroup.demo.spring.paging;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 结合 DataTables 分页查询的 Controller 示例
 */
@Controller
@RequestMapping("/paging")
public class PagingController {

    @Resource(name = "studentService")
    private StudentService studentService;

    /**
     * 学生显示页面
     *
     * @param map 表格头显示项
     * @return 学生页面
     */
    @RequestMapping("/students")
    public String student(Map<String, List> map) {
        map.put("heads", Arrays.asList("学号", "密码", "姓名", "学院", "专业", "班级", "性别", "入学年份", "籍贯", "电话", "邮箱"));
        return "paging/students";
    }

    /**
     * 根据查询条件进行学生记录查询, 如果有分页参数进行分页, 前端使用 DataTables 表格显示数据.
     *
     * @param paging     分页参数
     * @param department 学院
     * @param major      专业
     * @param classes    班级
     * @return 符合 DataTables 要求的响应格式
     */
    @RequestMapping(value = "/students/json")
    @ResponseBody
    public DataTablesResponse<StudentEntity> studentData(PagingRequest paging, String department,
                                                         String major, String classes) {
        List<StudentEntity> students = studentService.getStudentsByCondition(paging, department, major, classes);
        Integer studentTotal = studentService.getStudentTotal(department, major, classes);

        DataTablesResponse<StudentEntity> response = new DataTablesResponse<>();
        response.setDraw(paging.getDraw());
        response.setData(students);
        response.setRecordsTotal(studentTotal);
        response.setRecordsFiltered(studentTotal);
        return response;
    }


}
