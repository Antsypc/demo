package xyz.antsgroup.demo.spring.paging;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Repository("studentDao")
public class StudentDao implements IStudentDao{

    @Autowired
    private SqlSession session;

    @Override
    public List<StudentEntity> getStudents(String department, String major, String classes, PageQuery pageQuery) {
        Map<String, Object> map = new HashMap<>();
        map.put("department", department);
        map.put("major", major);
        map.put("classes", classes);
        map.put("orderBy", pageQuery.getOrder());
        if (!StringUtils.isEmpty(pageQuery.getOrder())) {
            if ("asc".equals(pageQuery.getAsc())) {
                map.put("orderWay", "ASC");
            } else if ("desc".equals(pageQuery.getAsc())){
                map.put("orderWay", "DESC");
            }
        }

        if (pageQuery.getPerPage() > 0) {
            map.put("limitFrom", (pageQuery.getCurrent() - 1) * pageQuery.getPerPage());
            map.put("limitSize", pageQuery.getPerPage());
        }
        return session.selectList("xyz.antsgroup.demo.spring.paging.StudentDao.getStudents", map);
    }


}
