package xyz.antsgroup.demo.spring.transaction.entity;

/**
 * 实验室使用表.
 * 记录一次使用总共容纳人数和已选人数.
 *
 * Created by Ants Young on 2016/7/16.
 */
public class LabRoomUsage {
    private int labRoomUsageId;
    private int labRoomId;
    private int timeFrom;
    private int courseId;
    private String teacherId;
    private int nowNum;
    private int maxNum;
    private String isOk;
    private String description;

    public LabRoomUsage() {
    }

    public LabRoomUsage(int labRoomUsageId, int labRoomId, int timeFrom, int courseId, String teacherId, int nowNum, int maxNum, String isOk, String description) {
        this.labRoomUsageId = labRoomUsageId;
        this.labRoomId = labRoomId;
        this.timeFrom = timeFrom;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.nowNum = nowNum;
        this.maxNum = maxNum;
        this.isOk = isOk;
        this.description = description;
    }

    public int getLabRoomUsageId() {
        return labRoomUsageId;
    }

    public void setLabRoomUsageId(int labRoomUsageId) {
        this.labRoomUsageId = labRoomUsageId;
    }

    public int getLabRoomId() {
        return labRoomId;
    }

    public void setLabRoomId(int labRoomId) {
        this.labRoomId = labRoomId;
    }

    public int getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(int timeFrom) {
        this.timeFrom = timeFrom;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public int getNowNum() {
        return nowNum;
    }

    public void setNowNum(int nowNum) {
        this.nowNum = nowNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public String getIsOk() {
        return isOk;
    }

    public void setIsOk(String isOk) {
        this.isOk = isOk;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "LabRoomUsage{" +
                "labRoomUsageId=" + labRoomUsageId +
                ", labRoomId=" + labRoomId +
                ", timeFrom=" + timeFrom +
                ", courseId=" + courseId +
                ", teacherId='" + teacherId + '\'' +
                ", nowNum=" + nowNum +
                ", maxNum=" + maxNum +
                ", isOk='" + isOk + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
