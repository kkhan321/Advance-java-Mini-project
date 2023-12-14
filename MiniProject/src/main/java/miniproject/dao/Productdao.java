package miniproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import miniproject.pojo.Category;
import miniproject.pojo.Product;
import miniproject.util.DBConnection;

public class Productdao {
	Connection con=DBConnection.getConnection();

	public boolean Addproduct(Product p) {
		String sql="insert into product (product_name,price,description,category_id) values (?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, p.getProductName());
			ps.setDouble(2, p.getPrice());
			ps.setString(3, p.getDescription());
			ps.setInt(4, p.getCategory_id());
			int i= ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();	}
		return false;
	}
	public boolean updateProduct(Product p) {
		String sql="update product set product_name=?,price=?,description=?,category_id=? where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, p.getProductName());
			ps.setDouble(2, p.getPrice());
			ps.setString(3, p.getDescription());
			ps.setInt(4, p.getCategory_id());
			ps.setInt(5, p.getId());			
			int i= ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();	}
		return false;
	}
	public boolean deleteproduct(int id) {
		String sql="delete from product where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			int i= ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();	}
		return false;
	}
	public List<Product> getAll(){
		String sql="select id,product_name,price,description,category_id from product;";
		String sql1="select * from category where id=?";
		List<Product> ulist=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product u = new Product();
				u.setId(rs.getInt("id"));
				u.setProductName(rs.getString("product_name"));
				u.setPrice(rs.getInt("price"));
				u.setDescription(rs.getString("description"));
				int category_id=rs.getInt("category_id");
				u.setCategory_id(category_id);
				try {
                 ps=con.prepareStatement(sql1);
                 ps.setInt(1, category_id);
                 ResultSet rs1=ps.executeQuery();
                 Category c=new Category();
                 while(rs1.next()) {
                	c.setId(rs1.getInt("id"));
                	c.setName(rs1.getString("name"));
                	c.setDescription(rs1.getString("description"));
                 }
                 u.setCategory(c);
				} catch (Exception e) {
					e.printStackTrace();				
					}
				ulist.add(u);
			}
			return ulist;

		} catch (Exception e) {
			e.printStackTrace();	
		}

		return null;

	}
	public Product selectById(int id){
		String sql="select * from product where id=?";
		Product u= new Product();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				u.setId(rs.getInt("id"));
				u.setProductName(rs.getString("product_name"));
				u.setPrice(rs.getInt("price"));
				u.setDescription(rs.getString("description"));
				u.setCategory_id(rs.getInt("category_id"));
				return u;
			}

		} catch (Exception e) {
			e.printStackTrace();	
		}

		return null;

	}
	public List<Product> getAllProduct(){
		String sql=" select p.id, p.product_name,p.price,p.description,c.name as categoryname from product p inner join  category c on c.id=p.category_id";
		List<Product> ulist=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product u = new Product();
				u.setId(rs.getInt("id"));
				u.setProductName(rs.getString("product_name"));
				u.setPrice(rs.getInt("price"));
				u.setDescription(rs.getString("description"));
				//u.setCategory_id(rs.getInt("category_id"));
				u.setCategoryName(rs.getString("categoryname"));
				ulist.add(u);
			}
			return ulist;

		} catch (Exception e) {
			e.printStackTrace();	
		}

		return null;

	}
	public List<Product> getAllProduct(String searchname){//using different methods for fetching data from product using join this method is basically is using for searching a product from its name
		String sql=" select p.id product_id,product_name,price, p.description product_description,c.id category_id, c.name category_name,c.description category_description from product p inner join category c on c.id=p.category_id where product_name like '%"+searchname+"%'";
		List<Product> plist=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setPrice(rs.getInt(3));
				p.setDescription(rs.getString(4));
				p.setCategory_id(rs.getInt("category_id"));
				Category c=new Category();
				c.setId(rs.getInt(5));
				c.setName(rs.getString(6));
				c.setDescription(rs.getString(7));
				p.setCategory(c);
				plist.add(p);
			}
			return plist;
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
		
	}
	public List<Product> getAllProduct(int cid){
		String sql="select p.id product_id,product_name,price, p.description product_description,c.id category_id, c.name category_name,c.description category_description from product p inner join category c on c.id=p.category_id where category_id=?";
		List<Product> plist= new ArrayList<>();
		try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, cid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Product p=new Product();
			p.setId(rs.getInt(1));
			p.setProductName(rs.getString(2));
			p.setPrice(rs.getInt(3));
			p.setDescription(rs.getString(4));
			p.setCategory_id(rs.getInt("category_id"));
			Category c=new Category();
			c.setId(rs.getInt(5));
			c.setName(rs.getString(6));
			c.setDescription(rs.getString(7));
			p.setCategory(c);
			plist.add(p);
		}
		return plist;
	} catch (Exception e) {
	e.printStackTrace();
	}

		return null;
	}


}



