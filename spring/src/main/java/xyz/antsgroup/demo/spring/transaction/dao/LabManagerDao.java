package xyz.antsgroup.demo.spring.transaction.dao;

import org.springframework.stereotype.Repository;
import xyz.antsgroup.demo.spring.transaction.entity.LabManager;

/**
 * Created by Ants Young on 2016/7/16.
 */
@Repository("labManagerDao")
public interface LabManagerDao {
    /**
     * 添加一个管理员
     * @param labManager 管理员对象
     * @return 插入记录主键
     */
    int addLabManager(LabManager labManager);

    /**
     * 根据管理员 ID 获取管理员对象信息
     * @param id 管理员 ID
     * @return 管理员对象
     */
    LabManager getLabManagerById(String id);
}
