package domain;
/*
id：属性值id
commodity_property_type_id：属性类别id			
name：属性值名称

 */
public class Commodity_attribute_value {
private int id;
private int commodity_info_id;
private String texture;
private String weight;
private String size;
public Commodity_attribute_value() {
	super();
	// TODO Auto-generated constructor stub
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommodity_info_id() {
        return commodity_info_id;
    }

    public void setCommodity_info_id(int commodity_info_id) {
        this.commodity_info_id = commodity_info_id;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Commodity_attribute_value{" +
                "id=" + id +
                ", commodity_info_id=" + commodity_info_id +
                ", texture='" + texture + '\'' +
                ", weight='" + weight + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
