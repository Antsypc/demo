package xyz.antsgroup.demo.spring.transaction.dao;

import org.springframework.stereotype.Repository;
import xyz.antsgroup.demo.spring.transaction.entity.CourseChooseLog;

/**
 * 学生选课表 DAO
 * Created by Ants Young on 2016/7/16.
 */
@Repository("courseChooseLogDao")
public interface CourseChooseLogDao {

    /**
     * 增加一条选课记录
     * @param log CourseChooseLog 实例
     * @return 添加记录的主键
     */
    int addLog(CourseChooseLog log);

}
