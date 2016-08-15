package xyz.antsgroup.demo.spring.paging;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("/paging")
public class PagingController {

    @RequestMapping("/students")
    public String student(Map<String, List> map) {
        map.put("heads", Arrays.asList("学号","密码","姓名","学院","专业","班级","性别","入学年份","籍贯","电话","邮箱"));
        return "paging/students";
    }

    @RequestMapping(value = "/students", produces = "application/json")
    @ResponseBody
    public ResponseQuery studentData(PageQuery page, String department, String major, String classes) {
        ResponseQuery responseQuery = new ResponseQuery();
        System.out.println("Request query page:\n" + page + "\n" + department + "\n" + major + "\n" + classes);
        return responseQuery;
    }
}
