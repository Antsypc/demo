package xyz.antsgroup.demo.spring.transaction.entity;

/**
 * 学生选课表
 * Created by Ants Young on 2016/7/16.
 */
public class CourseChooseLog {
    private int courseChooseLogId ;
    private String studentId ;
    private int labRoomUsageId ;
    private int time ;

    public CourseChooseLog() {
    }

    public CourseChooseLog(int courseChooseLogId, String studentId, int labRoomUsageId, int time) {
        this.courseChooseLogId = courseChooseLogId;
        this.studentId = studentId;
        this.labRoomUsageId = labRoomUsageId;
        this.time = time;
    }

    public int getCourseChooseLogId() {
        return courseChooseLogId;
    }

    public void setCourseChooseLogId(int courseChooseLogId) {
        this.courseChooseLogId = courseChooseLogId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getLabRoomUsageId() {
        return labRoomUsageId;
    }

    public void setLabRoomUsageId(int labRoomUsageId) {
        this.labRoomUsageId = labRoomUsageId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CourseChooseLog{" +
                "courseChooseLogId=" + courseChooseLogId +
                ", studentId='" + studentId + '\'' +
                ", labRoomUsageId=" + labRoomUsageId +
                ", time=" + time +
                '}';
    }
}
