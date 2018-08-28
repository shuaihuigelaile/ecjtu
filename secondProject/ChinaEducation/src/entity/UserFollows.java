package entity;

import java.util.Date;

public class UserFollows {

    private int id;
    private int user_id;
    private int follow_id;
    private Date create_time;
    private String follow_name;

    public UserFollows() {

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

    public int getFollow_id() {
        return follow_id;
    }

    public void setFollow_id(int follow_id) {
        this.follow_id = follow_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getFollow_name() {
        return follow_name;
    }

    public void setFollow_name(String follow_name) {
        this.follow_name = follow_name;
    }

    @Override
    public String toString() {
        return "UserFollows{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", follow_id=" + follow_id +
                ", create_time=" + create_time +
                ", follow_name='" + follow_name + '\'' +
                '}';
    }
}
