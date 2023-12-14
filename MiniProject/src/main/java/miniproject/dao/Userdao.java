package miniproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import miniproject.pojo.User;
import miniproject.util.DBConnection;

public class Userdao {
	Connection con=DBConnection.getConnection();

	public boolean Adduser(User u) {
		String sql="insert into customer (name,email,contact,password) values (?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getContact());
			ps.setString(4, u.getPassword());
			int i= ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();	}
		return false;
	}
	public boolean updateUser(User u) {
		String sql="update customer set name=?,email=?,contact=?,password=? where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getContact());
			ps.setString(4, u.getPassword());
			ps.setInt(5, u.getId());
			int i= ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();	}
		return false;
	}
	public boolean deleteUser(int id) {
		String sql="delete from customer where id=?";
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
	public List<User> getAll(){
		String sql="select * from customer";
		List<User> ulist=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				User u= new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setContact(rs.getString("contact"));
				u.setPassword(rs.getString("password"));
				ulist.add(u);
			}
			return ulist;

		} catch (Exception e) {
			e.printStackTrace();	
		}

		return null;

	}
	public User selectById(int id){
		String sql="select * from customer where id=?";
		User u= new User();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setContact(rs.getString("contact"));
				u.setPassword(rs.getString("password"));
				return u;
			}

		} catch (Exception e) {
			e.printStackTrace();	
		}

		return null;

	}
	public User LoginUser(String email, String password) {
		String sql="select * from customer where email=? and password=?";
		User u=null;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setContact(rs.getString("contact"));
				u.setPassword(rs.getString("password"));
			}
			return u;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
