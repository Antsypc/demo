package xyz.antsgroup.demo.spring.paging;

import java.util.List;

/**
 *
 */
public interface IStudentDao {
    List<StudentEntity> getStudents(String department, String major, String classes, PageQuery pageQuery);
}
