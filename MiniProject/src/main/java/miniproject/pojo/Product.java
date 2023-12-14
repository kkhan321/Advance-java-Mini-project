package miniproject.pojo;

public class Product {
private int id;
private String productName;
private double price;
private String description;
private int category_id;
private Category category; 
private String categoryName;

public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getCategory_id() {
	return category_id;
}
public void setCategory_id(int category_id) {
	this.category_id = category_id;
}

}
