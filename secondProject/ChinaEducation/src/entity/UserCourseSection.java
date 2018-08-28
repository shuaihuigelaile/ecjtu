package entity;

import java.util.Date;

public class UserCourseSection {
    private int id;
    private int user_id;
    private int course_id;
    private int section_id;
    private int status;
    private int rate;
    private Date update_time;
    private Date create_time;

    public UserCourseSection() {

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

    public int getSection_id() {
        return section_id;
    }

    public void setSection_id(int section_id) {
        this.section_id = section_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "UserCourseSection{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", course_id=" + course_id +
                ", section_id=" + section_id +
                ", status=" + status +
                ", rate=" + rate +
                ", update_time=" + update_time +
                ", create_time=" + create_time +
                '}';
    }
}
