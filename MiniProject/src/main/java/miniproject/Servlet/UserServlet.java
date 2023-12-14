package miniproject.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.dao.Userdao;
import miniproject.pojo.User;
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	User u= new User();
	Userdao ud=new Userdao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
	HttpSession session=request.getSession();
	String action=request.getParameter("action");
	
	if(action!=null && action.equals("edit")) {
		int id=Integer.parseInt(request.getParameter("id"));
		User u=ud.selectById(id);
		session.setAttribute("u",u);
		response.sendRedirect("updateProfile.jsp");
	}
	else if(action!=null && action.equals("delete")) {
		int id=Integer.parseInt(request.getParameter("id"));
     boolean b= ud.deleteUser(id);
     if(b) {
    	 response.sendRedirect("UserServlet");
     }
     else {
    	 response.sendRedirect("Error.jsp");
     }
	}
	
	else {
     List<User> ulist=ud.getAll();
     session.setAttribute("u",ulist);
     response.sendRedirect("Userlist.jsp");
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String password=request.getParameter("password");
		u.setContact(contact);u.setEmail(email);u.setName(name);
		u.setPassword(password);
		if(action!=null & action.equals("adduser")) {
			boolean b=ud.Adduser(u);
			if(b) {
				response.sendRedirect("index.jsp");
			}
			else {
				response.sendRedirect("error.jsp");
			}
		}
		else if( action!=null && action.equals("updateuser")) {
			int id=Integer.parseInt(request.getParameter("id"));
			u.setId(id);
			boolean b=ud.updateUser(u);
			if(b) {
				response.sendRedirect("index.jsp");
			}
			else {
				response.sendRedirect("Error.jsp");
			}
		}
		else {
			
		}
		
		
	}

}
