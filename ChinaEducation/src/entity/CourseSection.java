package entity;

public class CourseSection {

    private int id;
    private int course_id;
    private int parent_id;
    private String name;
    private String time;
    private String video_url;

    public CourseSection() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    @Override
    public String toString() {
        return "CourseSection{" +
                "id=" + id +
                ", course_id=" + course_id +
                ", parent_id=" + parent_id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", video_url='" + video_url + '\'' +
                '}';
    }
}
