package miniproject.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.dao.Categorydao;
import miniproject.pojo.Category;
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	Category c=new Category();
	Categorydao cd=new Categorydao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String action=request.getParameter("action");

		if(action!=null && action.equals("delete")) {
			int id=Integer.parseInt(request.getParameter("id"));
			boolean b=cd.deleteUser(id);
			response.sendRedirect("CategoryServlet");
		}
		else if(action!=null && action.equals("edit")) {
			int id=Integer.parseInt(request.getParameter("id"));
			Category c=cd.selectById(id);
			session.setAttribute("category", c);
			response.sendRedirect("updatecategory.jsp");
			//response.sendRedirect("CategoryServlet");

		}
		else {

			List<Category> clist=cd.getAll();
			System.out.println(clist);
			session.setAttribute("c",clist);
			response.sendRedirect("Categorylist.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		c.setDescription(description);c.setName(name);
		if(action!=null && action.equals("addcategory")) {
			boolean b=cd.Adduser(c);
			if(b) {
				response.sendRedirect("index.jsp");
			}
			else {
				response.sendRedirect("Error.jsp");
			}
		}
		else {
			if(action!=null && action.equals("updatecategory")) {
				int id=Integer.parseInt(request.getParameter("id"));
				c.setId(id);
				boolean b=cd.updateUser(c);
				if(b) {
					response.sendRedirect("index.jsp");
				}
				else {
					response.sendRedirect("Error.jsp");
				}
			}

		}
	}
}
