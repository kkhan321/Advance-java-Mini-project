package miniproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import miniproject.pojo.Category;
import miniproject.util.DBConnection;

public class Categorydao 
{
	Connection con=DBConnection.getConnection();

	public boolean Adduser(Category c) {
		String sql="insert into category (name,description) values (?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getDescription());
			int i= ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();	}
		return false;
	}
	public boolean updateUser(Category c) {
		String sql="update category set name=?,description=? where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getDescription());
			ps.setInt(3, c.getId());
			int i= ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();	}
		return false;
	}
	public boolean deleteUser(int id) {
		String sql="delete from category where id=?";
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
	public List<Category> getAll(){
		String sql="select * from category";
		List<Category> clist=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Category c= new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));
				clist.add(c);
			}
			return clist;

		} catch (Exception e) {
			e.printStackTrace();	
		}

		return null;

	}
	public Category selectById(int id){
		String sql="select * from category where id=?";
		Category c= new Category();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));
			}
			return c;

		} catch (Exception e) {
			e.printStackTrace();	
		}

		return null;

	}


}
