package xyz.antsgroup.demo.spring.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.antsgroup.demo.spring.transaction.dao.LabManagerDao;
import xyz.antsgroup.demo.spring.transaction.entity.LabManager;

/**
 * 管理员用户信息相关操作类
 *
 * Created by Ants Young on 2016/7/16.
 */
@Service("labManagerService")
public class LabManagerService {

    @Autowired
    LabManagerDao labManagerDao;

    /**
     * 添加一个管理员
     * @param labManager 管理员对象
     * @return 插入记录主键
     */
    public boolean addLabManager(LabManager labManager) {
        int key = labManagerDao.addLabManager(labManager);
        System.out.println("manager key:" + key);
        return true;
    }

    /**
     * 根据管理员 ID 获取管理员对象信息
     * @param id 管理员 ID
     * @return 管理员对象
     */
    @Transactional(propagation = Propagation.REQUIRED)
    LabManager getLabManagerById(String id) {
        return labManagerDao.getLabManagerById(id);
    }
}
