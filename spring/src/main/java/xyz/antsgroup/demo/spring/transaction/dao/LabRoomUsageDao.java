package xyz.antsgroup.demo.spring.transaction.dao;

import org.springframework.stereotype.Repository;

/**
 * 实验室使用表 DAO
 * Created by Ants Young on 2016/7/16.
 */
@Repository("labRoomUsageDao")
public interface LabRoomUsageDao {
    /**
     * 减少一条选课的剩余可选人数
     * @param id 使用记录 id
     * @return 是否减少成功,如果课程已将选满将减少失败
     */
    boolean subUsageById(int id);
}
