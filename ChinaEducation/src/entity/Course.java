package entity;

public class Course {

    private int id;
    private String name;
    private String classify;
    private String classify_name;
    private String sub_classify;
    private String sub_classify_name;
    private String username;
    private int level;
    private String duration;
    private String brief;
    private int study_count;
    private int weight;
    private  String price;
    private String oldprice;

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

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getClassify_name() {
        return classify_name;
    }

    public void setClassify_name(String classify_name) {
        this.classify_name = classify_name;
    }

    public String getSub_classify() {
        return sub_classify;
    }

    public void setSub_classify(String sub_classify) {
        this.sub_classify = sub_classify;
    }

    public String getSub_classify_name() {
        return sub_classify_name;
    }

    public void setSub_classify_name(String sub_classify_name) {
        this.sub_classify_name = sub_classify_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public int getStudy_count() {
        return study_count;
    }

    public void setStudy_count(int study_count) {
        this.study_count = study_count;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOldprice() {
        return oldprice;
    }

    public void setOldprice(String oldprice) {
        this.oldprice = oldprice;
    }
}
