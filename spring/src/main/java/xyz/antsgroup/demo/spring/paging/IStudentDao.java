package xyz.antsgroup.demo.spring.paging;

import java.util.List;

/**
 *
 */
public interface IStudentDao {

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
    List<StudentEntity> getStudents(String department, String major, String classes,
                                    Integer limitLength, Integer limitStart, String orderBy, String orderDir);

    /**
     * 获取符合条件的学生总数
     *
     * @param department 学院
     * @param major      专业
     * @param classes    班级
     * @return 学生总数
     */
    Integer getTotal(String department, String major, String classes);
}
