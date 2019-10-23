package club.yuyang.boot.entity;

/**
 * @author yuyang
 * @date 2019/9/11 11:00
 */
public class School {

    private Integer schoolId;//学校编号，学院的外键
    private String schoolName;//学校名称

    public Integer getSchoolId() { return schoolId; }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
