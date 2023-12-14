package miniproject.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import miniproject.dao.Userdao;
import miniproject.pojo.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	Userdao ud=new Userdao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
		
	}	 	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String usertype=request.getParameter("usertype");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		if(usertype!=null && usertype.equals("Admin")) {
			if(email!=null && password!=null && email.equals("admin@gmail.com") && password.equals("123")) {
				System.out.println(usertype+email+password);
				session.setAttribute("Admin", "Admin");
				response.sendRedirect("index.jsp");
			}
			else {
				String lmsg="Invalid userName :"+email+'&'+"password :"+password;
				request.setAttribute("lmsg", lmsg);
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
		}
		
		else if(usertype!=null && usertype.equals("user")) {
        User u=ud.LoginUser(email, password);
        if(u!=null && email.equals(u.getEmail()) && password.equals(u.getPassword())) {
        	session.setAttribute("user", u);
        	response.sendRedirect("index.jsp");
        }
        else {
        	String lmsg="Invalid Username:"+email+ '&' +"password:"+password;
        	request.setAttribute("lmsg", lmsg);
        	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
        	rd.include(request, response);
        }
		
		}		

	}

}
