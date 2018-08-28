package domain;

/**
 * @auther:houkexin
 * @date: 2018/7/27
 * @description:
 * @version: 1.0
 */
public class AdminUser {
    private int id;
    private String adminName;
    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
