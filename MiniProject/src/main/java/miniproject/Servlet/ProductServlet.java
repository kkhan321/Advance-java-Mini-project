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
import miniproject.dao.Productdao;
import miniproject.pojo.Category;
import miniproject.pojo.Product;
@WebServlet("/ProducttServlet")
public class ProductServlet extends HttpServlet {
	Categorydao cd=new Categorydao();
	Product p= new Product();
	Productdao pd=new Productdao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		if(action!=null && action.equals("add")) {
			List<Category> clist=cd.getAll();
			session.setAttribute("c",clist);
			response.sendRedirect("Addproduct.jsp");
			
		}
		else if(action!=null && action.equals("list")){
			List<Product> productlist = pd.getAll();
			session.setAttribute("k",productlist);
			List<Category> clist=cd.getAll();
			session.setAttribute("c",clist);
			response.sendRedirect("productlist.jsp");
		}
		else if(action!=null && action.equals("delete")){
			int id=Integer.parseInt(request.getParameter("id"));
			boolean b=pd.deleteproduct(id);
			if(b) {
				response.sendRedirect("ProducttServlet");
			}
			else {
				response.sendRedirect("Error.jsp");
			}
		}
		else if(action!=null && action.equals("edit")){
			int id=Integer.parseInt(request.getParameter("id"));
			Product p=pd.selectById(id);
			session.setAttribute("k",p);
			List<Category> clist=cd.getAll();
			session.setAttribute("c",clist);
			response.sendRedirect("UpdateProduct.jsp");
		}
		else if(action!=null && action.equals("sort")){
			int cid=Integer.parseInt(request.getParameter("cid"));
			List<Product> plist=pd.getAllProduct(cid);
			session.setAttribute("k",plist);
            response.sendRedirect("productlist.jsp");
		}

		else {
			List<Product> plist = pd.getAllProduct();
			session.setAttribute("p",plist);
			response.sendRedirect("product1list.jsp");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String action = request.getParameter("action");
		String productname=request.getParameter("productname");
		
		if(action!=null && action.equals("addproduct")) {
			double price=Double.parseDouble(request.getParameter("price"));
			String description=request.getParameter("description");
			int categoryId=Integer.parseInt(request.getParameter("categoryid"));
			p.setCategory_id(categoryId);p.setDescription(description);
			p.setPrice(price);p.setProductName(productname);
			
			
			boolean b=pd.Addproduct(p);
			if(b) {
				response.sendRedirect("index.jsp");
			}
			else {
				response.sendRedirect("Error.jsp");
			}
		}
			else if(action!=null && action.equals("updateproduct")) {
				double price=Double.parseDouble(request.getParameter("price"));
				String description=request.getParameter("description");
				int categoryId=Integer.parseInt(request.getParameter("categoryid"));
				p.setCategory_id(categoryId);p.setDescription(description);
				p.setPrice(price);p.setProductName(productname);
				
				int id=Integer.parseInt(request.getParameter("id"));
				p.setId(id);
				boolean b=pd.updateProduct(p);
				if(b) {
					response.sendRedirect("ProducttServlet");
				}
				else {
					response.sendRedirect("Error.jsp");
				}
				
			}
			else if(action!=null && action.equals("searchproduct")) {
				String searchproduct=request.getParameter("search");
				List<Product> productsearch=pd.getAllProduct(searchproduct);
				//taking this list on product list for fetching deatils on search based
				session.setAttribute("k",productsearch);
				List<Category> clist=cd.getAll();
				session.setAttribute("c",clist);
				response.sendRedirect("productlist.jsp");
			}
	
	}

}
