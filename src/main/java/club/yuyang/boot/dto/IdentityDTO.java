package club.yuyang.boot.dto;

/**用于传输课表的用户信息
 * @author yuyang
 * @date 2019/10/14 20:35
 */
public class IdentityDTO {
    private Integer schoolId;
    private Integer instituteId;
    private Integer classmateId;
    private String types;

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(Integer instituteId) {
        this.instituteId = instituteId;
    }

    public Integer getClassmateId() {
        return classmateId;
    }

    public void setClassmateId(Integer classmateId) {
        this.classmateId = classmateId;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }
}
