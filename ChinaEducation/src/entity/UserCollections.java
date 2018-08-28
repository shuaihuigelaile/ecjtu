package entity;

import java.util.Date;

public class UserCollections {
    private int id;
    private int user_id;
    private int course_id;
    private Date create_time;
    private String course_name;

    public UserCollections() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    @Override
    public String toString() {
        return "UserCollections{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", course_id=" + course_id +
                ", create_time=" + create_time +
                ", course_name='" + course_name + '\'' +
                '}';
    }
}
