package entity;

public class CourseClassify {

    private int id;
    private String name;
    private String code;
    private String parent_code;

    public CourseClassify() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParent_code() {
        return parent_code;
    }

    public void setParent_code(String parent_code) {
        this.parent_code = parent_code;
    }

    @Override
    public String toString() {
        return "CourseClassify{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parent_code='" + parent_code + '\'' +
                '}';
    }
}
