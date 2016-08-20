package xyz.antsgroup.demo.spring.paging;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Repository("studentDao")
public class StudentDao implements IStudentDao {

    @Autowired
    private SqlSession session;

    /**
     * 根据条件分页查询学生记录
     *
     * @param department  学院
     * @param major       专业
     * @param classes     班级
     * @param limitLength 分页每页记录数
     * @param limitStart  分页开始记录数
     * @param orderBy     排序字段
     * @param orderDir    desc?asc?
     * @return 学生列表
     */
    @Override
    public List<StudentEntity> getStudents(String department, String major, String classes,
                                           Integer limitStart, Integer limitLength, String orderBy, String orderDir) {
        Map<String, Object> map = new HashMap<>();
        map.put("department", department);
        map.put("major", major);
        map.put("classes", classes);
        map.put("orderBy", orderBy);
        map.put("orderDir", orderDir);
        map.put("limitStart", String.valueOf(limitStart));
        map.put("limitLength", String.valueOf(limitLength));
        return session.selectList("xyz.antsgroup.demo.spring.paging.StudentDao.getStudents", map);
    }

    /**
     * 获取符合条件的学生总数
     *
     * @param department 学院
     * @param major      专业
     * @param classes    班级
     * @return 学生总数
     */
    @Override
    public Integer getTotal(String department, String major, String classes) {
        Map<String, Object> map = new HashMap<>();
        map.put("department", department);
        map.put("major", major);
        map.put("classes", classes);
        return session.selectOne("xyz.antsgroup.demo.spring.paging.StudentDao.getTotal", map);
    }


}
