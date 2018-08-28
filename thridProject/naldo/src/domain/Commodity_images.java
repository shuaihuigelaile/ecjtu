package domain;
/*
id:商品图片id
commodity_id:商品id
path：图片相对地址

 */
public class Commodity_images {
 private int id;
 private int commodity_id;
 private String path;
public Commodity_images() {
	super();
	// TODO Auto-generated constructor stub
}
public Commodity_images(int id, int commodity_id, String path) {
	super();
	this.id = id;
	this.commodity_id = commodity_id;
	this.path = path;
}
/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the commodity_id
 */
public int getCommodity_id() {
	return commodity_id;
}
/**
 * @param commodity_id the commodity_id to set
 */
public void setCommodity_id(int commodity_id) {
	this.commodity_id = commodity_id;
}
/**
 * @return the path
 */
public String getPath() {
	return path;
}
/**
 * @param path the path to set
 */
public void setPath(String path) {
	this.path = path;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "commodity_images [id=" + id + ", commodity_id=" + commodity_id + ", path=" + path + "]";
}
 
}
