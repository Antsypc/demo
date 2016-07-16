package xyz.antsgroup.demo.spring.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.antsgroup.demo.spring.transaction.dao.CourseChooseLogDao;
import xyz.antsgroup.demo.spring.transaction.dao.LabRoomUsageDao;
import xyz.antsgroup.demo.spring.transaction.entity.CourseChooseLog;

/**
 * 选课 service
 * Created by Ants Young on 2016/7/16.
 */
@Service("chooseCourseService")
public class ChooseCourseService {

    @Autowired
    CourseChooseLogDao logDao;

    @Autowired
    LabRoomUsageDao usageDao;

    @Autowired
    LabManagerService labManagerService;

    @Transactional
    public boolean chooseCourse(String studentId, int roomUsageId) {
        int logKey;
        if (usageDao.subUsageById(roomUsageId)) {
//            int b = 1/0;
            CourseChooseLog log = new CourseChooseLog();
            log.setLabRoomUsageId(roomUsageId);
            log.setStudentId(studentId);
            log.setTime(0);
            logKey = logDao.addLog(log);
//            System.out.println(labManagerService.getLabManagerById("87654321"));  // 测试事务传播的问题
//            int c = 1 / 0;
            return logKey > 0;
        }
        return false;
    }
}
