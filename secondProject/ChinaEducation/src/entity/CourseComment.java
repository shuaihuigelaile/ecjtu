package entity;

import java.util.Date;

public class CourseComment {

    private int id;
    private String username;
    private String to_username;
    private int course_id;
    private int section_id;
    private String section_title;
    private String content;
    private Date create_time;

    public CourseComment() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTo_username() {
        return to_username;
    }

    public void setTo_username(String to_username) {
        this.to_username = to_username;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getSection_id() {
        return section_id;
    }

    public void setSection_id(int section_id) {
        this.section_id = section_id;
    }

    public String getSection_title() {
        return section_title;
    }

    public void setSection_title(String section_title) {
        this.section_title = section_title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "CourseComment{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", to_username='" + to_username + '\'' +
                ", course_id=" + course_id +
                ", section_id=" + section_id +
                ", section_title='" + section_title + '\'' +
                ", content='" + content + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
